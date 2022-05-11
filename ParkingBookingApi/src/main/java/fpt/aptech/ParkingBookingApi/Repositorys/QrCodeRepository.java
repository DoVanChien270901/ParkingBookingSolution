/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/Repository.java to edit this template
 */
package fpt.aptech.ParkingBookingApi.Repositorys;

import fpt.aptech.ParkingBookingApi.Entities.Account;
import fpt.aptech.ParkingBookingApi.Entities.Qrcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author CHIEN
 */
public interface QrCodeRepository extends JpaRepository<Qrcode, Integer> {
    
    @Query("SELECT q FROM Qrcode q WHERE q.accountid.username = :username")
    Qrcode getByAccointId(@PathVariable("username") String username);
}
