/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.ParkingBookingApplicatiton.Controller;

import fpt.aptech.ParkingBookingApplicatiton.ModelResponse.LoginRes;
import fpt.aptech.ParkingBookingApplicatiton.ModelRequest.RegisterReq;
import fpt.aptech.ParkingBookingApplicatiton.ModelRequest.AuthenticationRequest;
import fpt.aptech.ParkingBookingApplicatiton.Configuration.RestTemplateConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import org.springframework.ui.Model;

/**
 *
 * @author CHIEN
 */
@Controller
public class AccountController {

    private final String uri = "http://localhost:8080/";
    @Autowired
    private RestTemplateConfiguration restTemplate;
//    @Autowired
//    private IntercepterConfiguration intercepterConfiguration;
//    @Autowired
//    private HttpSession session;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("authenticate", new AuthenticationRequest());
        return "user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody AuthenticationRequest authenticationRequest, HttpSession session) {
        HttpEntity request = restTemplate.setRequest(authenticationRequest);
        ResponseEntity<?> response = restTemplate.getResponse(uri + "authenticate", HttpMethod.POST, request, LoginRes.class);
        try {
            LoginRes loginRes = (LoginRes) response.getBody();
            session.setAttribute("token", loginRes.getToken());
            switch (loginRes.getRole()) {
                case user:
                    return "homeuse";
                case admin:
                    return "homeadmin";
                case handle:
                    return "homehandle";
            }
        } catch (Exception e) {
            return "redirect:/login";
        }
        return "error page";
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("register", new RegisterReq());
        return "user/register";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("resigter") RegisterReq registerReq, HttpSession session) {
        HttpEntity request = restTemplate.setRequest(registerReq);
        ResponseEntity<?> response = restTemplate.getResponse(uri + "register", HttpMethod.POST, request, LoginRes.class);
        try {
            LoginRes loginRes = (LoginRes) response.getBody();
            session.setAttribute("token", loginRes.getToken());
            switch (loginRes.getRole()) {
                case user:
                    return "homeuse";
                case admin:
                    return "homeadmin";
                case handle:
                    return "homehandle";
            }
        } catch (Exception e) {
            return "redirect:/register";
        }
        return "error page";
    }    
//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public String getUser(Model model, HttpSession session) {
//        String token = session.getAttribute("token").toString();
//        HttpEntity request = restTemplate.setRequest(token);
//        ResponseEntity<?> response = restTemplate.getResponse(uri + "user?token=" + token, HttpMethod.GET, request, Account.class);
//        Account acc = (Account) response.getBody();
//        model.addAttribute("model", acc);
//        return "user/detailsuser";
//    }
//  @RequestMapping("/user")
//    public String hello() {
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        headers.set("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsInJvbGVzIjpbeyJhdXRob3JpdHkiOiJ1c2VyIn1dLCJleHAiOjE2NTExNTIyMzQsImlhdCI6MTY1MTExNjIzNH0.jOlkYYExtbOYhENec5z3OOrZ15iHq9Qhdnyhvp5JqD8");
//        HttpEntity request = new HttpEntity(headers);
//
//        ResponseEntity<String> response = restTemplate.exchange(uri+"user", HttpMethod.GET, request, String.class);
//        return "";
//    }
//
//    @RequestMapping("/admin")
//    public String admin() {
//        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject(uri+"admin", String.class);
//        return result;
//    }

//       @RequestMapping("/template")
//    public String template(Model model) {
//        model.addAttribute("authenticate", new AuthenticationRequest());
//        return "user/login";
//    }
//    @RequestMapping("/test")
//    public String test() {
//        HttpEntity request = restTemplate1.getRequest("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsInJvbGVzIjpbeyJhdXRob3JpdHkiOiJ1c2VyIn1dLCJleHAiOjE2NTExNTIyMzQsImlhdCI6MTY1MTExNjIzNH0.jOlkYYExtbOYhENec5z3OOrZ15iHq9Qhdnyhvp5JqD8");
//        ResponseEntity<String> response = (ResponseEntity<String>) restTemplate1.getResponse(uri+"user", HttpMethod.GET, request, String.class);
//
//        return "";
//    }
}
