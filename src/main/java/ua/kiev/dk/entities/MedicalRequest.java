package ua.kiev.dk.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by d.koshlyak on 06.08.2015.
 */
@Entity
@Table(name = "Medical_Requests")
public class MedicalRequest {
@Id
@GeneratedValue
    private long id;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "unit_id")
    private Unit unit;

    private String status;

    private String injury;
@Column(name = "pain_reaction")
    private boolean painReaction;

    private String breath;
    @Column(name = "blood_pressure")
    private String bloodPressure;
@Column(name = "extremity_avulsion")
    private boolean extremityAvulsion;
@Column(name = "care_type")
    private String careType;
@Column(name = "departure_point_name")
    private String departurePointName;
@Column(name = "departure_point_coordinate_x")
    private String departurePointCoordinateX;
    @Column(name = "departure_point_coordinate_y")
    private String departurePointCoordinateY;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "destination_institute_id")
    private Institution destinationInstitute;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "evacuation_crew_id")
    private Crew evacuationCrew;
private Date timestamp;
    @Column(name="active_request")
    private boolean activeRequest;

    public MedicalRequest(Unit unit, String status, String injury, boolean painReaction, String breath, String pressure,
                          boolean extremityAvulsion, String careType, String departurePointName,
                          String departurePointCoordinateX, String departurePointCoordinateY,
                          Institution destinationInstitute, Crew evacuationCrew) {
        this.unit = unit;
        this.status = status;
        this.injury = injury;
        this.painReaction = painReaction;
        this.breath = breath;
        this.bloodPressure = pressure;
        this.extremityAvulsion = extremityAvulsion;
        this.careType = careType;
        this.departurePointName = departurePointName;
        this.departurePointCoordinateX = departurePointCoordinateX;
        this.departurePointCoordinateY = departurePointCoordinateY;
        this.destinationInstitute = destinationInstitute;
        this.evacuationCrew = evacuationCrew;
        this.activeRequest=true;
        this.timestamp=new Date();
    }

    public MedicalRequest (){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setInjury(String injury) {
        this.injury = injury;
    }

    public void setPainReaction(boolean painReaction) {
        this.painReaction = painReaction;
    }

    public void setBreath(String breath) {
        this.breath = breath;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public void setExtremityAvulsion(boolean extremityAvulsion) {
        this.extremityAvulsion = extremityAvulsion;
    }

    public void setCareType(String careType) {
        this.careType = careType;
    }

    public void setDeparturePointName(String departurePointName) {
        this.departurePointName = departurePointName;
    }

    public void setDeparturePointCoordinateX(String departurePointCoordinateX) {
        this.departurePointCoordinateX = departurePointCoordinateX;
    }

    public void setDeparturePointCoordinateY(String departurePointCoordinateY) {
        this.departurePointCoordinateY = departurePointCoordinateY;
    }

    public void setDestinationInstitute(Institution destinationInstitute) {
        this.destinationInstitute = destinationInstitute;
    }

    public void setEvacuationCrew(Crew evacuationCrew) {
        this.evacuationCrew = evacuationCrew;
    }

    public Unit getUnit() {
        return unit;
    }

    public String getStatus() {
        return status;
    }

    public String getInjury() {
        return injury;
    }

    public boolean isPainReaction() {
        return painReaction;
    }

    public String getBreath() {
        return breath;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public boolean isExtremityAvulsion() {
        return extremityAvulsion;
    }

    public String getCareType() {
        return careType;
    }

    public String getDeparturePointName() {
        return departurePointName;
    }

    public String getDeparturePointCoordinateX() {
        return departurePointCoordinateX;
    }

    public String getDeparturePointCoordinateY() {
        return departurePointCoordinateY;
    }

    public Institution getDestinationInstitute() {
        return destinationInstitute;
    }

    public Crew getEvacuationCrew() {
        return evacuationCrew;
    }

    public void setActiveRequest(boolean activeRequest) {
        this.activeRequest = activeRequest;
    }

    public boolean isActiveRequest() {
        return activeRequest;

    }

    public Date getTimestamp() {
        return timestamp;
    }
}
