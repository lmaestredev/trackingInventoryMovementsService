package com.stockapp.trackinginventorymovementsservice.core.services;

import com.stockapp.trackinginventorymovementsservice.core.models.GeneralData;
import com.stockapp.trackinginventorymovementsservice.core.port.repositories.GeneralDataRepository;
import com.stockapp.trackinginventorymovementsservice.core.useCase.General.CreateGeneralDataUseCase;
import com.stockapp.trackinginventorymovementsservice.core.useCase.General.GetGeneralDataPaginatedUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GeneralDataService implements CreateGeneralDataUseCase, GetGeneralDataPaginatedUseCase {

    private final GeneralDataRepository generalDataRepository;

    @Autowired
    public GeneralDataService(GeneralDataRepository generalDataRepository) {
        this.generalDataRepository = generalDataRepository;
    }

    @Override
    public Mono<GeneralData> create(GeneralData generalData) {
        return generalDataRepository.save(generalData);
    }

    @Override
    public Flux<GeneralData> getPaginated(int pagina, int tamanoPagina) {
        PageRequest pageRequest = PageRequest.of(pagina, tamanoPagina);
        return generalDataRepository.findAllBy(pageRequest);
    }
}
