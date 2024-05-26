package HospitalManagementSystem.HMS.Repo;

import HospitalManagementSystem.HMS.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
