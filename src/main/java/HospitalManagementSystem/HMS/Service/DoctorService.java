package HospitalManagementSystem.HMS.Service;

import HospitalManagementSystem.HMS.DTO.DoctorDto;
import HospitalManagementSystem.HMS.Models.Doctor;
import HospitalManagementSystem.HMS.Models.Specialization;
import HospitalManagementSystem.HMS.Repo.DoctorRepo;
import HospitalManagementSystem.HMS.Repo.SpecializationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private DoctorRepo doctorRepo;
    private SpecializationRepo specializationRepo;

    public DoctorService(DoctorRepo doctorRepo, SpecializationRepo specializationRepo) {
        this.doctorRepo = doctorRepo;
        this.specializationRepo = specializationRepo;
    }

    public List<Doctor> getDoctors() {
        return doctorRepo.findAll();
    }

    public String createDoctor(DoctorDto doctorDto) {
        Doctor doctor1 = new Doctor();
        Specialization specialization = this.specializationRepo.findById(doctorDto.getS_id()).get();
        doctor1.setSpecialization(specialization);
        doctor1.setDob(doctorDto.getDob());
        doctor1.setGender(doctorDto.getGender());
        doctor1.setName(doctorDto.getName());
        doctorRepo.save(doctor1);
        return "New Doctor Created";
    }

    public String updateDoctor(long id, DoctorDto doctorDto) {
        Doctor updatedDoctor = doctorRepo.findById(id).get();
        Specialization specialization = this.specializationRepo.findById(doctorDto.getS_id()).get();
        updatedDoctor.setSpecialization(specialization);
        updatedDoctor.setName(doctorDto.getName());
        updatedDoctor.setGender(doctorDto.getGender());
        updatedDoctor.setDob(doctorDto.getDob());
        doctorRepo.save(updatedDoctor);
        return "Doctor is updated with the id: " + id;
    }

    public String deleteDoctor(long id) {
        Doctor deleteDoctor = doctorRepo.findById(id).get();
        doctorRepo.delete(deleteDoctor);
        return "Doctor deleted with the id: " + id;
    }

}
