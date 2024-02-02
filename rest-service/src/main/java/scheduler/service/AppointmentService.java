package scheduler.service;

import scheduler.domain.Appointment;
import scheduler.domain.Patient;
import scheduler.repository.AppointmentRepository;
import scheduler.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AppointmentService {

  private final AppointmentRepository appointmentRepository;

  private final PatientRepository patientRepository;

  @Autowired
  public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepository) {
    this.appointmentRepository = appointmentRepository;
    this.patientRepository = patientRepository;
  }

  public List<Appointment> findByDoctorIdAndDate(long doctorId, LocalDate date) {
    return appointmentRepository.findByDoctorIdAndDate(doctorId, date);
  }

  public List<Appointment> findByPatientId(long patientId) {
    return appointmentRepository.findByPatientId(patientId);
  }

  public Appointment bookTimeById(Patient patient, long appointmentId) {
    Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(NoSuchElementException::new);
    appointment.setPatient(patient);
    return appointmentRepository.save(appointment);
  }
}
