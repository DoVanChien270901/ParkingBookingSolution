/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/Repository.java to edit this template
 */
package fpt.aptech.ParkingBookingApi.Repositorys;

import fpt.aptech.ParkingBookingApi.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author CHIEN
 */
public interface AccountRep extends JpaRepository<Account, String> {
    @Query("SELECT a FROM Account a WHERE a.username = :username")
    Account getByUserName(@PathVariable("username") String username);
}
