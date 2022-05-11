/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package fpt.aptech.ParkingBookingApi.Controller;

import fpt.aptech.ParkingBookingApi.Dto.ModelRequest.AddQrReq;
import fpt.aptech.ParkingBookingApi.Dto.ModelRequest.TokenReq;
import fpt.aptech.ParkingBookingApi.Entities.Profile;
import fpt.aptech.ParkingBookingApi.Entities.Qrcode;
import fpt.aptech.ParkingBookingApi.ImplementationServices.QrCodeService;
import fpt.aptech.ParkingBookingApi.Utils.JwtUtil;
import fpt.aptech.ParkingBookingApi.Utils.ModelMapperUtil;
import fpt.aptech.ParkingBookingApi.Utils.QrCodeUtil;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author vantu
 */
@RestController
public class QrCodeController {

    @Autowired
    private QrCodeService qrCodeService;
    @Autowired
    private ModelMapperUtil modelMapper;
    @Autowired
    private QrCodeUtil qrCodeUtil;
    @Autowired
    private JwtUtil jwtTokenUtil;

    @RequestMapping(value = "/add-qr-code", method = RequestMethod.POST)
    public ResponseEntity createQrCode(@RequestBody AddQrReq addQrReq) {
        try {
            String username = jwtTokenUtil.extracUsername(addQrReq.getToken());
            byte[] byteCode = qrCodeUtil.generQrCode(addQrReq.getObContent(), 300, 300);
            Qrcode qrcode = modelMapper.map(addQrReq, Qrcode.class);
            qrcode.setAccountid(new Profile(username));
            qrcode.setContent(Arrays.toString(byteCode));
            qrCodeService.create(qrcode);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(value = "/qr-code", method = RequestMethod.POST)
    public ResponseEntity<?> getqrCodeByToken(@RequestBody TokenReq tokenReq, @RequestHeader RequestHeader header) {
        
        String accountid = jwtTokenUtil.extracUsername(tokenReq.getToken());
        return ResponseEntity.ok("asd");
    }
}
