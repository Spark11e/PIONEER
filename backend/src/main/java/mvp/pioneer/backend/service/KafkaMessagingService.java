package mvp.pioneer.backend.service;

import lombok.RequiredArgsConstructor;
import mvp.pioneer.backend.entity.ConnectionRequest;
import mvp.pioneer.backend.entity.ServiceRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaMessagingService {
    private final KafkaTemplate<String, ServiceRequest> serviceRequestKafkaTemplate;

    public void send(String topic, ServiceRequest request) {
        serviceRequestKafkaTemplate.send(topic, request.getOrganizationId().toString(), request);
    }
}
