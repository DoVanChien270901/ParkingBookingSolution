/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.ParkingBookingApi.Dto.ModelRequest;

import fpt.aptech.ParkingBookingApi.Entities.Account;

/**
 *
 * @author CHIEN
 */
public class QrCodeReq {
    private int id;
    private Object obContent;
    private String account;

    public QrCodeReq() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getObContent() {
        return obContent;
    }

    public void setObContent(Object obContent) {
        this.obContent = obContent;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
