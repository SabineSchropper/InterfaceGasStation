package com.company;

public interface IGasStation {
    public void addFuel(Enum fuel);
    public void refuel();
    public IGasStation checkFuel(Car car);
    public City getCity();
    public String getName();




}
