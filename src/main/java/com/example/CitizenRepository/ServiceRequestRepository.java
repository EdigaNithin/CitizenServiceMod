package com.example.CitizenRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CitizenModel.Citizen;
import com.example.CitizenModel.ServiceRequest;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {

	Optional<ServiceRequest> findByCitizenAndServiceName(Citizen citizen, String string);
}
