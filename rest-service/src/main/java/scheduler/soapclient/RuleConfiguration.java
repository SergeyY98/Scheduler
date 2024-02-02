package scheduler.soapclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import scheduler.soapclient.RuleClient;

@Configuration
public class RuleConfiguration {

  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setContextPath("scheduler");
    return marshaller;
  }

  @Bean
  public RuleClient ruleClient(Jaxb2Marshaller marshaller) {
    RuleClient client = new RuleClient();
    client.setDefaultUri("http://soap:8080/ws");
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
    return client;
  }

}
