package HospitalManagementSystem.HMS.Controller;

import HospitalManagementSystem.HMS.DTO.PharmacyDto;
import HospitalManagementSystem.HMS.Models.Pharmacy;
import HospitalManagementSystem.HMS.Service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PharmacyController {

    @Autowired
    private PharmacyService pharmacyService;

    @GetMapping(value = "/pharmacy")
    public List<Pharmacy> getMedicine() {
        return this.pharmacyService.getMedicines();
    }

    @PostMapping(value = "/pharmacy/add")
    public String addMedicine(@RequestBody PharmacyDto pharmacy) {
        return this.pharmacyService.addMedicine(pharmacy);
    }

    @PutMapping(value = "/pharmacy/update/{id}")
    public String updateMedicine(@PathVariable long id, @RequestBody PharmacyDto pharmacy) {
        return this.pharmacyService.updateMedicine(id, pharmacy);
    }

    @DeleteMapping(value = "/pharmacy/delete/{id}")
    public String deleteMedicine(@PathVariable long id) {
        return this.pharmacyService.deleteMedicine(id);
    }

}
