package HospitalManagementSystem.HMS.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long s_id;

    @Column
    private String specializationNames;

    public long getS_id() {
        return s_id;
    }

    public void setS_id(long s_id) {
        this.s_id = s_id;
    }

    public String getSpecializationNames() {
        return specializationNames;
    }

    public void setSpecializationNames(String specializationNames) {
        if (specializationNames != null) {
            this.specializationNames = specializationNames;
        }
    }

}
