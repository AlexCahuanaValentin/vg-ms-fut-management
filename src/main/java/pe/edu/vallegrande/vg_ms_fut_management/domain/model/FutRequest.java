package pe.edu.vallegrande.vg_ms_fut_management.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Map;

@Data
@Document(collection = "fut_institutional_requests")
public class FutRequest {
    @Id
    private String id;                    // ID único de la solicitud

    @Field("institution_id")
    private Integer institutionId;         // ID de la institución (colegio)

    @Field("first_name")
    private String firstName;              // Primer nombre del solicitante

    @Field("last_name")
    private String lastName;               // Apellidos del solicitante

    @Field("document_type")
    private String documentType;           // Tipo de documento (DNI, RUC, etc.)

    @Field("document_number")
    private String documentNumber;         // Número de documento

    @Field("phone")
    private String phone;                  // Número de celular del solicitante

    @Field("address")
    private String address;                // Dirección de residencia del solicitante

    @Field("request_type")
    private String requestType;            // Tipo de solicitud (por ejemplo, matrícula)

    @Field("request_details")
    private String requestDetails;         // Fundamento del pedido (descripción)

    @Field("required_documents")
    private List<Map<String, String>> requiredDocuments;  // Lista de documentos adjuntos (pueden ser PDFs, URLs, fotos, etc.)

    @Field("status_id")
    private Integer statusId;              // Estado de la solicitud (pendiente, aprobada, rechazada)

    @Field("created_by")
    private String createdBy;              // Nombre del solicitante

    @Field("created_at")
    private String createdAt;              // Fecha de creación de la solicitud

    public FutRequest() {
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

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRequestDetails() {
        return requestDetails;
    }

    public void setRequestDetails(String requestDetails) {
        this.requestDetails = requestDetails;
    }

    public List<Map<String, String>> getRequiredDocuments() {
        return requiredDocuments;
    }

    public void setRequiredDocuments(List<Map<String, String>> requiredDocuments) {
        this.requiredDocuments = requiredDocuments;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
