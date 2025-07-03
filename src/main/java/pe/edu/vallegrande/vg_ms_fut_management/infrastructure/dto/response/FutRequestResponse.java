package pe.edu.vallegrande.vg_ms_fut_management.infrastructure.dto.response;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@Data
public class FutRequestResponse {
    @NotNull
    // Datos del solicitante (padre/madre/tutor)
    @Field("first_name")
    private String firstName;

    @NotNull
    @Field("last_name")
    private String lastName;

    @NotNull
    @Field("document_type")
    private String documentType;

    @NotNull
    @Field("document_number")
    private String documentNumber;

    @NotNull
    @Field("phone")
    private String phone;  // Celular

    // Información sobre la solicitud
    @Field("id")
    private String id;                    // ID único de la solicitud

    @Field("institution_id")
    private Integer institutionId;

    @Field("request_type")
    private String requestType;  // Tipo de solicitud (Ej. Matrícula, Beca, etc.)

    @Field("request_details")
    private String requestDetails;  // Descripción o fundamento del pedido

    @Field("status_id")
    private Integer statusId;  // Estado de la solicitud

    @Field("created_by")
    private String createdBy;  // Persona que realizó la solicitud

    @Field("created_at")
    private String createdAt;  // Fecha de creación de la solicitud

    // Si es necesario, puedes agregar más campos de respuesta aquí, como la lista de documentos adjuntos.
    @Field("address")
    private String address; // Domicilio

    public FutRequestResponse() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Integer institutionId) {
        this.institutionId = institutionId;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestDetails() {
        return requestDetails;
    }

    public void setRequestDetails(String requestDetails) {
        this.requestDetails = requestDetails;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
