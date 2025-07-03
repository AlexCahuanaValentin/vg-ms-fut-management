package pe.edu.vallegrande.vg_ms_fut_management.infrastructure.dto.request;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Map;

public class FutRequestDTO {
    @Field("institution_id")
    private Integer institutionId;

    @Field("first_name")
    private String firstName;

    @Field("last_name")
    private String lastName;

    @Field("document_type")
    private String documentType;

    @Field("document_number")
    private String documentNumber;

    @Field("phone")
    private String phone;

    @Field("address")
    private String address;

    @Field("request_type")
    private String requestType;

    @Field("request_details")
    private String requestDetails;

    @Field("required_documents")
    private List<Map<String, String>> requiredDocuments;

    @Field("status_id")
    private Integer statusId;

    @Field("created_by")
    private String createdBy;

    @Field("created_at")
    private String createdAt;

    // Getters y setters

    public Integer getInstitutionId() { return institutionId; }
    public void setInstitutionId(Integer institutionId) { this.institutionId = institutionId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getDocumentType() { return documentType; }
    public void setDocumentType(String documentType) { this.documentType = documentType; }

    public String getDocumentNumber() { return documentNumber; }
    public void setDocumentNumber(String documentNumber) { this.documentNumber = documentNumber; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getRequestType() { return requestType; }
    public void setRequestType(String requestType) { this.requestType = requestType; }

    public String getRequestDetails() { return requestDetails; }
    public void setRequestDetails(String requestDetails) { this.requestDetails = requestDetails; }

    public List<Map<String, String>> getRequiredDocuments() { return requiredDocuments; }
    public void setRequiredDocuments(List<Map<String, String>> requiredDocuments) { this.requiredDocuments = requiredDocuments; }

    public Integer getStatusId() { return statusId; }
    public void setStatusId(Integer statusId) { this.statusId = statusId; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}
