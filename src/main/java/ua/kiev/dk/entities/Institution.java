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
@Column(name = "type_of_institution")
    private String typeOfInstitution;

    private String city;
@Column(name = "coordinate_x")
    private String coordinateX;
@Column(name = "coordinate_y")
    private String CoordinateY;

    public Institution(String typeOfInstitution, String city, String coordinateX, String coordinateY) {
        this.typeOfInstitution = typeOfInstitution;
        this.city = city;
        this.coordinateX = coordinateX;
        CoordinateY = coordinateY;
    }

    public Institution(){}

    public void setId(long id) {
        this.id = id;
    }

    public void setTypeOfInstitution(String typeOfInstitution) {
        this.typeOfInstitution = typeOfInstitution;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCoordinateX(String coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(String coordinateY) {
        CoordinateY = coordinateY;
    }

    public long getId() {
        return id;
    }

    public String getTypeOfInstitution() {
        return typeOfInstitution;
    }

    public String getCity() {
        return city;
    }

    public String getCoordinateX() {
        return coordinateX;
    }

    public String getCoordinateY() {
        return CoordinateY;
    }
}
