package com.zzg.tracing.entity;

import java.io.Serializable;

public class CityEntity implements Serializable {
    //地区id
    private int id;
    //地区名称
    private String city_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }
}
