package HospitalManagementSystem.HMS.Controller;

import HospitalManagementSystem.HMS.DTO.SpecializationDto;
import HospitalManagementSystem.HMS.Models.Specialization;
import HospitalManagementSystem.HMS.Service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpecializationController {

    @Autowired
    private SpecializationService specializationService;

    @GetMapping(value = "/specializations")
    public List<Specialization> getSpecializations() {
        return this.specializationService.getSpecailizations();
    }

    @PostMapping(value = "/specializations/save")
    public String createSpecialization(@RequestBody SpecializationDto specializationDto) {
        return this.specializationService.createSpecialization(specializationDto);
    }

    @PutMapping(value = "/specializations/update/{id}")
    public String updateSpecialization(@PathVariable long id, @RequestBody SpecializationDto specializationDto) {
        return this.specializationService.updateSpecialization(id, specializationDto);
    }

}
