package scheduler.repository;

import scheduler.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
  // Методы для работы с врачами
}