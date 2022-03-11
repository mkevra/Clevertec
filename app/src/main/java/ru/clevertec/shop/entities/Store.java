package ru.clevertec.shop.entities;

import java.util.Objects;

public class Store {
    private String name;
    private String adress;
    private char phone;

    public Store(String name, String adress, char phone) {
        this.name = name;
        this.adress = adress;
        this.phone = phone;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;
        Store shop = (Store) o;
        return phone == shop.phone && name.equals(shop.name) && adress.equals(shop.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, adress, phone);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phone=" + phone +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public char getPhone() {
        return phone;
    }

    public void setPhone(char phone) {
        this.phone = phone;
    }
}
