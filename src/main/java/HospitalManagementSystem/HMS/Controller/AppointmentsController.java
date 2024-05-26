package HospitalManagementSystem.HMS.Controller;

import HospitalManagementSystem.HMS.DTO.AppointmentsDto;
import HospitalManagementSystem.HMS.Models.Appointments;
import HospitalManagementSystem.HMS.Service.AppointmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentsController {

    @Autowired
    private AppointmentsService appointmentsService;

    @GetMapping(value = "/appointment")
    public List<Appointments> getAppointments() {
        return this.appointmentsService.getAppointments();
    }

    @PostMapping(value = "/appointment/add")
    public String addAppointments(@RequestBody AppointmentsDto appointmentsDto) {
        return this.appointmentsService.addAppointments(appointmentsDto);
    }

    @PutMapping(value = "/appointment/update/{id}")
    public String updateAppointments(@PathVariable long id, @RequestBody AppointmentsDto appointmentsDto) {
        return this.appointmentsService.updateAppointments(id, appointmentsDto);
    }

    @DeleteMapping(value = "/appointment/delete/{id}")
    public String deleteAppointments(@PathVariable long id) {
        return this.appointmentsService.deleteAppointments(id);
    }

}
