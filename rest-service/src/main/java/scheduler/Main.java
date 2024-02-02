package scheduler;

import scheduler.domain.Appointment;
import scheduler.domain.Doctor;
import scheduler.repository.AppointmentRepository;
import scheduler.repository.DoctorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import scheduler.soapclient.RuleClient;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner lookup(RuleClient client, DoctorRepository doctorRepository,
													 AppointmentRepository appointmentRepository) {
		return args -> {
			XMLGregorianCalendar xCal =
					DatatypeFactory.newInstance().newXMLGregorianCalendar("2024-02-02T10:00:00");
			Duration dur = DatatypeFactory.newInstance().newDuration("P2DT15H45M0S");

			List<Rule> rules = new ArrayList<>();
			Rule rule = new Rule();
			rule.setStartdate(xCal);
			rule.setPeriod(dur);
			rule.setAmount(3);
			rules.add(rule);
			GetTimeSlotsResponse response = client.getTimeSlots(rules);

			Doctor doctor = new Doctor("Doctor");
			List<Appointment> appointments = new ArrayList<>();
			response.getTimeSlots().forEach(timeSlot -> appointments.add(new Appointment(doctor, LocalDateTime.of(
					timeSlot.getYear(), timeSlot.getMonth(), timeSlot.getDay(), timeSlot.getHour(), timeSlot.getMinute()))));
			appointmentRepository.saveAll(appointments);
		};
	}
}
