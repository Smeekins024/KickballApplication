package org.launchcode.javawebdevkickball.models;

import java.util.ArrayList;


public class TeamData {

    public static ArrayList<TeamPosition> findByColumnAndValue(String column, String value, Iterable<TeamPosition> allTeamPositions) {

        ArrayList<TeamPosition> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<TeamPosition>) allTeamPositions;
        }
        if (column.equals("all")){
            results = findByValue(value, allTeamPositions);
            return results;
        }
        for (TeamPosition teamPosition : allTeamPositions) {
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
        } else if (fieldName.equals("team")){
            theValue = teamPosition.getTeam().toString();
        } else {
            theValue = teamPosition.getTeamPositions().toString();
        }
        return theValue;
    }

    public static ArrayList<TeamPosition> findByValue(String value, Iterable<TeamPosition> allTeamPositions) {
        String lower_val = value.toLowerCase();

        ArrayList<TeamPosition> results = new ArrayList<>();

        for (TeamPosition teamPosition : allTeamPositions) {

            if (teamPosition.getName().toLowerCase().contains(lower_val)) {
                results.add(teamPosition);
            } else if (teamPosition.getTeam().toString().toLowerCase().contains(lower_val)) {
                results.add(teamPosition);
            } else if (teamPosition.getTeamPositions().toString().toLowerCase().contains(lower_val)) {
                results.add(teamPosition);
            } else if (teamPosition.toString().toLowerCase().contains(lower_val)) {
                results.add(teamPosition);
            }

        }
        return results;
    }
}

