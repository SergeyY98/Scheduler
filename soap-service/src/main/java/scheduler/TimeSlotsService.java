package scheduler;

import org.springframework.stereotype.Component;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;

@Component
public class TimeSlotsService {
  public List<XMLGregorianCalendar> generateTimeSlots(List<Rule> rules) {
    return rules.stream().flatMap(rule -> {
      List<XMLGregorianCalendar> timeSlots = new ArrayList<>();
      XMLGregorianCalendar timeSlot = rule.getStartdate();
      timeSlots.add(timeSlot);
      for (int i = 1; i < rule.getAmount(); i++) {
        timeSlot = (XMLGregorianCalendar)timeSlot.clone();
        timeSlot.add(rule.getPeriod());
        timeSlots.add(timeSlot);
      }
      return timeSlots.stream();
    }).toList();
  }
}
