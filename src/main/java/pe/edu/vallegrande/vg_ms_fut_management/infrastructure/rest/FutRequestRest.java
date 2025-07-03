package pe.edu.vallegrande.vg_ms_fut_management.infrastructure.rest;

import pe.edu.vallegrande.vg_ms_fut_management.application.ports.input.FutRequestInputPort;
import pe.edu.vallegrande.vg_ms_fut_management.domain.model.FutRequest;
import pe.edu.vallegrande.vg_ms_fut_management.infrastructure.dto.request.FutRequestDTO;
import pe.edu.vallegrande.vg_ms_fut_management.infrastructure.dto.response.FutRequestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/fut-requests")
public class FutRequestRest {

    private final FutRequestInputPort futRequestService;

    @Autowired
    public FutRequestRest(FutRequestInputPort futRequestService) {
        this.futRequestService = futRequestService;
    }

    // POST para crear una nueva solicitud
    @PostMapping
    public Mono<FutRequestResponse> create(@RequestBody FutRequestDTO futRequestDTO) {
        FutRequest futRequest = new FutRequest();

        futRequest.setInstitutionId(futRequestDTO.getInstitutionId() != null ? futRequestDTO.getInstitutionId() : 0);
        futRequest.setFirstName(futRequestDTO.getFirstName() != null ? futRequestDTO.getFirstName() : "Desconocido");
        futRequest.setLastName(futRequestDTO.getLastName() != null ? futRequestDTO.getLastName() : "Desconocido");
        futRequest.setDocumentType(futRequestDTO.getDocumentType() != null ? futRequestDTO.getDocumentType() : "Desconocido");
        futRequest.setDocumentNumber(futRequestDTO.getDocumentNumber() != null ? futRequestDTO.getDocumentNumber() : "Desconocido");
        futRequest.setPhone(futRequestDTO.getPhone() != null ? futRequestDTO.getPhone() : "Desconocido");
        futRequest.setAddress(futRequestDTO.getAddress() != null ? futRequestDTO.getAddress() : "Desconocido");
        futRequest.setRequestType(futRequestDTO.getRequestType() != null ? futRequestDTO.getRequestType() : "Desconocido");
        futRequest.setRequestDetails(futRequestDTO.getRequestDetails() != null ? futRequestDTO.getRequestDetails() : "Desconocido");
        futRequest.setRequiredDocuments(futRequestDTO.getRequiredDocuments() != null ? futRequestDTO.getRequiredDocuments() : new ArrayList<>());
        futRequest.setStatusId(futRequestDTO.getStatusId() != null ? futRequestDTO.getStatusId() : 0);
        futRequest.setCreatedBy(futRequestDTO.getCreatedBy() != null ? futRequestDTO.getCreatedBy() : "Sistema");
        futRequest.setCreatedAt(futRequestDTO.getCreatedAt() != null ? futRequestDTO.getCreatedAt() : "2023-01-01");

        return futRequestService.save(futRequest)
                .map(savedRequest -> mapToFutRequestResponse(savedRequest));
    }

    @GetMapping
    public Flux<FutRequestResponse> getAll() {
        return futRequestService.findAll()
                .map(futRequest -> mapToFutRequestResponse(futRequest));
    }

    @GetMapping("/{id}")
    public Mono<FutRequestResponse> getById(@PathVariable String id) {
        return futRequestService.findById(id)
                .map(futRequest -> mapToFutRequestResponse(futRequest));
    }

    // PUT para modificar una solicitud
    @PutMapping("/{id}")
    public Mono<FutRequestResponse> update(@PathVariable String id, @RequestBody FutRequestDTO futRequestDTO) {
        return futRequestService.findById(id)
                .flatMap(futRequest -> {
                    // Actualizamos los campos con los nuevos valores proporcionados en la solicitud
                    futRequest.setInstitutionId(futRequestDTO.getInstitutionId() != null ? futRequestDTO.getInstitutionId() : futRequest.getInstitutionId());
                    futRequest.setFirstName(futRequestDTO.getFirstName() != null ? futRequestDTO.getFirstName() : futRequest.getFirstName());
                    futRequest.setLastName(futRequestDTO.getLastName() != null ? futRequestDTO.getLastName() : futRequest.getLastName());
                    futRequest.setDocumentType(futRequestDTO.getDocumentType() != null ? futRequestDTO.getDocumentType() : futRequest.getDocumentType());
                    futRequest.setDocumentNumber(futRequestDTO.getDocumentNumber() != null ? futRequestDTO.getDocumentNumber() : futRequest.getDocumentNumber());
                    futRequest.setPhone(futRequestDTO.getPhone() != null ? futRequestDTO.getPhone() : futRequest.getPhone());
                    futRequest.setAddress(futRequestDTO.getAddress() != null ? futRequestDTO.getAddress() : futRequest.getAddress());
                    futRequest.setRequestType(futRequestDTO.getRequestType() != null ? futRequestDTO.getRequestType() : futRequest.getRequestType());
                    futRequest.setRequestDetails(futRequestDTO.getRequestDetails() != null ? futRequestDTO.getRequestDetails() : futRequest.getRequestDetails());
                    futRequest.setRequiredDocuments(futRequestDTO.getRequiredDocuments() != null ? futRequestDTO.getRequiredDocuments() : futRequest.getRequiredDocuments());
                    futRequest.setStatusId(futRequestDTO.getStatusId() != null ? futRequestDTO.getStatusId() : futRequest.getStatusId());
                    futRequest.setCreatedBy(futRequestDTO.getCreatedBy() != null ? futRequestDTO.getCreatedBy() : futRequest.getCreatedBy());
                    futRequest.setCreatedAt(futRequestDTO.getCreatedAt() != null ? futRequestDTO.getCreatedAt() : futRequest.getCreatedAt());

                    // Guardamos el objeto actualizado
                    return futRequestService.save(futRequest)
                            .map(updatedFutRequest -> mapToFutRequestResponse(updatedFutRequest));
                })
                .switchIfEmpty(Mono.error(new RuntimeException("Solicitud no encontrada"))); // Maneja caso de no encontrar el recurso
    }

    // DELETE para eliminar una solicitud por ID
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return futRequestService.findById(id)
                .flatMap(futRequest -> futRequestService.deleteById(id)) // Elimina el objeto por ID
                .switchIfEmpty(Mono.error(new RuntimeException("Solicitud no encontrada"))); // Maneja caso de no encontrar el recurso
    }



    // Método para convertir FutRequest a FutRequestResponse
    private FutRequestResponse mapToFutRequestResponse(FutRequest futRequest) {
        FutRequestResponse response = new FutRequestResponse();
        response.setId(futRequest.getId());
        response.setInstitutionId(futRequest.getInstitutionId());
        response.setFirstName(futRequest.getFirstName());
        response.setLastName(futRequest.getLastName());
        response.setDocumentType(futRequest.getDocumentType());
        response.setDocumentNumber(futRequest.getDocumentNumber());
        response.setPhone(futRequest.getPhone());
        response.setAddress(futRequest.getAddress());
        response.setRequestType(futRequest.getRequestType());
        response.setRequestDetails(futRequest.getRequestDetails());
        response.setStatusId(futRequest.getStatusId());
        response.setCreatedBy(futRequest.getCreatedBy());
        response.setCreatedAt(futRequest.getCreatedAt());
        return response;
    }

}
