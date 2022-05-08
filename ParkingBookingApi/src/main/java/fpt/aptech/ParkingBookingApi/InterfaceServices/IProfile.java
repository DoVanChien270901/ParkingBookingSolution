/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.ParkingBookingApi.InterfaceServices;

import fpt.aptech.ParkingBookingApi.Dto.ModelRequest.TokenReq;
import fpt.aptech.ParkingBookingApi.Entities.Profile;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author CHIEN
 */
public interface IProfile {
    Page<Profile> findAll(int page, int size);
    Profile getByUserName(String username);
    void create(Profile profile);
}
