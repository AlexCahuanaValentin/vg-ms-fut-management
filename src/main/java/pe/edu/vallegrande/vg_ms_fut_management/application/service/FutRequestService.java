package pe.edu.vallegrande.vg_ms_fut_management.application.service;

import pe.edu.vallegrande.vg_ms_fut_management.application.ports.input.FutRequestInputPort;
import pe.edu.vallegrande.vg_ms_fut_management.application.ports.output.FutRequestOutputPort;
import pe.edu.vallegrande.vg_ms_fut_management.domain.model.FutRequest;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import org.springframework.stereotype.Service;

@Service
public class FutRequestService implements FutRequestInputPort {

    private final FutRequestOutputPort futRequestOutputPort;

    public FutRequestService(FutRequestOutputPort futRequestOutputPort) {
        this.futRequestOutputPort = futRequestOutputPort;
    }

    @Override
    public Flux<FutRequest> findAll() {
        return futRequestOutputPort.findAll();
    }

    @Override
    public Mono<FutRequest> findById(String id) {
        return futRequestOutputPort.findById(id);
    }

    @Override
    public Mono<FutRequest> save(FutRequest futRequest) {
        // Aquí simplemente guardamos la solicitud con los datos proporcionados
        return futRequestOutputPort.save(futRequest);  // Guardamos la solicitud
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return futRequestOutputPort.deleteById(id);
    }
}
