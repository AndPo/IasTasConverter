package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CopyIsa {
    public static void main(String[] args) {

        HashMap<String, HashMap<String, ArrayList<Line>>> profileMap = new HashMap<>();

        InputOutput inputOutput = new InputOutput();
        DataController dataController = new DataController();

        String profileName = "Climb+ final";
        String sourceFileName = "default_9793_climb (2)______________";
        String path = "C:\\Users\\Main\\Downloads\\" + sourceFileName + ".csv";
        ArrayList<ClimbLine> climbArray = inputOutput.getFromFile(path);
        String[] en = {"climb_ climb_SE MAX Cont 1 ENG INOP ENG AI ON",
                "climb_SE MAX 1 ENG INOP",
                "climb_SE MAX 1 ENG INOP ENG AI ON",
                "climb_SE MAX 1 ENG INOP TOTAL AI ON",
                "climb_SE MAX Cont 1 ENG INOP TOTAL AI ON",
                "climb_MAX Cont TOTAL AI ON",
                "climb_MAX Climb",
                "climb_MAX Cont climb_ENG AI ON",
                "climb_MAX climb_ENG AI ON",
                "climb_MAX climb_TOTAL AI ON",
                "climb_MAX Continuous Climb",
                "climb_SE MAX Cont 1 ENG INOP"};

        ArrayList <ClimbLine> newAdded = new ArrayList<>();
        for (int flightLevel = 20; flightLevel < 100; flightLevel += 10) {
            for (int mass = 80000; mass <= 80000; mass += 1000) {

                for (int i = 0; i < en.length; i++) {
                for (int isa = 30; isa >= -40; isa -= 10) {

                        //  if(climbArray.contains(new ClimbLine(en[i], ""+mass, ""+isa, ""+flightLevel))){
                        ClimbLine cl = getIfontainsClimbLine(climbArray, "" + flightLevel, "" + mass, "" + isa, en[i]);
                        if (cl != null) {
                            if (getIfontainsClimbLine(climbArray, "" + flightLevel, "" + mass, "" + (isa - 10), en[i]) == null) {
                                String is = ""+(Integer.parseInt(cl.getIsa_temperature())-10);
                                newAdded.add(new ClimbLine(cl.getProfile(),
                                                            cl.getMass(),
                                                            is,
                                                            cl.getIas(),
                                                            cl.getFlight_level(),
                                                            cl.getTime(),
                                                            cl.getDistance(),
                                                            cl.getFuel_used() ));

                                climbArray.add(new ClimbLine(cl.getProfile(),
                                        cl.getMass(),
                                        is,
                                        cl.getIas(),
                                        cl.getFlight_level(),
                                        cl.getTime(),
                                        cl.getDistance(),
                                        cl.getFuel_used() ));

                               /* profile = str[i++].replace("\"", "");
                                mass = str[i++];
                                isa_temperature = str[i++]; -10
                                ias = str[i++];
                                flight_level = str[i++];
                                time = str[i++];
                                distance = str[i++];
                                fuel_used = str[i++];*/
                            }
                        }
                    }
                }
            }
        }


        inputOutput.writeToFile(newAdded, "C:\\Users\\Main\\Downloads\\" + profileName + "_newAdded.csv", profileName);



    }
        public static ClimbLine getIfontainsClimbLine (ArrayList < ClimbLine > climbArray, String flightLevelAlt, String
        massSS, String isaIsa, String name){
            for (ClimbLine dl : climbArray) {
                if (dl.getFlight_level().equals(flightLevelAlt)
                        && dl.getMass().equals(massSS)
                        && dl.getIsa_temperature().equals(isaIsa)
                        && dl.getProfile().equals(name)

                ) {
                    return dl;
                }
            }
            return null;
        }


    public static int stringCompare(String str1, String str2)
    {

        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);

        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int)str1.charAt(i);
            int str2_ch = (int)str2.charAt(i);

            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }

        // Edge case for strings like
        // String 1="Geeks" and String 2="Geeksforgeeks"
        if (l1 != l2) {
            return l1 - l2;
        }

        // If none of the above conditions is true,
        // it implies both the strings are equal
        else {
            return 0;
        }
    }


}

