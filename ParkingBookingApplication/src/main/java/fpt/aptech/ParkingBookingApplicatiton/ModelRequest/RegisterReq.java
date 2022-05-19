/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.ParkingBookingApplicatiton.ModelRequest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author CHIEN
 */
public class RegisterReq {

    @Size(min = 6, max = 25, message = "Username must be between 6 and 25 characters")
    private String username;
    @Size(min = 6, max = 12, message = "Password must be between 6 and 12 characters")
    private String password;
    //@Size(min = 8, max = 12, message = "Identitycard must be between 8 and 12 characters")
    @NotNull(message = "Identity Card is required")
    private Integer identitycard;
    @NotEmpty(message = "full name is required")
    private String fullname;
    //@NotBlank(message = "Day of birth is required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "Date of birth is required")
    private LocalDate dob;
    @Email(message = "Email is not math")
    @NotEmpty(message = "Email is not empty")
    private String email;
    @NotNull(message = "Phone is required")
    private Integer phone;
    private String confirmpassword;
    
    public RegisterReq() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdentitycard() {
        return identitycard;
    }

    public void setIdentitycard(Integer identitycard) {
        this.identitycard = identitycard;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
    @AssertTrue(message = "Passwords should match")
    public boolean isEquaPassword() {
        return (password == null) ? false : confirmpassword.equals(password);
    }
}
