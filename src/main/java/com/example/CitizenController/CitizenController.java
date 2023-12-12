package com.example.CitizenController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.CitizenModel.Citizen;
import com.example.Citizenserives.CitizenService;
import com.example.Citizenserives.ServiceRequestService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/citizens")
@Validated
public class CitizenController {

    @Autowired
    private CitizenService citizenService;

    @Autowired
    private ServiceRequestService serviceRequestService;

    @GetMapping
    public ResponseEntity<List<Citizen>> getAllCitizens() {
        List<Citizen> citizens = citizenService.getAllCitizens();
        return ResponseEntity.ok(citizens);
    }

    @GetMapping("/{citizenId}")
    public ResponseEntity<Citizen> getCitizenById(@PathVariable Long citizenId) {
        return citizenService.getCitizenById(citizenId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Citizen> createCitizen(@Valid @RequestBody Citizen citizen) {
        Citizen createdCitizen = citizenService.createCitizen(citizen);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCitizen);
    }

    @DeleteMapping("/{citizenId}")
    public ResponseEntity<String> deleteCitizen(@PathVariable Long citizenId) {
        citizenService.deleteCitizen(citizenId);
        return ResponseEntity.ok("Citizen deleted successfully.");
    }

    @PostMapping("/{citizenId}/apply-water-connection")
    public ResponseEntity<String> applyForWaterConnection(@PathVariable Long citizenId) {
        String response = serviceRequestService.applyForWaterConnection(citizenId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{citizenId}/apply-birth-certificate")
    public ResponseEntity<String> applyForBirthCertificate(@PathVariable Long citizenId) {
        String response = serviceRequestService.applyForBirthCertificate(citizenId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{citizenId}/apply-marriage-certificate")
    public ResponseEntity<String> applyForMarriageCertificate(@PathVariable Long citizenId,
                                                             @RequestParam(defaultValue = "false") boolean invitationCardUploaded) {
        String response = serviceRequestService.applyForMarriageCertificate(citizenId, invitationCardUploaded);
        return ResponseEntity.ok(response);
    }

//    @PostMapping("/{citizenId}/pay-tax")
//    public ResponseEntity<String> payTax(@PathVariable Long citizenId) {
//        String response = serviceRequestService.payTax(citizenId);
//        return ResponseEntity.ok(response);
//    }
}

