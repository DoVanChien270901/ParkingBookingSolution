package fpt.aptech.ParkingBookingApi.implementations;

import fpt.aptech.ParkingBookingApi.entities.Account;
import fpt.aptech.ParkingBookingApi.repositorys.ProfileRepository;
import fpt.aptech.ParkingBookingApi.repositorys.AccountRep;
import fpt.aptech.ParkingBookingApi.interfaces.IAccount;
import fpt.aptech.ParkingBookingApi.dto.request.RegisterReq;
import fpt.aptech.ParkingBookingApi.utils.ModelMapperUtil;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.*;

/**
 *
 * @author CHIEN
 */
@Service
public class MyUserDetailsService implements UserDetailsService, IAccount {

    @Autowired
    private AccountRep _accountRepository;
    @Autowired
    private ProfileRepository _profileRepository;
    @Autowired
    private ModelMapperUtil _mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account acc = _accountRepository.getByUserName(username);
        if (acc != null) {
            List<GrantedAuthority> authoritys = new ArrayList<>();
            authoritys.add(new SimpleGrantedAuthority(acc.getRole()));
            return (UserDetails) new User(acc.getUsername(), acc.getPassword(), authoritys);
        }
        throw new UsernameNotFoundException(username);
    }

    @Override
    public boolean create(RegisterReq registerReq) {
        Account account = _mapper.map(registerReq, Account.class);
        Account acc = _accountRepository.getByUserName(account.getUsername());
        if (acc == null) {
            account.setPassword(encryPassword(account.getPassword()));
            _accountRepository.save(account);
            return true;
        } else {
            return false;
        }
    }

    public static String encryPassword(String pass) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(pass);

    }

    @Override
    public List<Account> getAccount() {
        return _accountRepository.findAll();
    }

    @Override
    public Account getAccountById(String id) {
        Account a = _accountRepository.getByUserName(id);
        return a;
    }

    @Override
    public List<Account> findAll() {
        return _accountRepository.findAll();
    }
}
