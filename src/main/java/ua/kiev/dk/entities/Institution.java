package ua.kiev.dk.entities;

import javax.persistence.*;
import java.util.List;

@Table(name = "institutions")
@Entity
public class Institution {

    @Id
    @GeneratedValue
    private long id;
    @OneToMany(mappedBy = "destinationInstitute", fetch = FetchType.EAGER)
    private List<MedicalRequest> medicalRequest;
    @Column(name = "institution_name")
    private String institutionName;

    @Column(name = "institution_type")
    private String institutionType;
    @Column(name = "city")
    private String institutionCity;
    @Column(name = "coordinate_x")
    private String institutionCoordinateX;
    @Column(name = "coordinate_y")
    private String institutionCoordinateY;

    public Institution(String institutionName, String institutionType, String institutionCity, String institutionCoordinateX, String institutionCoordinateY) {
        this.institutionName = institutionName;
        this.institutionType = institutionType;
        this.institutionCity = institutionCity;
        this.institutionCoordinateX = institutionCoordinateX;
        this.institutionCoordinateY = institutionCoordinateY;
    }

    public Institution() {
    }

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

    public void setInstitutionCity(String institutionCity) {
        this.institutionCity = institutionCity;
    }

    public void setInstitutionCoordinateX(String institutionCoordinateX) {
        this.institutionCoordinateX = institutionCoordinateX;
    }

    public void setInstitutionCoordinateY(String institutionCoordinateY) {
        this.institutionCoordinateY = institutionCoordinateY;
    }

    public long getId() {
        return id;
    }

    public String getInstitutionType() {
        return institutionType;
    }

    public String getInstitutionCity() {
        return institutionCity;
    }

    public String getInstitutionCoordinateX() {
        return institutionCoordinateX;
    }

    public String getInstitutionCoordinateY() {
        return institutionCoordinateY;
    }

    public void setMedicalRequest(List<MedicalRequest> medicalRequest) {
        this.medicalRequest = medicalRequest;
    }

    public List<MedicalRequest> getMedicalRequest() {

        return medicalRequest;
    }
}
