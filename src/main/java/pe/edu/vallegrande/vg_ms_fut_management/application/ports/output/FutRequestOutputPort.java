package pe.edu.vallegrande.vg_ms_fut_management.application.ports.output;

import pe.edu.vallegrande.vg_ms_fut_management.domain.model.FutRequest;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

public interface FutRequestOutputPort {
    Flux<FutRequest> findAll();
    Mono<FutRequest> findById(String id);
    Mono<FutRequest> save(FutRequest futRequest);
    Mono<Void> deleteById(String id);
}

