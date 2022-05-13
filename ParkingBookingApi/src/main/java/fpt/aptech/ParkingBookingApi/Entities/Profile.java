/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.ParkingBookingApi.Entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.boot.context.properties.bind.DefaultValue;

/**
 *
 * @author vantu
 */
@Entity
@Table(name = "profile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p"),
    @NamedQuery(name = "Profile.findByUsername", query = "SELECT p FROM Profile p WHERE p.username = :username"),
    @NamedQuery(name = "Profile.findByFullname", query = "SELECT p FROM Profile p WHERE p.fullname = :fullname"),
    @NamedQuery(name = "Profile.findByIdentitycard", query = "SELECT p FROM Profile p WHERE p.identitycard = :identitycard"),
    @NamedQuery(name = "Profile.findByBalance", query = "SELECT p FROM Profile p WHERE p.balance = :balance"),
    @NamedQuery(name = "Profile.findByDob", query = "SELECT p FROM Profile p WHERE p.dob = :dob"),
    @NamedQuery(name = "Profile.findByEmail", query = "SELECT p FROM Profile p WHERE p.email = :email"),
    @NamedQuery(name = "Profile.findByPhone", query = "SELECT p FROM Profile p WHERE p.phone = :phone")})
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "username")
    private String username;
    @Size(max = 50)
    @Column(name = "fullname")
    private String fullname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "identitycard")
    private int identitycard;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "balance", nullable = false)
    private Double balance = 0.0;
    @Column(name = "dob")
    private LocalDate dob;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private Integer phone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountid")
    private Collection<Rated> ratedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountid")
    private Collection<Booking> bookingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountid")
    private Collection<Qrcode> qrcodeCollection;
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Account account;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountid")
    private Collection<Rechargehistory> rechargehistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountid")
    private Collection<Vehicle> vehicleCollection;

    public Profile() {
    }

    public Profile(String username) {
        this.username = username;
    }

    public Profile(String username, int identitycard) {
        this.username = username;
        this.identitycard = identitycard;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getIdentitycard() {
        return identitycard;
    }

    public void setIdentitycard(int identitycard) {
        this.identitycard = identitycard;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
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

    @XmlTransient
    public Collection<Rated> getRatedCollection() {
        return ratedCollection;
    }

    public void setRatedCollection(Collection<Rated> ratedCollection) {
        this.ratedCollection = ratedCollection;
    }

    @XmlTransient
    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    @XmlTransient
    public Collection<Qrcode> getQrcodeCollection() {
        return qrcodeCollection;
    }

    public void setQrcodeCollection(Collection<Qrcode> qrcodeCollection) {
        this.qrcodeCollection = qrcodeCollection;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @XmlTransient
    public Collection<Rechargehistory> getRechargehistoryCollection() {
        return rechargehistoryCollection;
    }

    public void setRechargehistoryCollection(Collection<Rechargehistory> rechargehistoryCollection) {
        this.rechargehistoryCollection = rechargehistoryCollection;
    }

    @XmlTransient
    public Collection<Vehicle> getVehicleCollection() {
        return vehicleCollection;
    }

    public void setVehicleCollection(Collection<Vehicle> vehicleCollection) {
        this.vehicleCollection = vehicleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fpt.aptech.ParkingBookingApi.Entities.Profile[ username=" + username + " ]";
    }

}
