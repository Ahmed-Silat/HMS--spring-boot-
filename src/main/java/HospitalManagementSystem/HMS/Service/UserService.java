package HospitalManagementSystem.HMS.Service;

import HospitalManagementSystem.HMS.Models.User;
import HospitalManagementSystem.HMS.Repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public String createUser(User user) {
        userRepo.save(user);
        return "New User Created...";
    }

    public String updateUser(long id, User user) {
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setGender(user.getGender());
        updatedUser.setDob(user.getDob());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPassword(user.getPassword());
        userRepo.save(updatedUser);
        return "User updated with user id: " + id;
    }

    public String deleteUser(long id) {
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "User deleted with id: " + id;
    }

}
