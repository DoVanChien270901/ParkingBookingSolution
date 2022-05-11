/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fpt.aptech.ParkingBookingApi.InterfaceServices;

import fpt.aptech.ParkingBookingApi.Dto.ModelRequest.AddQrReq;
import fpt.aptech.ParkingBookingApi.Dto.ModelResponse.QrCodeRes;
import fpt.aptech.ParkingBookingApi.Entities.Qrcode;

/**
 *
 * @author CHIEN
 */
public interface IQrCode {
    void create(Qrcode qrcode);
    Boolean delete(Qrcode qrcode);
    Boolean edit(Qrcode qrcode);
    QrCodeRes qrCodeRes(String accountid);
}
