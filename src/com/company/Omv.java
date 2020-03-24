package com.company;

public class Omv implements IGasStation {
    String name;
    Enum[] offeredFuel = new Enum[5];
    int counter;
    City city;
    IGasStation gasStation;

    public Omv(String name, City city) {
        this.name = name;
        this.city = city;
    }

    @Override
    public void addFuel(Enum fuel) {
        offeredFuel[counter] = fuel;
        counter++;
    }

    @Override
    public void refuel() {
        System.out.println("Sie haben bei " +this.name +" getankt.");
        System.out.println("Sie erhalten auf den nächsten Einkauf im Shop 5% Rabatt\n");
    }

    @Override
    public IGasStation checkFuel(Car car) {
        IGasStation gasStation = null;
        for(Enum fuel:offeredFuel){
            if(car.typeOfFuel == fuel){
                gasStation = this;
            }
        }
        return gasStation;
    }

    @Override
    public City getCity() {
        return city;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
