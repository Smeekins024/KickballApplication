package org.launchcode.javawebdevkickball.models;

import javax.persistence.*;
import java.util.List;

@Entity

public class TeamPosition extends AbstractEntity {

    @ManyToOne
    private Team team;

    @OneToMany
    private List<Position> positions;

    public TeamPosition() {
    }

    public TeamPosition(Team aTeam, List<Position> somePositions) {
        super();
        this.team = aTeam;
        this.positions = somePositions;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Position> getTeamPositions() {
        return positions;
    }

    public void setTeamPositions(List<Position> positions) {
        this.positions = positions;
    }
}

