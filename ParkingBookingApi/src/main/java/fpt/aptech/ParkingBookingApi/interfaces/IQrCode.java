/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fpt.aptech.ParkingBookingApi.interfaces;

import fpt.aptech.ParkingBookingApi.dto.request.AddQrReq;
import fpt.aptech.ParkingBookingApi.dto.request.AddQrReq;
import fpt.aptech.ParkingBookingApi.dto.response.QrCodeRes;
import fpt.aptech.ParkingBookingApi.entities.Qrcode;

/**
 *
 * @author CHIEN
 */
public interface IQrCode {
    void create(AddQrReq addQrReq, String username);
    Boolean delete(Qrcode qrcode);
    Boolean edit(Qrcode qrcode);
    QrCodeRes qrCodeRes(String accountid);
}
