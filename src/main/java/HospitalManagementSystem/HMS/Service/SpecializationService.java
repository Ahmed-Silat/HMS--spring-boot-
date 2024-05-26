package HospitalManagementSystem.HMS.Service;

import HospitalManagementSystem.HMS.DTO.SpecializationDto;
import HospitalManagementSystem.HMS.Models.Specialization;
import HospitalManagementSystem.HMS.Repo.SpecializationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationService {

    private SpecializationRepo specializationRepo;

    public SpecializationService(SpecializationRepo specializationRepo) {
        this.specializationRepo = specializationRepo;
    }

    public List<Specialization> getSpecailizations() {
        return specializationRepo.findAll();
    }

    public String createSpecialization(SpecializationDto specializationDto) {
        Specialization specialization = new Specialization();
        specialization.setSpecializationNames(specializationDto.getSpecializationNames());
        specializationRepo.save(specialization);
        return "New specialization has been added...";
    }

    public String updateSpecialization(long id, SpecializationDto specializationDto) {
        Specialization updatedSpecialization = specializationRepo.findById(id).get();
        updatedSpecialization.setSpecializationNames(specializationDto.getSpecializationNames());
        specializationRepo.save(updatedSpecialization);
        return "Specialization has been updated with the id: " + id;
    }

}
