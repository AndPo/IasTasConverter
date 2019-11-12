package com.company;

public class Converter {

    private final double lowAltitudeIndex = 15;

    public double getIasFromTas(DescentLine line){
        double altitudeInMeters = line.getAltitude()*0.3048;
        double pressure = 101325*(Math.pow((1-0.0000225577*altitudeInMeters), 5.25588));
        double oat = this.findOat(line);
        double rho = pressure/(287.05*(oat+273.15));
        return line.getTas()/Math.sqrt(1.225/rho);

    }

    private double findOat(DescentLine line) {
        double index;
        if(line.getAltitude()>36000.00)
            index = -57;
        else{
            index = lowAltitudeIndex-line.getAltitude()/500;
        }
        if(line.getIsa()<-35)
            index += -35;
        else if(line.getIsa()>35)
            index += 35;
        else {
            index += line.getIsa();
        }
        return index;
    }


}
