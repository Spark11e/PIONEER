package mvp.pioneer.backend.producer;

import lombok.RequiredArgsConstructor;
import mvp.pioneer.backend.entity.ConnectionRequest;
import mvp.pioneer.backend.entity.ServiceRequest;
import mvp.pioneer.backend.service.KafkaMessagingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ServiceRequestProducer {

    private final KafkaMessagingService service;

    @Value("${topic.service-request}")
    private String serviceRequestTopic;

    public void sendServiceRequest(ServiceRequest request) {
        service.send(serviceRequestTopic, request);
    }

}
