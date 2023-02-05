package com.geekster.resturent.model;
import java.util.ArrayList;

public class Resturent {
    private int id, totalStaffs;
    private String name, about, address, mobile, speciality, menu;


    public Resturent(int id, int totalStaffs, String name, String about, String address, String mobile, String speciality, String menu) {
        this.id = id;
        this.totalStaffs = totalStaffs;
        this.name = name;
        this.about = about;
        this.address = address;
        this.mobile = mobile;
        this.speciality = speciality;
        this.menu = menu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalStaffs() {
        return totalStaffs;
    }

    public void setTotalStaffs(int totalStaffs) {
        this.totalStaffs = totalStaffs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}
