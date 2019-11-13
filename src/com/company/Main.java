package com.company;
import java.lang.Double;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String profileName = "descent_Descent 1 ENG INOP";

        String sourceFileName = "TMP_14 - one eng out";

        String path = "C:\\Users\\Main\\Downloads\\" + sourceFileName + ".csv";
        InputOutput inputOutput = new InputOutput();
        Converter converter = new Converter();
        ArrayList<DescentLine> linesList = inputOutput.getFromFile(path);
        ArrayList<DescentLine> toRemove = new ArrayList<>();
        for (DescentLine line : linesList ) {
            if(line.getIsa() >= -50 && line.getIsa() <= 30) {
                if(line.getTas()==0) {
                    line.setTas(60 * line.getDistance() / line.getTime());
                }
                //line.setIas(converter.getIasFromTas(line));

                line.setTime(Math.round(line.getTime()));
                line.setDistance(Math.round(line.getDistance()));
                line.setFuel(Math.round(line.getFuel()));

                if(line.getTime()==0 || line.getDistance()==0 || line.getFuel()==0 || line.getAltitude()%100!=0){
                    toRemove.add(line);
                }

               // System.out.println(line.toString());

            }else{
                toRemove.add(line);
            }
        }

        ArrayList<DescentLine> resultArray = new ArrayList<>();
        boolean flag = false;
        Main main = new Main();
        for(double i = 10000; i<=40000; i+=500){
            for(double weight = 39000; weight<=80000; weight+=1000) {
                boolean exist = false;
                for (int j = -50; j <= 30; j += 10) {
                    if (main.containsDescentLine(linesList, i, weight, j)) {
                        exist = true;
                    }
                }
                if (exist) {
                    for (double isa = -50; isa <= 30; isa += 10) {

                        if (!main.containsDescentLine(linesList, i, weight, isa)) {

                            if (main.containsDescentLine(linesList, i - 500, weight, isa)) {
                                DescentLine lowerLine = main.getIfontainsDescentLine(linesList, i - 500, weight, isa);
                                if (!(lowerLine.getFuel() == 0)) {

                                    if (main.containsDescentLine(linesList, i + 500, weight, isa)) {
                                        DescentLine upperDescentLine = main.getIfontainsDescentLine(linesList, i + 500, weight, isa);
                                        if (!(upperDescentLine.getFuel() == 0)) {
                                            double ias = main.interpolate(lowerLine.getIas(), upperDescentLine.getIas());
                                            double time = main.interpolate(lowerLine.getTime(), upperDescentLine.getTime());
                                            double distance = main.interpolate(lowerLine.getDistance(), upperDescentLine.getDistance());
                                            double fuel = main.interpolate(lowerLine.getFuel(), upperDescentLine.getFuel());

                                            resultArray.add(new DescentLine(weight, isa, ias, i, time, distance, fuel));


                                            //  double weight, double isa, double ias, double altitude, double time, double distance, double fuel


                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println("lineListSize: " + linesList.size());
        linesList.removeAll(toRemove);
        inputOutput.writeToFile(linesList,"C:\\Users\\Main\\Downloads\\" + profileName + "1.csv", profileName);
        inputOutput.writeToFile(resultArray, "C:\\Users\\Main\\Downloads\\" + profileName + "_interpolated.csv", profileName);

        int k = 0;
        for (DescentLine descL :
                linesList) {
           if(linesList.contains(descL)){
               k++;
           }
        }
        System.out.println("k = " + k);
    }

    public boolean containsDescentLine(ArrayList<DescentLine> descLines, double flightLevel, double mass, double isa){
        for (DescentLine dl: descLines) {
            if(Double.compare(dl.getAltitude(),flightLevel)==0
                    && Double.compare(dl.getWeight(),mass)==0
                    && Double.compare(dl.getIsa(),isa)==0){
                return true;
            }
        }
        return false;
    }

    public DescentLine getIfontainsDescentLine(ArrayList<DescentLine> descLines, double flightLevel, double mass, double isa){
        for (DescentLine dl: descLines) {
            if(Double.compare(dl.getAltitude(),flightLevel)==0
                    && Double.compare(dl.getWeight(),mass)==0
                    && Double.compare(dl.getIsa(),isa)==0)
            {
                return dl;
            }
        }
        return null;
    }

    public double interpolate(double lower, double upper){
        return (lower+upper)/2;
    }

}
