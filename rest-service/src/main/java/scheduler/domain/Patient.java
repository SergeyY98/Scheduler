package scheduler.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(unique = true)
  private UUID uuid;

  private String fullName;

  private LocalDate dateOfBirth;

  public long getId() {
    return this.id;
  }

  public UUID getUUID() {
    return this.uuid;
  }

  public String getFullName() {
    return this.fullName;
  }

  public LocalDate getDateOfBirth() {
    return this.dateOfBirth;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setUUID(UUID uuid) {
    this.uuid = uuid;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
}
