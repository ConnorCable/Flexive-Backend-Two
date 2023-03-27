package com.flexivebackend.Flexive.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Investment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name = "New Investment";
    private String ticker = "Ticker";

    private Integer invested = 0;
    private String description = "Description";
    @JsonBackReference
    @ManyToOne(optional = false)
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvested() {
        return invested;
    }

    public void setInvested(int invested) {
        this.invested = invested;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
