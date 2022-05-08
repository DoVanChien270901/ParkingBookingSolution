/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fpt.aptech.ParkingBookingApi.InterfaceServices;

import fpt.aptech.ParkingBookingApi.Dto.ModelRequest.QrCodeReq;
import fpt.aptech.ParkingBookingApi.Entities.Qrcode;

/**
 *
 * @author CHIEN
 */
public interface IQrCode {
    public Boolean create(QrCodeReq qrCodeRequest);
    public Boolean delete(QrCodeReq qrCodeRequest);
    public Boolean edit(QrCodeReq qrCodeRequest);
}
