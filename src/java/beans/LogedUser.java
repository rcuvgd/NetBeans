/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author tomislav
 */
@ManagedBean(name = "logedUser", eager = true)
@SessionScoped
public class LogedUser implements Serializable{

    private final String MESSAGE = "Za nastavak rada potrebno je da se ulogujete";
    private String user = "";
    private String ime;
    private String prezime;
    private String drzava;
    private String region;
    private String grad;
    private String ulica;
    private String ulica2;
    private Long jmb;
    private String tip = "";
    private Boolean loged = false;
    private String password;
    private String message = MESSAGE;
    private String odjavi;
    private String menu;
    private String context;
    private String action;

    public String getPath() {
        message = "Za nastavak rada potrebno je da se ulogujete";
        loged = true;
        tip = "guest";
        if (user.equals("admin") && password.equals("admin")) {
            tip = "administrator";
            message = "Administrator, dobro došao!";
        } else if (user.equals("korisnik") && password.equals("korisnik")) {
            tip = "korisnik";
            message = "Korisnik, dobro došao!";
        } else {
            message = "Greška u logovanju";
            tip = "guest";
            loged = false;
        }

        switch (tip) {
            case "administrator":
                return "/index.xhtml";
            case "korisnik":
                return "/index.xhtml";
            default:
                return "index.xhtml";
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    /**
     *
     * @return
     */
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

    public boolean isLoged() {
        return loged;
    }

    public void setLoged(boolean loged) {
        this.loged = loged;
    }

    public String getMenu() {
        switch (tip) {
            case "administrator":
                menu = "/administracija/adminmenu.xhtml";
                break;
            case "korisnik":
                menu = "/korisnikmenu.xhtml";
                break;
            default:
                menu = "/guestmenu.xhtml";
                break;
        }
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getLogout() {
        message = MESSAGE;
        this.loged = false;
        odjavi = "index.xhtml";
        return odjavi;
    }

    public void setLogout(String logout) {
        this.odjavi = logout;
    }

    public String getOdjavi() {
        message = MESSAGE;
        this.loged = false;
        odjavi = "index.xhtml";
        return odjavi;
    }

    public void setOdjavi(String odjavi) {
        this.odjavi = odjavi;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String editAction() {
        return "index.xhtml";
    }
    
/*
    //action listener event
    public void attrListener(ActionEvent event) {

        action = (String) event.getComponent().getAttributes().get("action");

    }
    
    */
}
