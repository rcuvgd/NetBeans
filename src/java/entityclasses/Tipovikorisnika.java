/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclasses;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tomislav
 */
@Entity
@Table(name = "tipovikorisnika")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipovikorisnika.findAll", query = "SELECT t FROM Tipovikorisnika t"),
    @NamedQuery(name = "Tipovikorisnika.findByTipovikorisnika", query = "SELECT t FROM Tipovikorisnika t WHERE t.tipovikorisnika = :tipovikorisnika"),
    @NamedQuery(name = "Tipovikorisnika.findByTipovikorisnikaid", query = "SELECT t FROM Tipovikorisnika t WHERE t.tipovikorisnikaid = :tipovikorisnikaid")})
public class Tipovikorisnika implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "tipovikorisnika")
    private String tipovikorisnika;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipovikorisnikaid")
    private Integer tipovikorisnikaid;

    public Tipovikorisnika() {
    }

    public Tipovikorisnika(Integer tipovikorisnikaid) {
        this.tipovikorisnikaid = tipovikorisnikaid;
    }

    public Tipovikorisnika(Integer tipovikorisnikaid, String tipovikorisnika) {
        this.tipovikorisnikaid = tipovikorisnikaid;
        this.tipovikorisnika = tipovikorisnika;
    }

    public String getTipovikorisnika() {
        return tipovikorisnika;
    }

    public void setTipovikorisnika(String tipovikorisnika) {
        this.tipovikorisnika = tipovikorisnika;
    }

    public Integer getTipovikorisnikaid() {
        return tipovikorisnikaid;
    }

    public void setTipovikorisnikaid(Integer tipovikorisnikaid) {
        this.tipovikorisnikaid = tipovikorisnikaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipovikorisnikaid != null ? tipovikorisnikaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipovikorisnika)) {
            return false;
        }
        Tipovikorisnika other = (Tipovikorisnika) object;
        if ((this.tipovikorisnikaid == null && other.tipovikorisnikaid != null) || (this.tipovikorisnikaid != null && !this.tipovikorisnikaid.equals(other.tipovikorisnikaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityclasses.Tipovikorisnika[ tipovikorisnikaid=" + tipovikorisnikaid + " ]";
    }
    
}
