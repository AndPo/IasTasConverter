package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class InputOutput {

    public ArrayList getFromFile(String string){
        ArrayList<Line> linesList = new ArrayList<>();
        try (FileReader reader = new FileReader(string);
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                linesList.add(new ClimbLine(line.split(",")));
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return linesList;
    }

    public void writeToFile(ArrayList linesList, String filePath, String profileName){
        StringBuilder sb = new StringBuilder();
        sb.append("name, weight, isa, ias, altitude, time, distance, fuel");
        sb.append("\n");
        for (Object list :linesList) {
            sb.append(list.toString());
            sb.append("\n");
        }
        try {
            String str = sb.toString();
            Files.write(Paths.get(filePath), str.getBytes());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
