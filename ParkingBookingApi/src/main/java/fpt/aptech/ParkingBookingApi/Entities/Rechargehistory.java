/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.ParkingBookingApi.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vantu
 */
@Entity
@Table(name = "rechargehistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rechargehistory.findAll", query = "SELECT r FROM Rechargehistory r"),
    @NamedQuery(name = "Rechargehistory.findById", query = "SELECT r FROM Rechargehistory r WHERE r.id = :id"),
    @NamedQuery(name = "Rechargehistory.findByAmount", query = "SELECT r FROM Rechargehistory r WHERE r.amount = :amount"),
    @NamedQuery(name = "Rechargehistory.findByDatetime", query = "SELECT r FROM Rechargehistory r WHERE r.datetime = :datetime")})
public class Rechargehistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @JoinColumn(name = "accountid", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Profile accountid;

    public Rechargehistory() {
    }

    public Rechargehistory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Profile getAccountid() {
        return accountid;
    }

    public void setAccountid(Profile accountid) {
        this.accountid = accountid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rechargehistory)) {
            return false;
        }
        Rechargehistory other = (Rechargehistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fpt.aptech.ParkingBookingApi.Entities.Rechargehistory[ id=" + id + " ]";
    }
    
}
