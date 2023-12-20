package com.stockapp.trackinginventorymovementsservice.core.services;

import com.stockapp.trackinginventorymovementsservice.core.models.ErrorData;
import com.stockapp.trackinginventorymovementsservice.core.port.repositories.ErrorDataRepository;
import com.stockapp.trackinginventorymovementsservice.core.useCase.Error.CreateErrorDataUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ErrorDataService implements CreateErrorDataUseCase {

    private final ErrorDataRepository errorDataRepository;

    @Autowired
    public ErrorDataService(ErrorDataRepository errorDataRepository) {
        this.errorDataRepository = errorDataRepository;
    }

    @Override
    public Mono<ErrorData> create(ErrorData errorData) {
        return errorDataRepository.save(errorData);
    }
}
