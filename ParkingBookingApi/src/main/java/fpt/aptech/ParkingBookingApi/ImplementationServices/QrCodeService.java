/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.ParkingBookingApi.ImplementationServices;

import fpt.aptech.ParkingBookingApi.InterfaceServices.IQrCode;
import fpt.aptech.ParkingBookingApi.Dto.ModelRequest.QrCodeReq;
import fpt.aptech.ParkingBookingApi.Entities.Account;
import fpt.aptech.ParkingBookingApi.Entities.Qrcode;
import fpt.aptech.ParkingBookingApi.Repositorys.QrCodeRepository;
import fpt.aptech.ParkingBookingApi.Utils.QrCodeUtil;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fpt.aptech.ParkingBookingApi.Repositorys.AccountRep;

/**
 *
 * @author CHIEN
 */
@Service
public class QrCodeService implements IQrCode{
@Autowired
private QrCodeRepository qrcodeRepository;
@Autowired
private AccountRep accountRepository;
@Autowired
private QrCodeUtil codeUtil;

    @Override
    public Boolean create(QrCodeReq qrCodeRequest) {
        Account acc = accountRepository.getByUserName(qrCodeRequest.getAccount());
        if (acc!=null) {
            Qrcode qrcode = new Qrcode();
            qrcode.setAccountid(acc);
            qrcode.setContent(Arrays.toString(codeUtil.generQrCode(qrCodeRequest.getObContent(), 300, 300)));
            qrcodeRepository.save(qrcode);
            return true;
        }else return false;
    }

    @Override
    public Boolean delete(QrCodeReq qrCodeRequest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean edit(QrCodeReq qrCodeRequest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
