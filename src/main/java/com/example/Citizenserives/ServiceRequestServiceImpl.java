package com.example.Citizenserives;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CitizenModel.Citizen;
import com.example.CitizenModel.ServiceRequest;
import com.example.CitizenRepository.CitizenRepository;
import com.example.CitizenRepository.ServiceRequestRepository;

import java.util.Date;
import java.util.Optional;

@Service
public class ServiceRequestServiceImpl implements ServiceRequestService {

    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    @Autowired
    private CitizenRepository citizenRepository;

    @Override
    public String applyForWaterConnection(Long citizenId) {
        return applyForService(citizenId, "Water Connection");
    }

    @Override
    public String applyForBirthCertificate(Long citizenId) {
        return applyForService(citizenId, "Birth Certificate");
    }

    @Override
    public String applyForMarriageCertificate(Long citizenId, boolean invitationCardUploaded) {
        Optional<Citizen> optionalCitizen = citizenRepository.findById(citizenId);
        if (optionalCitizen.isPresent()) {
            Citizen citizen = optionalCitizen.get();
            ServiceRequest serviceRequest = new ServiceRequest();
            serviceRequest.setCitizen(citizen);
            serviceRequest.setServiceName("Marriage Certificate");
            serviceRequest.setApplicationStatus(true);
            serviceRequest.setInvitationCardUploaded(invitationCardUploaded);
            serviceRequestRepository.save(serviceRequest);
            return "Application accepted.";
        } else {
            return "Citizen not found.";
        }
    }

//    @Override
//    public String payTax(Long citizenId) {
//        Optional<Citizen> optionalCitizen = citizenRepository.findById(citizenId);
//        if (optionalCitizen.isPresent()) {
//            Citizen citizen = optionalCitizen.get();
//            Optional<ServiceRequest> optionalServiceRequest = serviceRequestRepository
//                    .findByCitizenAndServiceName(citizen, "Pay Tax");
//            if (optionalServiceRequest.isPresent()) {
//                ServiceRequest serviceRequest = optionalServiceRequest.get();
//                if (serviceRequest.getIsTaxPaid()) {
//                    return "Tax already paid.";
//                } else {
//                    // Calculate tax amount and set the deadline
//                    double taxAmount = 100.0; // Example tax amount
//                    serviceRequest.setTaxAmount(taxAmount);
//                    serviceRequest.setTaxDeadline(new Date());
//                    return "Payment amount: " + taxAmount + " and deadline: " + serviceRequest.getTaxDeadline() + ".";
//                }
//            } else {
//                return "Service request not found for paying tax.";
//            }
//        } else {
//            return "Citizen not found.";
//        }
//    }

    private String applyForService(Long citizenId, String serviceName) {
        Optional<Citizen> optionalCitizen = citizenRepository.findById(citizenId);
        if (optionalCitizen.isPresent()) {
            Citizen citizen = optionalCitizen.get();
            ServiceRequest serviceRequest = new ServiceRequest();
            serviceRequest.setCitizen(citizen);
            serviceRequest.setServiceName(serviceName);
            serviceRequest.setApplicationStatus(true);
            serviceRequestRepository.save(serviceRequest);
            return "Application accepted.";
        } else {
            return "Citizen not found.";
        }
    }
}
