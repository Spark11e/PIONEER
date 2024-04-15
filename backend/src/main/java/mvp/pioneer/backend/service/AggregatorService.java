package mvp.pioneer.backend.service;

import lombok.RequiredArgsConstructor;
import mvp.pioneer.backend.entity.AggregatorSpecialist;
import mvp.pioneer.backend.entity.ConnectionRequest;
import mvp.pioneer.backend.enums.ConnectionRequestStatus;
import mvp.pioneer.backend.repository.AggregatorSpecialistRepository;
import mvp.pioneer.backend.repository.ConnectionRequestRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AggregatorService {

    private final AggregatorSpecialistRepository aggregatorRepository;
    private final ConnectionRequestRepository connectionRepository;


    public List<ConnectionRequest> getConnectionRequests() {
        return connectionRepository.findAll();
    }

    public ConnectionRequest patchConnectionRequest(UUID id, ConnectionRequestStatus status) {
        ConnectionRequest connectionRequest = connectionRepository.findById(id).orElseThrow();
        switch (status) {
            case COMPLETED -> {
                connectionRequest.setStatus(status);
                connectionRequest.setDateEnd(LocalDate.now());
                connectionRequest.getOrganization().setConnected(true);
                return connectionRepository.save(connectionRequest);
            }
            case REJECTED -> {
                connectionRequest.setStatus(status);
                connectionRequest.setDateEnd(LocalDate.now());
                return connectionRepository.save(connectionRequest);
            }
            case IN_WORK, NEW -> {
                connectionRequest.setStatus(status);
                return connectionRepository.save(connectionRequest);
            }
            default -> {
                return null;
            }
        }
    }

    public AggregatorSpecialist login(String email, String password) {
        Optional<AggregatorSpecialist> optional = aggregatorRepository.findBySpecialist_Email(email);
        if (optional.isEmpty()) return null;
        AggregatorSpecialist specialist = optional.get();
        if (password.equals(specialist.getSpecialist().getPassword())) return specialist;
        else return null;
    }
}
