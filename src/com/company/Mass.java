package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class Mass {

    private String mass;
    private ArrayList<Line> lines;

    public Mass(String mass) {
        this.mass = mass;
        this.lines = new ArrayList<>();
    }

    public void addLine(Line line){
        lines.add(line);
    }

    public String getMass() {
        return mass;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mass mass1 = (Mass) o;
        return Objects.equals(mass, mass1.mass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mass);
    }
}
