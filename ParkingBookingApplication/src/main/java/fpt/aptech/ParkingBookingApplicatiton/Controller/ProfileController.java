/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/Controller.java to edit this template
 */
package fpt.aptech.ParkingBookingApplicatiton.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author CHIEN
 */
@Controller
public class ProfileController {
    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "view.name";
    }
    
}
