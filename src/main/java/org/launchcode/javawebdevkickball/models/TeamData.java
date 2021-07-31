package org.launchcode.javawebdevkickball.models;

import java.util.ArrayList;


public class JobData {

    public static ArrayList<TeamPosition> findByColumnAndValue(String column, String value, Iterable<TeamPosition> allJobs) {

        ArrayList<TeamPosition> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<TeamPosition>) allJobs;
        }
        if (column.equals("all")){
            results = findByValue(value, allJobs);
            return results;
        }
        for (TeamPosition teamPosition : allJobs) {
            String aValue = getFieldValue(teamPosition, column);
            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(teamPosition);
            }
        }
        return results;
    }

    public static String getFieldValue(TeamPosition teamPosition, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = teamPosition.getName();
        } else if (fieldName.equals("employer")){
            theValue = teamPosition.getEmployer().toString();
        } else {
            theValue = teamPosition.getSkills().toString();
        }
        return theValue;
    }

    public static ArrayList<TeamPosition> findByValue(String value, Iterable<TeamPosition> allJobs) {
        String lower_val = value.toLowerCase();

        ArrayList<TeamPosition> results = new ArrayList<>();

        for (TeamPosition teamPosition : allJobs) {

            if (teamPosition.getName().toLowerCase().contains(lower_val)) {
                results.add(teamPosition);
            } else if (teamPosition.getEmployer().toString().toLowerCase().contains(lower_val)) {
                results.add(teamPosition);
            } else if (teamPosition.getSkills().toString().toLowerCase().contains(lower_val)) {
                results.add(teamPosition);
            } else if (teamPosition.toString().toLowerCase().contains(lower_val)) {
                results.add(teamPosition);
            }

        }
        return results;
    }
}

