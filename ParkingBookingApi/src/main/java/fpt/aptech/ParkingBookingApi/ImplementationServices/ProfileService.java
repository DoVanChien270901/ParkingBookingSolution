/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.ParkingBookingApi.ImplementationServices;

import fpt.aptech.ParkingBookingApi.Dto.ModelRequest.EditProfileReq;
import fpt.aptech.ParkingBookingApi.InterfaceServices.IProfile;
import fpt.aptech.ParkingBookingApi.Dto.ModelRequest.TokenReq;
import fpt.aptech.ParkingBookingApi.Entities.Profile;
import fpt.aptech.ParkingBookingApi.Repositorys.ProfileRepository;
import fpt.aptech.ParkingBookingApi.Utils.ModelMapperUtil;
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
    private ProfileRepository profileRepository;
    @Autowired
    private ModelMapperUtil mapper;

    @Override
    public Page<Profile> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return profileRepository.findAll(pageRequest);
    }

    @Override
    public Profile getByUserName(String username) {
        return profileRepository.getByUsername(username);
    }

    @Override
    public void create(Profile profile) {
        profileRepository.save(profile);
    }

    @Override
    public boolean edit(Profile profile) {
        Profile oldProfile = profileRepository.getByUsername(profile.getUsername().getUsername());
        if (oldProfile != null) {
            profileRepository.save(profile);
            return true;
        } else {
            return false;
        }
    }
}
