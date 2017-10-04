package fr.wcs.blablacrade;

import java.util.Date;


public class TripResultModel {

    //Attributs

    private String firstname;
    private int price;
    private Date date;

    //Constructeur

    public TripResultModel(String firstname, Date date, int price) {
        this.firstname = firstname;
        this.date = date;
        this.price = price;
    }

    // Getters

    public int getPrice() {
        return price;
    }

    public Date getDate(){
        return date;
    }

    public String getFirstname(){
        return firstname;
    }

    //Setters

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
