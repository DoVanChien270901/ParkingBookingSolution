/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/Repository.java to edit this template
 */
package fpt.aptech.ParkingBookingApi.Repositorys;

import fpt.aptech.ParkingBookingApi.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author CHIEN
 */
public interface AccountRepository extends JpaRepository<Account, String> {
    
}
