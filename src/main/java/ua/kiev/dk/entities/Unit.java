package ua.kiev.dk.entities;

import javax.persistence.*;

/**
 * Created by d.koshlyak on 06.08.2015.
 */

@Table(name = "units")
@Entity
public class Unit {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    private String sex;

    private String battalion;
    @Column(name = "blood_type")
    private String bloodType;

    private int weight;
    @Column(name = "token_number")
    private int tokenNumber;

    private String description;

    public Unit(String firstName, String lastName, String sex, String battalion, String bloodType, int weight, int tokenNumber, String brigade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.battalion = battalion;
        this.bloodType = bloodType;
        this.weight = weight;
        this.tokenNumber = tokenNumber;
        this.brigade = brigade;
    }

    public Unit() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBrigade(String brigade) {
        this.brigade = brigade;
    }

    public void setBattalion(String battalion) {
        this.battalion = battalion;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setTokenNumber(int tokenNumber) {
        this.tokenNumber = tokenNumber;
    }

    private String brigade;

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSex() {
        return sex;
    }

    public String getBrigade() {
        return brigade;
    }

    public String getBattalion() {
        return battalion;
    }

    public String getBloodType() {
        return bloodType;
    }

    public int getWeight() {
        return weight;
    }

    public long getTokenNumber() {
        return tokenNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {

        return description;
    }
}
