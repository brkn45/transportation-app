package com.example.singup;

public class BusFeature {
    private String name;
    private String route;
    private  int totalPas;
    private String BusDriverName;

    public BusFeature(String name, String route, int totalPas,String busDriverName){
        this.name =name;
        this.route = route;
        this.totalPas = totalPas;
        this.BusDriverName = busDriverName;
    }

    public int getTotalPas() {
        return totalPas;
    }

    public void setTotalPas(int totalPas) {
        this.totalPas = totalPas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
