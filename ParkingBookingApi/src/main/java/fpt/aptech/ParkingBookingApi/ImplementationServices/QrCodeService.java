/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.ParkingBookingApi.ImplementationServices;

import fpt.aptech.ParkingBookingApi.InterfaceServices.IQrCode;
import fpt.aptech.ParkingBookingApi.Dto.ModelRequest.AddQrReq;
import fpt.aptech.ParkingBookingApi.Dto.ModelResponse.QrCodeRes;
import fpt.aptech.ParkingBookingApi.Entities.Account;
import fpt.aptech.ParkingBookingApi.Entities.Qrcode;
import fpt.aptech.ParkingBookingApi.Repositorys.QrCodeRepository;
import fpt.aptech.ParkingBookingApi.Utils.QrCodeUtil;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fpt.aptech.ParkingBookingApi.Repositorys.AccountRep;
import fpt.aptech.ParkingBookingApi.Utils.ModelMapperUtil;

/**
 *
 * @author CHIEN
 */
@Service
public class QrCodeService implements IQrCode {

    @Autowired
    private QrCodeRepository qrcodeRepository;
    @Autowired
    private AccountRep accountRepository;
    @Autowired
    private QrCodeUtil codeUtil;
   @Autowired 
   private ModelMapperUtil modelMapper;
    

    @Override
    public void create(Qrcode qrcode) {
        qrcodeRepository.save(qrcode);
    }

    @Override
    public Boolean delete(Qrcode qrCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean edit(Qrcode qrCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public QrCodeRes qrCodeRes(String accountid) {
        Qrcode qrcode = qrcodeRepository.getByAccointId(accountid);
        QrCodeRes qrCodeRes = modelMapper.map(qrcode, QrCodeRes.class);
        return qrCodeRes;
    }

}
