package HospitalManagementSystem.HMS.Models;

import jakarta.persistence.*;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long d_id;

    @Column
    private String name;

    @Column
    private String gender;

    @Column
    private String dob;

    @ManyToOne
    @JoinColumn(name = "s_id")
    private Specialization specialization;

    public long getD_id() {
        return d_id;
    }

    public void setD_id(long d_id) {
        this.d_id = d_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender != null) {
            this.gender = gender;
        }
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        if (dob != null) {
            this.dob = dob;
        }
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        if (specialization != null) {
            this.specialization = specialization;
        }
    }
}
