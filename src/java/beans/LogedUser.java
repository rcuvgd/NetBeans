/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author tomislav
 */
@ManagedBean(name = "logedUserX", eager = true)
@SessionScoped
public class LogedUser implements Serializable{
    public static final String PROP_USER = "PROP_USER";
    public static final String PROP_IME = "PROP_IME";
    public static final String PROP_PREZIME = "PROP_PREZIME";
    public static final String PROP_DRZAVA = "PROP_DRZAVA";
    public static final String PROP_REGION = "PROP_REGION";
    public static final String PROP_GRAD = "PROP_GRAD";
    public static final String PROP_ULICA = "PROP_ULICA";
    public static final String PROP_ULICA2 = "PROP_ULICA2";
    public static final String PROP_JMB = "PROP_JMB";
    public static final String PROP_TIP = "PROP_TIP";
    public static final String PROP_LOGED = "PROP_LOGED";
    public static final String PROP_PASSWORD = "PROP_PASSWORD";
    public static final String PROP_MESSAGE = "PROP_MESSAGE";
    public static final String PROP_ODJAVI = "PROP_ODJAVI";
    public static final String PROP_MENU = "PROP_MENU";
    public static final String PROP_CONTEXT = "PROP_CONTEXT";
    public static final String PROP_ACTION = "PROP_ACTION";

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
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

    public String getPath() {
        setMessage("Za nastavak rada potrebno je da se ulogujete");
        setLoged((Boolean) true);
        setTip("guest");
        if (getUser().equals("admin") && getPassword().equals("admin")) {
            setTip("administrator");
            setMessage("Administrator, dobro došao!");
        } else if (getUser().equals("korisnik") && getPassword().equals("korisnik")) {
            setTip("korisnik");
            setMessage("Korisnik, dobro došao!");
        } else {
            setMessage("Greška u logovanju");
            setTip("guest");
            setLoged((Boolean) false);
        }

        switch (getTip()) {
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

    public void setJmb(Long jmb) {
        this.setJmb((Long) jmb);
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
        return getLoged();
    }

    public void setLoged(Boolean loged) {
        this.setLoged((Boolean) loged);
    }

    public String getMenu() {
        switch (getTip()) {
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
        setMessage(MESSAGE);
        this.setLoged((Boolean) false);
        setOdjavi("index.xhtml");
        return getOdjavi();
    }

    public void setLogout(String logout) {
        this.setOdjavi(logout);
    }

    public String getOdjavi() {
        setMessage(MESSAGE);
        this.setLoged((Boolean) false);
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


    /**
     * @return the loged
     */
    public Boolean getLoged() {
        return loged;
    }

}
