package ua.kiev.dk.entities;

import javax.persistence.*;

/**
 * Created by d.koshlyak on 06.08.2015.
 */

@Table(name = "institutions")
@Entity
public class Institution {

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "institution_name")
    private String institutionName;

    @Column(name = "institution_type")
    private String institutionType;

    private String city;
@Column(name = "coordinate_x")
    private String coordinateX;
@Column(name = "coordinate_y")
    private String coordinateY;

    public Institution(String institutionName, String institutionType, String city, String coordinateX, String coordinateY) {
        this.institutionName = institutionName;
        this.institutionType = institutionType;
        this.city = city;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public Institution(){}

    public void setId(long id) {
        this.id = id;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getInstitutionName() {

        return institutionName;
    }
    public void setInstitutionType(String institutionType) {
        this.institutionType = institutionType;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCoordinateX(String coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(String coordinateY) {
        this.coordinateY = coordinateY;
    }

    public long getId() {
        return id;
    }

    public String getInstitutionType() {
        return institutionType;
    }

    public String getCity() {
        return city;
    }

    public String getCoordinateX() {
        return coordinateX;
    }

    public String getCoordinateY() {
        return coordinateY;
    }
}
