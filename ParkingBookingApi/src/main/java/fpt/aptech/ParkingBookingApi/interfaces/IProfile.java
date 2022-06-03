/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.ParkingBookingApi.interfaces;

import fpt.aptech.ParkingBookingApi.dto.request.RegisterReq;
import fpt.aptech.ParkingBookingApi.dto.request.EditProfileReq;
import fpt.aptech.ParkingBookingApi.dto.response.PageProfileRes;
import fpt.aptech.ParkingBookingApi.dto.response.ProfileRes;

/**
 *
 * @author CHIEN
 */
public interface IProfile {
    PageProfileRes findAll(int page, int size);
    ProfileRes getByUserName(String username);
    void create(RegisterReq registerReq);
    boolean edit(EditProfileReq editProfileReq);
}
