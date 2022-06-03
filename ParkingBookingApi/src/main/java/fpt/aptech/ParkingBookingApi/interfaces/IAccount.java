/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fpt.aptech.ParkingBookingApi.interfaces;

import fpt.aptech.ParkingBookingApi.dto.request.RegisterReq;
import fpt.aptech.ParkingBookingApi.entities.Account;
import java.util.List;

/**
 *
 * @author CHIEN
 */
public interface IAccount {
    public boolean create(RegisterReq registerReq);
    public List<Account> getAccount();
    public Account getAccountById(String id);
    public List<Account> findAll();
}
