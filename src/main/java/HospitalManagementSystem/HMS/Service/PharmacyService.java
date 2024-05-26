package HospitalManagementSystem.HMS.Service;

import HospitalManagementSystem.HMS.DTO.PharmacyDto;
import HospitalManagementSystem.HMS.Models.Pharmacy;
import HospitalManagementSystem.HMS.Repo.PharmacyRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyService {

    private PharmacyRepo pharmacyRepo;

    public PharmacyService(PharmacyRepo pharmacyRepo) {
        this.pharmacyRepo = pharmacyRepo;
    }

    public List<Pharmacy> getMedicines() {
        return pharmacyRepo.findAll();
    }

    public String addMedicine(PharmacyDto pharmacy) {
        Pharmacy pharmacy1 = new Pharmacy();
        pharmacy1.setMedicineName(pharmacy.getMedicineName());
        pharmacy1.setCompanyName(pharmacy.getCompanyName());
        pharmacy1.setDateOfExpiry(pharmacy.getDateOfExpiry());
        pharmacy1.setDateOfManufacture(pharmacy.getDateOfManufacture());
        pharmacy1.setQuantity(pharmacy.getQuantity());
        pharmacy1.setPrice(pharmacy.getPrice());
        pharmacyRepo.save(pharmacy1);
        return "New Medicine has been added...";
    }

    public String updateMedicine(long id, PharmacyDto pharmacy) {
        Pharmacy updatedPharmacy = pharmacyRepo.findById(id).get();
        updatedPharmacy.setMedicineName(pharmacy.getMedicineName());
        updatedPharmacy.setCompanyName(pharmacy.getCompanyName());
        updatedPharmacy.setDateOfManufacture(pharmacy.getDateOfManufacture());
        updatedPharmacy.setDateOfExpiry(pharmacy.getDateOfExpiry());
        updatedPharmacy.setQuantity(pharmacy.getQuantity());
        updatedPharmacy.setPrice(pharmacy.getPrice());
        pharmacyRepo.save(updatedPharmacy);
        return "Medicine has been updated with the id: " + id;
    }

    public String deleteMedicine(long id) {
        Pharmacy deletePharmacy = pharmacyRepo.findById(id).get();
        pharmacyRepo.delete(deletePharmacy);
        return "Medicine has been deleted with the id: " + id;
    }

}
