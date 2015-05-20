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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "proizvod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proizvod.findAll", query = "SELECT p FROM Proizvod p"),
    @NamedQuery(name = "Proizvod.findByProizvodid", query = "SELECT p FROM Proizvod p WHERE p.proizvodid = :proizvodid"),
    @NamedQuery(name = "Proizvod.findByNaziv", query = "SELECT p FROM Proizvod p WHERE p.naziv = :naziv"),
    @NamedQuery(name = "Proizvod.findByCena", query = "SELECT p FROM Proizvod p WHERE p.cena = :cena")})
public class Proizvod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proizvodid")
    private Integer proizvodid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cena")
    private long cena;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proizvod")
    private Collection<Prodaja> prodajaCollection;

    public Proizvod() {
    }

    public Proizvod(Integer proizvodid) {
        this.proizvodid = proizvodid;
    }

    public Proizvod(Integer proizvodid, String naziv, long cena) {
        this.proizvodid = proizvodid;
        this.naziv = naziv;
        this.cena = cena;
    }

    public Integer getProizvodid() {
        return proizvodid;
    }

    public void setProizvodid(Integer proizvodid) {
        this.proizvodid = proizvodid;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public long getCena() {
        return cena;
    }

    public void setCena(long cena) {
        this.cena = cena;
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
        hash += (proizvodid != null ? proizvodid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proizvod)) {
            return false;
        }
        Proizvod other = (Proizvod) object;
        if ((this.proizvodid == null && other.proizvodid != null) || (this.proizvodid != null && !this.proizvodid.equals(other.proizvodid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityclasses.Proizvod[ proizvodid=" + proizvodid + " ]";
    }
    
}
