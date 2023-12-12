package com.example.Citizenserives;



import java.util.List;
import java.util.Optional;

import com.example.CitizenModel.Citizen;

public interface CitizenService {

    List<Citizen> getAllCitizens();

    Optional<Citizen> getCitizenById(Long citizenId);

    Citizen createCitizen(Citizen citizen);

    void deleteCitizen(Long citizenId);
}
