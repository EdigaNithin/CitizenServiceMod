package com.example.CitizenRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CitizenModel.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {
}
