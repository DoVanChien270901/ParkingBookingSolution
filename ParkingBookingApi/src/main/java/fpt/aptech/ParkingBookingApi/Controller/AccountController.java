/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.ParkingBookingApi.Controller;

import fpt.aptech.ParkingBookingApi.Dto.ModelRequest.*;
import fpt.aptech.ParkingBookingApi.Dto.ModelResponse.*;
import fpt.aptech.ParkingBookingApi.Entities.*;
import fpt.aptech.ParkingBookingApi.ImplementationServices.*;
import fpt.aptech.ParkingBookingApi.Utils.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author CHIEN
 */
@RestController
public class AccountController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private ModelMapperUtil mapper;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticate(@RequestBody AuthenticateReq authenticateRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(), authenticateRequest.getPassword())
            );
        } catch (AuthenticationException e) {
            return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticateRequest.getUsername());
        final String jwt = jwtTokenUtil.generrateToken(userDetails);
        LoginRes res = new LoginRes();
        res.setToken(jwt);
        Object[] role = userDetails.getAuthorities().toArray();
        res.setRole(Roles.valueOf(role[0].toString()));
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody RegisterReq registerRequest) {
        Account account = mapper.map(registerRequest, Account.class);
        boolean result = userDetailsService.create(account);
        if (result == true) {
            Profile profile = mapper.map(registerRequest, Profile.class);
            profileService.create(profile);
            final UserDetails userDetails = userDetailsService
                    .loadUserByUsername(registerRequest.getUsername());
            final String jwt = jwtTokenUtil.generrateToken(userDetails);
            LoginRes res = new LoginRes();
            res.setToken(jwt);
            Object[] role = userDetails.getAuthorities().toArray();
            res.setRole(Roles.valueOf(role[0].toString()));
            return ResponseEntity.ok(res);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/list-users", method = RequestMethod.GET)
    public ResponseEntity<?> listusers(@RequestParam("page") int page, @RequestParam("size") int size) {
        try {
            Page<Profile> pageprofile = profileService.findAll(page, size);
            List<ProfileRes> listpro = mapper.mapList(pageprofile.getContent(), ProfileRes.class);
            PageProfileRes pageProfileRes = new PageProfileRes();
            pageProfileRes.setListProfile(listpro);
            pageProfileRes.setCurrentPage(pageprofile.getPageable().getPageNumber());
            pageProfileRes.setSize(pageprofile.getSize());
            pageProfileRes.setTotalPages(pageprofile.getTotalPages());
            return new ResponseEntity(pageProfileRes, HttpStatus.OK);
        } catch (Exception e) {
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<?> getUserByToken(@RequestHeader("Authorization") String token) {
        try {
            String username = jwtTokenUtil.extracUsername(token.substring(7));
            Profile profile = profileService.getByUserName(username);
            ProfileRes pres = mapper.map(profile, ProfileRes.class);
            return new ResponseEntity(pres, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

//    //test
//    @RequestMapping(value = "/list-accounts", method = RequestMethod.GET)
//    public List<Account> getListUser() {
//        return userDetailsService.findAll();
//    }
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ResponseEntity editUser(@RequestBody EditProfileReq editProfileReq, @RequestHeader("Authorization") String token) {
        try {
            String username = jwtTokenUtil.extracUsername(token.substring(7));
            Profile profile = mapper.map(editProfileReq, Profile.class);
            profile.setUsername(username);
            profileService.edit(profile);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        }
    }
}
