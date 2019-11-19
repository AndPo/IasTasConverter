package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class Profile {
    private String name;
    private ArrayList<Mass> massList;

    public Profile(String name, Line line) {
        this.name = name;
        massList = new ArrayList<>();
      //  massList.add(line);
    }

    public void addMass(String mass){
        massList.add(new Mass(mass));
    }

    public ArrayList<Mass> getMasses(){
        return massList;
    }

    public Profile getProfile(String name){
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(name, profile.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
