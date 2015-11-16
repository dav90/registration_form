package com.springapp.mvc.model;

import javax.persistence.*;

@Entity
@Table(name = "address")

public class Address {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long address_id;

    @Column(name = "city")
    String city;

    @Column(name = "street")
    String street;

    public Address(){

    }

    public long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(long address_id) {
        this.address_id = address_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
