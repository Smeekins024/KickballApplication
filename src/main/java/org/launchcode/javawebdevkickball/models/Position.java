package org.launchcode.javawebdevkickball.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Position extends AbstractEntity {
    public Position(){
    }

//    @ManyToMany(mappedBy = "TeamPosition")
//    private List<TeamPosition> teamPositions;
    private String Description;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}