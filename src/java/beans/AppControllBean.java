/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Tomislav
 */
//@ManagedBean(name="appControllBean", eager=true)
@ManagedBean(name = "logedUser", eager = true)
@SessionScoped
public class AppControllBean {

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
    //@Inject
    private String path;
    
    /**
     *
     * @return
     */
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
    
    public String setPath(String page){
        return page;
    }

    /**
     * Creates a new instance of AppControlBean
     */
    public AppControllBean() {
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

    public Long getJmb() {
        return jmb;
    }

    public void setJmb(Long jmb) {
        this.jmb = jmb;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Boolean getLoged() {
        return loged;
    }

    public void setLoged(Boolean loged) {
        this.loged = loged;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOdjavi() {
        return odjavi;
    }

    public void setOdjavi(String odjavi) {
        this.odjavi = odjavi;
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

}
