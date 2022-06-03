/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.ParkingBookingApi.implementations;

import fpt.aptech.ParkingBookingApi.interfaces.IQrCode;
import fpt.aptech.ParkingBookingApi.dto.request.AddQrReq;
import fpt.aptech.ParkingBookingApi.dto.request.AddQrReq;
import fpt.aptech.ParkingBookingApi.dto.response.QrCodeRes;
import fpt.aptech.ParkingBookingApi.entities.Account;
import fpt.aptech.ParkingBookingApi.entities.Profile;
import fpt.aptech.ParkingBookingApi.entities.Qrcode;
import fpt.aptech.ParkingBookingApi.repositorys.QrCodeRepository;
import fpt.aptech.ParkingBookingApi.utils.QrCodeUtil;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fpt.aptech.ParkingBookingApi.repositorys.AccountRep;
import fpt.aptech.ParkingBookingApi.repositorys.ProfileRepository;
import fpt.aptech.ParkingBookingApi.utils.ModelMapperUtil;
import java.util.Base64;

/**
 *
 * @author CHIEN
 */
@Service
public class QrCodeService implements IQrCode {

    @Autowired
    private QrCodeRepository _qrcodeRepository;
    @Autowired
    private AccountRep _accountRepository;
    @Autowired
    private QrCodeUtil _qrCodeUtil;
    @Autowired
    private ModelMapperUtil _modelMapper;
    @Autowired
    private ProfileRepository _profileRepository;
    

    @Override
    public void create(AddQrReq addQrReq, String username) {
        Profile profile = _profileRepository.getByUsername(username);
        if (profile.getUsername().equals(username)) {
            byte[] byteContent = _qrCodeUtil.generQrCode(addQrReq.getContent(), 500, 500);
            String qrcodeString = Base64.getEncoder().encodeToString(byteContent);
            addQrReq.setContent(qrcodeString);
            Qrcode qrcode = _modelMapper.map(addQrReq, Qrcode.class);
            qrcode.setAccountid(profile);
            _qrcodeRepository.save(qrcode);
        }
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
        Qrcode qrcode = _qrcodeRepository.getByUserName(accountid);
        QrCodeRes qrCodeRes = _modelMapper.map(qrcode, QrCodeRes.class);
        return qrCodeRes;
    }

}
