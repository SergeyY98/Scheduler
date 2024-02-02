package scheduler.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne
  @JoinColumn(name = "doctor_id")
  private Doctor doctor;

  @ManyToOne
  @JoinColumn(name = "patient_id")
  private Patient patient;

  private LocalDateTime startTime;

  public Appointment(Doctor doctor, LocalDateTime startTime) {
    this.doctor = doctor;
    this.startTime = startTime;
  }

  public long getId() {
    return this.id;
  }

  public Doctor getDoctor() {
    return this.doctor;
  }

  public Patient getPatient() {
    return this.patient;
  }

  public LocalDateTime getStartTime() {
    return this.startTime;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }
}