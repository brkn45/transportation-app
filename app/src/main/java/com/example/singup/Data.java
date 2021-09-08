package com.example.singup;

import java.io.Serializable;
import java.util.ArrayList;

public class Data implements Serializable {
    private ArrayList<String> name;
    private ArrayList<String> surname;
    private ArrayList<String> country;
    private ArrayList<Integer> personType ;
    private int index;
    private User user;
    Data(){
        this.name = new ArrayList<>();
        this.surname = new ArrayList<>();
        this.country = new ArrayList<>();
        this.personType = new ArrayList<>();
        name.add("berkan");
        surname.add("akin");
        country.add("turkey");
        personType.add(1);

    }
    private class User{
        String name;
        String surname;
        String country;
        Integer personType;
        public User(String name, String surname, String country,Integer personType){
            this.name =name;
            this.surname = surname;
            this.country =  country;
            this.personType =personType;
        }
        public String getName(){
            return name;
        }
        public String getSurname(){
            return surname;
        }
        public String getCountry(){
            return  country;
        }
        public Integer getPersonType(){
            return personType;
        }

    }
    public ArrayList<String> getName(){
        return name;
    }
    public ArrayList<String> getSurname(){
        return surname;
    }
    public ArrayList<String> getCountry(){
        return country;
    }
    public ArrayList<Integer> getPersontype(){
        return personType;
    }
    public void setIndex(int num){
        index =num;
    }
    public int getIndex(){
        return index;
    }

    public User getUser(int index){
        user = new User(getName().get(index), getSurname().get(index), getCountry().get(index),getPersontype().get(index) );
        return user;
    }
}
