/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.ParkingBookingApplicatiton.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author CHIEN
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    @RequestMapping("/index")
    public String home(){
    return "user/home";
    }
}
