package scheduler.repository;

import scheduler.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

  @Query("select a from Appointment a where DAY(a.startTime) = DAY(:date) and a.patient is null and exists ( " +
      "select 1 from Doctor d where a.doctor=d and d.id = :doctor_id)")
  List<Appointment> findByDoctorIdAndDate(@Param("doctor_id") long id, @Param("date") LocalDate date);

  @Query("select a from Appointment a where exists ( " +
      "select 1 from Patient p where a.patient=p and p.id = :patient_id)")
  List<Appointment> findByPatientId(@Param("patient_id") long id);
}
