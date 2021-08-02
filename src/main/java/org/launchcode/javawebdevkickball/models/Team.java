package org.launchcode.javawebdevkickball.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Team extends AbstractEntity {
    public Team(){
    //    This is the constructor
    }

    public String getLocation() {
        return park;
    }

    public void setPark(String Park) {
        this.park = this.park;
    }
    @Size (min = 1, max = 255)
    @NotNull
    private String park;

//    @OneToMany
//    @JoinColumn
//    private List<TeamPosition> teamPositions = new ArrayList<TeamPosition>();
//
//    public List<TeamPosition> getTeamPositions() {
//        return teamPositions;
//    }
//
//    public void setTeamPositions(List<TeamPosition> teamPositions) {
//        this.teamPositions = teamPositions;
//    }
}
