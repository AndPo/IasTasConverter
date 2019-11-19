package com.company;

import java.util.Objects;

public class ClimbLine extends Line{

    private String profile = "";
    private String mass = "";
    private String isa_temperature = "";
    private String ias = "";
    private String flight_level = "";
    private String time = "";
    private String distance = "";
    private String fuel_used = "";

    public ClimbLine(String...str){
        int i = 0;
        profile = str[i++].replace("\"", "");
        mass = str[i++];
        isa_temperature = str[i++];
        ias = str[i++];
        flight_level = str[i++];
        time = str[i++];
        distance = str[i++];
        fuel_used = str[i++];
    }

    public ClimbLine(String profile, String mass, String isa_temperature, String flight_level) {
        this.profile = profile;
        this.mass = mass;
        this.isa_temperature = isa_temperature;
        this.flight_level = flight_level;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getIsa_temperature() {
        return isa_temperature;
    }

    public void setIsa_temperature(String isa_temperature) {
        this.isa_temperature = isa_temperature;
    }

    public String getIas() {
        return ias;
    }

    public void setIas(String ias) {
        this.ias = ias;
    }

    public String getFlight_level() {
        return flight_level;
    }

    public void setFlight_level(String flight_level) {
        this.flight_level = flight_level;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getFuel_used() {
        return fuel_used;
    }

    public void setFuel_used(String fuel_used) {
        this.fuel_used = fuel_used;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClimbLine climbLine = (ClimbLine) o;
        return Objects.equals(profile, climbLine.profile) &&
                Objects.equals(mass, climbLine.mass) &&
                Objects.equals(isa_temperature, climbLine.isa_temperature) &&
                Objects.equals(flight_level, climbLine.flight_level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profile, mass, isa_temperature, flight_level);
    }

    @Override
    public String toString() {
        return
                "" + profile +
                "," + mass +
                "," + isa_temperature +
                "," + ias +
                "," + flight_level +
                "," + time +
                "," + distance +
                "," + fuel_used ;
    }
}
