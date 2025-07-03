package pe.edu.vallegrande.vg_ms_fut_management.application.ports.input;

import pe.edu.vallegrande.vg_ms_fut_management.domain.model.FutRequest;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

public interface FutRequestInputPort {
    Flux<FutRequest> findAll();
    Mono<FutRequest> findById(String id);
    Mono<FutRequest> save(FutRequest futRequest);
    Mono<Void> deleteById(String id);
}
