package ua.kiev.dk.entities;

import javax.persistence.*;

/**
 * Created by d.koshlyak on 06.08.2015.
 */
@Table(name = "crews")
@Entity
public class Crew {
@Id
@GeneratedValue
    private long id;
@Column(name = "crew_name")
    private String crewName;
@Column(name = "member1_name")
    private String member1Name;
    @Column(name = "member2_name")
    private String member2Name;

    private String car;

    private boolean reanimation;

    public Crew(String crewName, String member1Name, String member2Name, String car) {
        this.crewName = crewName;
        this.member1Name = member1Name;
        this.member2Name = member2Name;
        this.car = car;
    }

    public Crew(){}

    public long getId() {
        return id;
    }

    public String getCrewName() {
        return crewName;
    }

    public String getMember1Name() {
        return member1Name;
    }

    public String getMember2Name() {
        return member2Name;
    }

    public String getCar() {
        return car;
    }

    public boolean isReanimation() {
        return reanimation;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }

    public void setMember1Name(String member1Name) {
        this.member1Name = member1Name;
    }

    public void setMember2Name(String member2Name) {
        this.member2Name = member2Name;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public void setReanimation(boolean reanimation) {
        this.reanimation = reanimation;
    }
}
