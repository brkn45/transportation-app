package com.example.singup;

public class Auth {
    String mail;
    String password;
    String personType;

    public Auth(String mail, String password, String personType) {
        super();
        this.mail = mail;
        this.password = password;
        this.personType = personType;
    }

    public String getPersonType() {
        return personType;
    }
    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
