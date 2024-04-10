package mvp.pioneer.backend.util;

import mvp.pioneer.backend.entity.ServiceRequest;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ServiceRequestQueue {
    private final Map<UUID, Queue<ServiceRequest>> queueMap = new HashMap<>();

    public ServiceRequest poll(UUID organizationId) {
        Queue<ServiceRequest> queue = queueMap.getOrDefault(organizationId, new LinkedList<>());
        queueMap.putIfAbsent(organizationId, queue);
        return queue.poll();
    }

    public boolean put(UUID organizationId, ServiceRequest dto) {
        Queue<ServiceRequest> queue = queueMap.getOrDefault(organizationId, new LinkedList<>());
        queueMap.putIfAbsent(organizationId, queue);
        return queue.offer(dto);
    }
}
