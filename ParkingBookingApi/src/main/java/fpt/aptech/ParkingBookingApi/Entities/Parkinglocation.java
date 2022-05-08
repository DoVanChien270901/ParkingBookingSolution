/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.ParkingBookingApi.Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CHIEN
 */
@Entity
@Table(name = "parkinglocation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parkinglocation.findAll", query = "SELECT p FROM Parkinglocation p"),
    @NamedQuery(name = "Parkinglocation.findByCodelocation", query = "SELECT p FROM Parkinglocation p WHERE p.codelocation = :codelocation"),
    @NamedQuery(name = "Parkinglocation.findByStatus", query = "SELECT p FROM Parkinglocation p WHERE p.status = :status")})
public class Parkinglocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "codelocation")
    private String codelocation;
    @Size(max = 20)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationcode")
    private Collection<Booking> bookingCollection;

    public Parkinglocation() {
    }

    public Parkinglocation(String codelocation) {
        this.codelocation = codelocation;
    }

    public String getCodelocation() {
        return codelocation;
    }

    public void setCodelocation(String codelocation) {
        this.codelocation = codelocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codelocation != null ? codelocation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parkinglocation)) {
            return false;
        }
        Parkinglocation other = (Parkinglocation) object;
        if ((this.codelocation == null && other.codelocation != null) || (this.codelocation != null && !this.codelocation.equals(other.codelocation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fpt.aptech.ParkingBookingApi.Models.Parkinglocation[ codelocation=" + codelocation + " ]";
    }
    
}
