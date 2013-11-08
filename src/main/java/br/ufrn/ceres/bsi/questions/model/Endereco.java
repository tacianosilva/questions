package br.ufrn.ceres.bsi.questions.model;
import java.io.Serializable;
import javax.persistence.*;
 
@Entity
public class Endereco extends BaseEntity implements Serializable {
     
    @Column(length = 50)
    private String street;
     
    @Column(length = 50)
    private String suburb;
     
    @Column(length = 50)
    private String city;
     
    @Column(length = 50)
    private String country;
 
    public Endereco() {
    }
 
    public String getStreet() {
        return this.street;
    }
 
    public void setStreet(String street) {
        this.street = street;
    }
 
    public String getSuburb() {
        return this.suburb;
    }
 
    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }
 
    public String getCity() {
        return this.city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
 
    public String getCountry() {
        return this.country;
    }
 
    public void setCountry(String country) {
        this.country = country;
    }
}