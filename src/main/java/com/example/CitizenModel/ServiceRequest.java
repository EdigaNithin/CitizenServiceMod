package com.example.CitizenModel;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "service_request")
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @ManyToOne
    @JoinColumn(name = "citizen_id")
    private Citizen citizen;

    private String serviceName;
    private Boolean applicationStatus;
    private Boolean invitationCardUploaded;
    private Double taxAmount;
    private Date taxDeadline;
    private Boolean isTaxPaid;

    public ServiceRequest() {
    	
    }

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Boolean getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(Boolean applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public Boolean getInvitationCardUploaded() {
		return invitationCardUploaded;
	}

	public void setInvitationCardUploaded(Boolean invitationCardUploaded) {
		this.invitationCardUploaded = invitationCardUploaded;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Date getTaxDeadline() {
		return taxDeadline;
	}

	public void setTaxDeadline(Date taxDeadline) {
		this.taxDeadline = taxDeadline;
	}

	public Boolean getIsTaxPaid() {
		return isTaxPaid;
	}

	public void setIsTaxPaid(Boolean isTaxPaid) {
		this.isTaxPaid = isTaxPaid;
	}
}
