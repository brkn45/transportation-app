package com.example.singup;

public class JoinBus {
    String busId;
    String PassengerId;

    JoinBus(String busId, String PassengerId){
        this.busId       = busId;
        this.PassengerId = PassengerId;
    }

    public String getBusId() {
        return busId;
    }

    public String getPassengerId() {
        return PassengerId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public void setPassengerId(String passengerId) {
        PassengerId = passengerId;
    }
}
