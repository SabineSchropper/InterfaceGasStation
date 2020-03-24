package com.company;

public class Car {
    Enum typeOfFuel;
    String marke;
    Person driver;
    City destination;
    IGasStation nearestGasStation;

    public Car(Fuel typeOfFuel, String marke) {
        this.typeOfFuel = typeOfFuel;
        this.marke = marke;
    }
    public void drive(Person person, City destination){
        this.driver = person;
        this.destination = destination;
        //when a person drives with this Car it is also assigned (zugewiesen) to the Person
        driver.myCar = this;
        driver.whereIAmWithMyCar = destination;
    }
    public String checkGasStation(IGasStation[] gasStationArray) {
        String output;
        IGasStation[] gasStationsWithMytypeOfFuel = new IGasStation[10];
        int counter = 0;

        output = "Tankstellen die " + this.typeOfFuel + " anbieten: ";
        //next step is to search in gasStationArray for gasStations which offer the type of fuel I need
        for (IGasStation gasStation : gasStationArray) {
            if (gasStation != null) {
                gasStationsWithMytypeOfFuel[counter] = gasStation.checkFuel(this);
                counter++;
            }
        }
        for (IGasStation gasStation : gasStationsWithMytypeOfFuel) {
            if (gasStation != null) {
                output = output + gasStation.getName()+" ";
            }
        }
        //now I can search for the GasStation which is in the city I am driving through
        for (IGasStation gasStation : gasStationsWithMytypeOfFuel) {
            if (gasStation != null) {
                if (gasStation.getCity() == this.destination) {
                    output = output + "\nDie nächste Möglichkeit zu Tanken ist die Tankstelle: " + gasStation.getName();
                    output = output + " in " + gasStation.getCity()+"\n";
                    nearestGasStation = gasStation;
                }
            }
        }
        return output;
    }
    public IGasStation getNearestGasStation() {
        return nearestGasStation;
    }

}
