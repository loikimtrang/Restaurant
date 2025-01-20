package com.example.restaurant;

public class Restaurant {
    private String name;
    private String timeAccess;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeAccess() {
        return timeAccess;
    }

    public void setTimeAccess(String timeAccess) {
        this.timeAccess = timeAccess;
    }

    public Restaurant(String name, String timeAccess) {
        this.name = name;
        this.timeAccess = timeAccess;
    }
}
