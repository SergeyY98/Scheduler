package scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class TimeSlotEndpoint {
  private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

  private TimeSlotsService timeSlotsService;

  @Autowired
  public TimeSlotEndpoint(TimeSlotsService timeSlotsService) {
    this.timeSlotsService = timeSlotsService;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getRuleRequest")
  @ResponsePayload
  public GetTimeSlotsResponse getTimeSlots(@RequestPayload GetTimeSlotsRequest request) {
    GetTimeSlotsResponse response = new GetTimeSlotsResponse();
    response.getTimeSlots()
        .addAll(timeSlotsService.generateTimeSlots(request.getRules()));

    return response;
  }
}