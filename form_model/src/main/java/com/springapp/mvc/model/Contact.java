package com.springapp.mvc.model;

import javax.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @Column(name = "contact_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long contact_id;

    @Column(name = "mobileNumber")
    private String mobileNumber;

    @Column(name = "homeNumber")
    private String homeNumber;

    public long getContact_id() {
        return contact_id;
    }

    public void setContact_id(long contact_id) {
        this.contact_id = contact_id;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }
}
