package HospitalManagementSystem.HMS.Repo;

import HospitalManagementSystem.HMS.Models.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentsRepo extends JpaRepository<Appointments,Long> {
}
