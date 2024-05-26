package HospitalManagementSystem.HMS.Controller;

import HospitalManagementSystem.HMS.Models.Doctor;
import HospitalManagementSystem.HMS.DTO.DoctorDto;
import HospitalManagementSystem.HMS.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping(value = "/doctor")
    public List<Doctor> getDoctor() {
        return this.doctorService.getDoctors();
    }

    @PostMapping(value = "/doctor/save")
    public String createDoctor(@RequestBody DoctorDto doctor) {
        return this.doctorService.createDoctor(doctor);
    }

    @PutMapping(value = "/doctor/update/{id}")
    public String updateDoctor(@PathVariable long id, @RequestBody DoctorDto doctor) {
        return this.doctorService.updateDoctor(id, doctor);
    }

    @DeleteMapping(value = "/doctor/delete/{id}")
    public String deleteDoctor(@PathVariable long id) {
        return this.doctorService.deleteDoctor(id);
    }

}
