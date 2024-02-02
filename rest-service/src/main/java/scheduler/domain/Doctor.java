package scheduler.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctors")
public class Doctor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(unique = true)
  private UUID uuid;

  private String fullName;

  public Doctor(String fullName) {
    this.fullName = fullName;
  }

  public long getId() {
    return this.id;
  }

  public UUID getUUID() {
    return this.uuid;
  }

  public String getFullName() {
    return this.fullName;
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
}
