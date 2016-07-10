package com.example.klinten.testdd.Models;

/**
 * Created by klinten on 7/7/2016.
 */
public class Locatie {
    public String attractie;
    public String categorie;
    public String adres;
    public String postcode;
    public String tel;


    public Locatie() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public String getAttractie() {
        return attractie;
    }

    public void setAttractie(String attractie) {
        this.attractie = attractie;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Locatie(String attractie, String categorie, String adres, String postcode, String tel) {
        this.attractie = attractie;
        this.categorie = categorie;
        this.adres = adres;
        this.postcode = postcode;
        this.tel = tel;

    }

}
