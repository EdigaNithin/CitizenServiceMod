package com.example.Citizenserives;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CitizenModel.Citizen;
import com.example.CitizenRepository.CitizenRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CitizenServiceImpl implements CitizenService {

    @Autowired
    private CitizenRepository citizenRepository;

    @Override
    public List<Citizen> getAllCitizens() {
        return citizenRepository.findAll();
    }

    @Override
    public Optional<Citizen> getCitizenById(Long citizenId) {
        return citizenRepository.findById(citizenId);
    }

    @Override
    public Citizen createCitizen(Citizen citizen) {
        return citizenRepository.save(citizen);
    }

    @Override
    public void deleteCitizen(Long citizenId) {
        citizenRepository.deleteById(citizenId);
    }
}
