package fpt.aptech.ParkingBookingApi.ImplementationServices;

import fpt.aptech.ParkingBookingApi.InterfaceServices.IAccount;
import fpt.aptech.ParkingBookingApi.Dto.ModelRequest.RegisterReq;
import fpt.aptech.ParkingBookingApi.Entities.*;
import fpt.aptech.ParkingBookingApi.Repositorys.*;
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
    private AccountRep accountRepository;
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account acc = accountRepository.getByUserName(username);
        if (acc != null) {
            List<GrantedAuthority> authoritys = new ArrayList<>();
            authoritys.add(new SimpleGrantedAuthority(acc.getRole()));
            return (UserDetails) new User(acc.getUsername(), acc.getPassword(), authoritys);
        }
        throw new UsernameNotFoundException(username);
    }
    public boolean create(Account account){
     Account acc = accountRepository.getByUserName(account.getUsername());
            if (acc == null) {
                account.setPassword(encryPassword(account.getPassword()));
                accountRepository.save(account);
                return true;
            }else return false;
    }

    public static String encryPassword(String pass) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(pass);

    }

    @Override
    public List<Account> getAccount() {
        return accountRepository.findAll();
    }

        @Override
    public Account getAccountById(String id) {
        Account a = accountRepository.getByUserName(id);
        return a;
    }
    public List<Account> findAll(){
    return accountRepository.findAll();
    }
}
