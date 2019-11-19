package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DataController {

    public void add(HashMap<String, HashMap<String, ArrayList<Line>>> profileMap, ClimbLine line){
        if(profileMap.containsKey(line.getProfile())){
            if(profileMap.get(line.getProfile()).containsKey(line.getMass())){
                profileMap.get(line.getProfile()).get(line.getMass()).add(line);
            }else {
                ArrayList ar = new ArrayList();
                ar.add(line);
                profileMap.get(line.getProfile()).put(line.getMass(), ar);
            }
        }else{
            String profileName = line.getProfile();
            ArrayList ar = new ArrayList();
            ar.add(line);
            HashMap<String, ArrayList<Line>> hm = new HashMap<>();
            hm.put(line.getMass(), ar);
            profileMap.put(profileName, hm);
        }

    }

}
