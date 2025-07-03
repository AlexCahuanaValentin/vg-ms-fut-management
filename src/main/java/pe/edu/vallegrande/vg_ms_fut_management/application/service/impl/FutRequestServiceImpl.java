package pe.edu.vallegrande.vg_ms_fut_management.application.service.impl;

import pe.edu.vallegrande.vg_ms_fut_management.domain.model.FutRequest;
import pe.edu.vallegrande.vg_ms_fut_management.application.ports.output.FutRequestOutputPort;
import pe.edu.vallegrande.vg_ms_fut_management.infrastructure.repository.FutRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Service
public class FutRequestServiceImpl implements FutRequestOutputPort {

    private final FutRequestRepository futRequestRepository;

    @Autowired
    public FutRequestServiceImpl(FutRequestRepository futRequestRepository) {
        this.futRequestRepository = futRequestRepository;
    }

    @Override
    public Flux<FutRequest> findAll() {
        // Devuelve todas las solicitudes de FUT
        return futRequestRepository.findAll();
    }

    @Override
    public Mono<FutRequest> findById(String id) {
        // Devuelve una solicitud de FUT por su ID
        return futRequestRepository.findById(id);
    }

    @Override
    public Mono<FutRequest> save(FutRequest futRequest) {
        // Guardamos la solicitud de FUT
        return futRequestRepository.save(futRequest);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        // Eliminamos una solicitud de FUT por su ID
        return futRequestRepository.deleteById(id);
    }
}
