/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.ParkingBookingApplicatiton.Controller;

import fpt.aptech.ParkingBookingApplicatiton.ModelResponse.LoginRes;
import fpt.aptech.ParkingBookingApplicatiton.ModelRequest.RegisterReq;
import fpt.aptech.ParkingBookingApplicatiton.ModelRequest.AuthenticateReq;
import fpt.aptech.ParkingBookingApplicatiton.Configuration.RestTemplateConfiguration;
import fpt.aptech.ParkingBookingApplicatiton.ModelResponse.Roles;
import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.*;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author CHIEN
 */
@Controller
@RequestMapping("account")
public class AccountController {

    private final String uri = "http://localhost:8080/";
    @Autowired
    private RestTemplateConfiguration restTemplate;
//    @Autowired
//    private IntercepterConfiguration intercepterConfiguration;
//    @Autowired
//    private HttpSession session;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@ModelAttribute("authenticate") AuthenticateReq authenticate) {
        return "layouts/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid @ModelAttribute("authenticate") AuthenticateReq authenticateReq,
            BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors() == false) {
            try {
                HttpEntity request = restTemplate.setRequest(authenticateReq);
                ResponseEntity<?> response = restTemplate.excuteRequest(uri + "authenticate", HttpMethod.POST, request, LoginRes.class);
                if (response.getStatusCode() == HttpStatus.OK) {
                    LoginRes loginRes = (LoginRes) response.getBody();
                    session.setAttribute("token", loginRes.getToken());
                    switch (loginRes.getRole()) {
                        case user:
                            return "redirect:/home/user";
                        case admin:
                            return "redirect:/home/admin";
                        case handle:
                            return "redirect:/home/handler";
                        default:
                            return "redirect:/login";
                    }
                } else {
                    return "redirect:/login";
                }
            } catch (Exception e) {
                return "redirect:/login";
            }
        } else {
            return "layouts/login";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(@ModelAttribute("registerReq") RegisterReq registerReq) {
        return "layouts/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("registerReq") RegisterReq registerReq, BindingResult bindingResult, HttpSession session, @RequestParam("dateofbirth") @DateTimeFormat(pattern = "dd.MM.yyyy") Date date) {
        if (bindingResult.hasErrors() == false) {
            HttpEntity request = restTemplate.setRequest(registerReq);
            ResponseEntity<?> response = restTemplate.excuteRequest(uri + "register", HttpMethod.POST, request, LoginRes.class);
            try {
                if (response.getStatusCode() == HttpStatus.OK) {
                    LoginRes loginRes = (LoginRes) response.getBody();
                    session.setAttribute("token", loginRes.getToken());
                    return "user/index";
                } else {
                    return "redirect:/register";
                }
            } catch (Exception e) {
                return "redirect:/register";
            }
        } else {
            return "layouts/register";
        }
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
