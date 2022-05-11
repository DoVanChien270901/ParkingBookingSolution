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
public class AddQrReq {

    private Object obContent;
    private String token;
    private String title;

    public AddQrReq() {
    }

    public Object getObContent() {
        return obContent;
    }

    public void setObContent(Object obContent) {
        this.obContent = obContent;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
