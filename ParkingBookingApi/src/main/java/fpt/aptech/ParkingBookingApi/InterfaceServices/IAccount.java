/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fpt.aptech.ParkingBookingApi.InterfaceServices;

import fpt.aptech.ParkingBookingApi.Entities.Account;
import java.util.List;

/**
 *
 * @author CHIEN
 */
public interface IAccount {
    public List<Account> getAccount();
    public Account getAccountById(String id);
}
