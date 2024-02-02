package scheduler.controller;

import scheduler.domain.Appointment;
import scheduler.domain.Patient;
import scheduler.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/appointments")
public class AppointmentController {

  private final AppointmentService service;

  @GetMapping
  public List<Appointment> findByDoctorIdAndDate(@RequestParam("doctorId") long doctorId, @RequestParam("date") LocalDate date) {
    return service.findByDoctorIdAndDate(doctorId, date);
  }

  @PostMapping
  public Appointment bookTimeById(@RequestBody Patient patient, @RequestParam("appointmentId") String appointmentId) {
    return service.bookTimeById(patient, Long.parseLong(appointmentId));
  }

  @GetMapping
  public List<Appointment> findByPatientId(@RequestParam("patientId") String patientId) {
    return service.findByPatientId(Long.parseLong(patientId));
  }
}
