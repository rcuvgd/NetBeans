/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclasses;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tomislav
 */
@Entity
@Table(name = "prodaja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prodaja.findAll", query = "SELECT p FROM Prodaja p"),
    @NamedQuery(name = "Prodaja.findByProdizvodid", query = "SELECT p FROM Prodaja p WHERE p.prodajaPK.prodizvodid = :prodizvodid"),
    @NamedQuery(name = "Prodaja.findByUserid", query = "SELECT p FROM Prodaja p WHERE p.prodajaPK.userid = :userid"),
    @NamedQuery(name = "Prodaja.findByKolicina", query = "SELECT p FROM Prodaja p WHERE p.kolicina = :kolicina")})
public class Prodaja implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProdajaPK prodajaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kolicina")
    private int kolicina;
    @JoinColumn(name = "prodizvodid", referencedColumnName = "proizvodid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proizvod proizvod;
    @JoinColumn(name = "userid", referencedColumnName = "user", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    public Prodaja() {
    }

    public Prodaja(ProdajaPK prodajaPK) {
        this.prodajaPK = prodajaPK;
    }

    public Prodaja(ProdajaPK prodajaPK, int kolicina) {
        this.prodajaPK = prodajaPK;
        this.kolicina = kolicina;
    }

    public Prodaja(int prodizvodid, String userid) {
        this.prodajaPK = new ProdajaPK(prodizvodid, userid);
    }

    public ProdajaPK getProdajaPK() {
        return prodajaPK;
    }

    public void setProdajaPK(ProdajaPK prodajaPK) {
        this.prodajaPK = prodajaPK;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodajaPK != null ? prodajaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prodaja)) {
            return false;
        }
        Prodaja other = (Prodaja) object;
        if ((this.prodajaPK == null && other.prodajaPK != null) || (this.prodajaPK != null && !this.prodajaPK.equals(other.prodajaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityclasses.Prodaja[ prodajaPK=" + prodajaPK + " ]";
    }
    
}
