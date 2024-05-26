package HospitalManagementSystem.HMS.Service;

import HospitalManagementSystem.HMS.DTO.AppointmentsDto;
import HospitalManagementSystem.HMS.Models.Appointments;
import HospitalManagementSystem.HMS.Models.Doctor;
import HospitalManagementSystem.HMS.Models.User;
import HospitalManagementSystem.HMS.Repo.AppointmentsRepo;
import HospitalManagementSystem.HMS.Repo.DoctorRepo;
import HospitalManagementSystem.HMS.Repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentsService {

    private AppointmentsRepo appointmentsRepo;
    private DoctorRepo doctorRepo;
    private UserRepo userRepo;

    public AppointmentsService(AppointmentsRepo appointmentsRepo, DoctorRepo doctorRepo, UserRepo userRepo) {
        this.appointmentsRepo = appointmentsRepo;
        this.doctorRepo = doctorRepo;
        this.userRepo = userRepo;
    }

    public List<Appointments> getAppointments() {
        return appointmentsRepo.findAll();
    }

    public String addAppointments(AppointmentsDto appointmentsDto) {
        Appointments appointments = new Appointments();
        Doctor doctor = this.doctorRepo.findById(appointmentsDto.getDoctor_id()).get();
        appointments.setDoctor(doctor);
        User user = this.userRepo.findById(appointmentsDto.getUser_id()).get();
        appointments.setUser(user);
        appointments.setDate(appointmentsDto.getDate());
        appointments.setDisease(appointmentsDto.getDisease());
        appointmentsRepo.save(appointments);
        return "New Appointment has been added...";
    }

    public String updateAppointments(long id, AppointmentsDto appointmentsDto) {
        Appointments updatedAppointments = appointmentsRepo.findById(id).get();
        Doctor doctor = this.doctorRepo.findById(appointmentsDto.getDoctor_id()).get();
        updatedAppointments.setDoctor(doctor);
        User user = this.userRepo.findById(appointmentsDto.getUser_id()).get();
        updatedAppointments.setUser(user);
        updatedAppointments.setDisease(appointmentsDto.getDisease());
        updatedAppointments.setDate(appointmentsDto.getDate());
        appointmentsRepo.save(updatedAppointments);
        return "Appointment has been updated with the id: " + id;
    }

    public String deleteAppointments(long id) {
        Appointments deleteAppointments = appointmentsRepo.findById(id).get();
        appointmentsRepo.delete(deleteAppointments);
        return "Appointment has been deleted with the id: " + id;
    }

}
