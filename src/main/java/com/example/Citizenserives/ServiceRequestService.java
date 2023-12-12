package com.example.Citizenserives;


public interface ServiceRequestService {

    String applyForWaterConnection(Long citizenId);

    String applyForBirthCertificate(Long citizenId);

    String applyForMarriageCertificate(Long citizenId, boolean invitationCardUploaded);

    //String payTax(Long citizenId);
}
