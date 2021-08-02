package org.launchcode.javawebdevkickball.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Park extends AbstractEntity {

//   @OneToMany(mappedBy = "Team")
//    private List<Team> parkTeams;
    private String Description;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}