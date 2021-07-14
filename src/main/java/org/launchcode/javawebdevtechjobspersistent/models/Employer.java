package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Employer extends AbstractEntity {
public Employer (){
//    This is the constructor
}

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
@Size (min = 1, max = 255)
@NotNull
    private String location;

}
