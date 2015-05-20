/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclasses;

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
 * @author tomislav
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUser", query = "SELECT u FROM Users u WHERE u.user = :user"),
    @NamedQuery(name = "Users.findByIme", query = "SELECT u FROM Users u WHERE u.ime = :ime"),
    @NamedQuery(name = "Users.findByPrezime", query = "SELECT u FROM Users u WHERE u.prezime = :prezime"),
    @NamedQuery(name = "Users.findByDrzava", query = "SELECT u FROM Users u WHERE u.drzava = :drzava"),
    @NamedQuery(name = "Users.findByRegion", query = "SELECT u FROM Users u WHERE u.region = :region"),
    @NamedQuery(name = "Users.findByGrad", query = "SELECT u FROM Users u WHERE u.grad = :grad"),
    @NamedQuery(name = "Users.findByUlica", query = "SELECT u FROM Users u WHERE u.ulica = :ulica"),
    @NamedQuery(name = "Users.findByUlica2", query = "SELECT u FROM Users u WHERE u.ulica2 = :ulica2"),
    @NamedQuery(name = "Users.findByJmb", query = "SELECT u FROM Users u WHERE u.jmb = :jmb"),
    @NamedQuery(name = "Users.findByTip", query = "SELECT u FROM Users u WHERE u.tip = :tip"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "user")
    private String user;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "ime")
    private String ime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "prezime")
    private String prezime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "drzava")
    private String drzava;
    @Size(max = 50)
    @Column(name = "region")
    private String region;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "grad")
    private String grad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "ulica")
    private String ulica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "ulica2")
    private String ulica2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jmb")
    private long jmb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "tip")
    private String tip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<Prodaja> prodajaCollection;

    public Users() {
    }

    public Users(String user) {
        this.user = user;
    }

    public Users(String user, String ime, String prezime, String drzava, String grad, String ulica, String ulica2, long jmb, String tip, String password) {
        this.user = user;
        this.ime = ime;
        this.prezime = prezime;
        this.drzava = drzava;
        this.grad = grad;
        this.ulica = ulica;
        this.ulica2 = ulica2;
        this.jmb = jmb;
        this.tip = tip;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getUlica2() {
        return ulica2;
    }

    public void setUlica2(String ulica2) {
        this.ulica2 = ulica2;
    }

    public long getJmb() {
        return jmb;
    }

    public void setJmb(long jmb) {
        this.jmb = jmb;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Prodaja> getProdajaCollection() {
        return prodajaCollection;
    }

    public void setProdajaCollection(Collection<Prodaja> prodajaCollection) {
        this.prodajaCollection = prodajaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (user != null ? user.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.user == null && other.user != null) || (this.user != null && !this.user.equals(other.user))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityclasses.Users[ user=" + user + " ]";
    }
    
}
