package scheduler.soapclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import scheduler.GetTimeSlotsRequest;
import scheduler.GetTimeSlotsResponse;
import scheduler.Rule;

import java.util.List;

public class RuleClient extends WebServiceGatewaySupport {

  private static final Logger log = LoggerFactory.getLogger(RuleClient.class);

  public GetTimeSlotsResponse getTimeSlots(List<Rule> rules) {

    GetTimeSlotsRequest request = new GetTimeSlotsRequest();
    request.getRules().addAll(rules);

    for (Rule rule : rules) {
      log.info(rule.getStartdate().getDay() + " "
          + rule.getStartdate().getHour() + " " +
          rule.getStartdate().getMinute());
    }

    GetTimeSlotsResponse response = (GetTimeSlotsResponse) getWebServiceTemplate()
        .marshalSendAndReceive("http://soap:8080/ws/rules", request,
            new SoapActionCallback(
                "http://spring.io/guides/gs-producing-web-service/GetTimeSlotsRequest"));

    return response;
  }
}

