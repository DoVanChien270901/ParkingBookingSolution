/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.ParkingBookingApi.implementations;

import fpt.aptech.ParkingBookingApi.dto.request.EditProfileReq;
import fpt.aptech.ParkingBookingApi.dto.request.RegisterReq;
import fpt.aptech.ParkingBookingApi.interfaces.IProfile;
import fpt.aptech.ParkingBookingApi.dto.response.PageProfileRes;
import fpt.aptech.ParkingBookingApi.dto.response.ProfileRes;
import fpt.aptech.ParkingBookingApi.entities.Profile;
import fpt.aptech.ParkingBookingApi.entities.Qrcode;
import fpt.aptech.ParkingBookingApi.repositorys.ProfileRepository;
import fpt.aptech.ParkingBookingApi.repositorys.QrCodeRepository;
import fpt.aptech.ParkingBookingApi.utils.ModelMapperUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author CHIEN
 */
@Service
public class ProfileService implements IProfile {

    @Autowired
    private ProfileRepository _profileRepository;
    @Autowired
    private QrCodeRepository _qrCodeRepository;
    @Autowired
    private ModelMapperUtil _mapper;
    

    @Override
    public PageProfileRes findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Profile> pageprofile = _profileRepository.findAll(pageRequest);
            List<ProfileRes> listpro = _mapper.mapList(pageprofile.getContent(), ProfileRes.class);
            PageProfileRes pageProfileRes = new PageProfileRes();
            pageProfileRes.setListProfile(listpro);
            pageProfileRes.setCurrentPage(pageprofile.getPageable().getPageNumber());
            pageProfileRes.setSize(pageprofile.getSize());
            pageProfileRes.setTotalPages(pageprofile.getTotalPages());
        return pageProfileRes;
    }

    @Override
    public ProfileRes getByUserName(String username) {
        Profile profile =  _profileRepository.getByUsername(username);
        ProfileRes pres = _mapper.map(profile, ProfileRes.class);
        Qrcode qrcode = _qrCodeRepository.getByUserName(username);
        pres.setQrContent(qrcode.getContent());
        return pres;
    }

    @Override
    public void create(RegisterReq registerReq) {
        Profile profile = _mapper.map(registerReq, Profile.class);
        _profileRepository.save(profile);
    }

    @Override
    public boolean edit(EditProfileReq editProfileReq) {
        Profile profile = _mapper.map(editProfileReq, Profile.class);
        Profile oldProfile = _profileRepository.getByUsername(profile.getUsername());
        if (oldProfile != null) {
            _profileRepository.save(profile);
            return true;
        } else {
            return false;
        }
    }
}
