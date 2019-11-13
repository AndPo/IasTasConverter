package com.company;

import java.util.Objects;

public class DescentLine {
    private double weight = 0;
    private double isa = 0;
    private double ias = 0;
    private double tas = 0;
    private double altitude = 0;
    private double time = 0;
    private double distance = 0;
    private double fuel = 0;

    public DescentLine(){}

    public DescentLine(double weight, double isa, double altitude) {
        this.weight = weight;
        this.isa = isa;
        this.altitude = altitude;
    }

    public DescentLine(double weight, double isa, double ias, double altitude, double time, double distance, double fuel) {
        this.weight = weight;
        this.isa = isa;
        this.ias = ias;
        this.altitude = altitude;
        this.time = time;
        this.distance = distance;
        this.fuel = fuel;
    }

    public DescentLine (String [] str){
        this.weight = Double.parseDouble(str[0]);
        this.isa = Double.parseDouble(str[1]);
        this.ias = Double.parseDouble(str[2]);
        this.altitude = Double.parseDouble(str[3]);
        this.time = Double.parseDouble(str[4]);
        this.distance = Double.parseDouble(str[5]);
        this.fuel = Double.parseDouble(str[6]);

    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getIsa() {
        return isa;
    }

    public void setIsa(double isa) {
        this.isa = isa;
    }

    public double getIas() {
        return ias;
    }

    public void setIas(double ias) {
        this.ias = ias;
    }

    public double getTas() {
        return tas;
    }

    public void setTas(double tas) {
        this.tas = tas;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return weight +
                ", " + isa +
                ", " + ias +
            //    ", " + tas +
                ", " + altitude +
                ", " + time +
                ", " + distance +
                ", " + fuel;
    }

    public String[] toStringArray() {
        return this.toString().split(", ");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DescentLine that = (DescentLine) o;
        return Double.compare(that.weight, weight) == 0 &&
                Double.compare(that.isa, isa) == 0 &&
                Double.compare(that.altitude, altitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, isa, altitude);
    }
}
