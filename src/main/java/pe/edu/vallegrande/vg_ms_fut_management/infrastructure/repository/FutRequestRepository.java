package pe.edu.vallegrande.vg_ms_fut_management.infrastructure.repository;

import pe.edu.vallegrande.vg_ms_fut_management.domain.model.FutRequest;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface FutRequestRepository extends ReactiveMongoRepository<FutRequest, String> {
}



