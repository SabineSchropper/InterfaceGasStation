package com.company;

import java.sql.Driver;

public class Main {

    public static void main(String[] args) {
        IGasStation[] gasStationArray = new IGasStation[30];
        String output = "";

        Omv omv = new Omv("OMV", City.DORNBIRN);
        addGasStation(omv, gasStationArray);
        Shell shell = new Shell("Shell", City.FELDKIRCH);
        addGasStation(shell, gasStationArray);
        Agip agip = new Agip("Agip", City.KOBLACH);
        addGasStation(agip, gasStationArray);
        Shell shell1 = new Shell("SuperShell", City.MUNTLIX);
        addGasStation(shell1, gasStationArray);

        Car tesla = new Car(Fuel.ELECTRICITY,"Tesla" );
        Car opel = new Car(Fuel.SUPER95,"Opel");

        Person hans = new Person("Hans");
        Person anna = new Person("Anna");

        omv.addFuel(Fuel.SUPER95);
        omv.addFuel(Fuel.DIESEL);
        omv.addFuel(Fuel.ELECTRICITY);

        shell.addFuel(Fuel.SUPER95);
        shell.addFuel(Fuel.DIESEL);

        agip.addFuel(Fuel.SUPER95);
        agip.addFuel(Fuel.DIESEL);

        shell1.addFuel(Fuel.ELECTRICITY);
        shell1.addFuel(Fuel.DIESEL);
        shell1.addFuel(Fuel.SUPER95);

        //Hans is driving through Dornbirn with his Tesla
        tesla.drive(hans,City.DORNBIRN);
        //then he checks where he can refuel his car
        output = tesla.checkGasStation(gasStationArray);
        System.out.println(output);
        tesla.getNearestGasStation().refuel();

        opel.drive(hans,City.DORNBIRN);
        output = opel.checkGasStation(gasStationArray);
        System.out.println(output);
        opel.getNearestGasStation().refuel();

        opel.drive(anna,City.MUNTLIX);
        output = opel.checkGasStation(gasStationArray);
        System.out.println(output);
        opel.getNearestGasStation().refuel();

    }

    public static void addGasStation(IGasStation gasStation, IGasStation[] gasStationArray){

        for (int i = 0; i < gasStationArray.length; i++) {
            if(gasStationArray[i] == null) {
                gasStationArray[i] = gasStation;
                break;
            }
        }
    }
}
