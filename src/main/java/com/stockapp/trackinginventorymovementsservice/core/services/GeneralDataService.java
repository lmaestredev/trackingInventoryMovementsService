package com.stockapp.trackinginventorymovementsservice.core.services;

import com.stockapp.trackinginventorymovementsservice.core.models.GeneralData;
import com.stockapp.trackinginventorymovementsservice.core.port.repositories.GeneralDataRepository;
import com.stockapp.trackinginventorymovementsservice.core.useCase.General.CreateGeneralDataUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GeneralDataService implements CreateGeneralDataUseCase {

    private final GeneralDataRepository generalDataRepository;

    @Autowired
    public GeneralDataService(GeneralDataRepository generalDataRepository) {
        this.generalDataRepository = generalDataRepository;
    }

    @Override
    public Mono<GeneralData> create(GeneralData generalData) {
        return generalDataRepository.save(generalData);
    }
}
