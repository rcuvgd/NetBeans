/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclasses;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author tomislav
 */
@Embeddable
public class ProdajaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "prodizvodid")
    private int prodizvodid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "userid")
    private String userid;

    public ProdajaPK() {
    }

    public ProdajaPK(int prodizvodid, String userid) {
        this.prodizvodid = prodizvodid;
        this.userid = userid;
    }

    public int getProdizvodid() {
        return prodizvodid;
    }

    public void setProdizvodid(int prodizvodid) {
        this.prodizvodid = prodizvodid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) prodizvodid;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdajaPK)) {
            return false;
        }
        ProdajaPK other = (ProdajaPK) object;
        if (this.prodizvodid != other.prodizvodid) {
            return false;
        }
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityclasses.ProdajaPK[ prodizvodid=" + prodizvodid + ", userid=" + userid + " ]";
    }
    
}
