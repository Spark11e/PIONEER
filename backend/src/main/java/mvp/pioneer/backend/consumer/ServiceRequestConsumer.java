package mvp.pioneer.backend.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mvp.pioneer.backend.entity.ServiceRequest;
import mvp.pioneer.backend.util.ServiceRequestQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServiceRequestConsumer {
    private final ServiceRequestQueue queue;

    @Value("${topic.service-request-group-id}")
    private String groupId;

    @Value("${topic.service-request}")
    private String serviceRequestTopic;

    @KafkaListener(topics = "${topic.service-request}", groupId = "${topic.service-request-group-id}")
    public void listen(ServiceRequest request) {
        if (!queue.put(request.getOrganizationId(), request))
            log.error(String.format("Cannot put request to queue %s", request));
        log.info(String.format("Successfully put %s", request));
    }
}
