package com.stockapp.trackinginventorymovementsservice.core.services;

import com.stockapp.trackinginventorymovementsservice.core.models.ErrorData;
import com.stockapp.trackinginventorymovementsservice.core.port.repositories.ErrorDataRepository;
import com.stockapp.trackinginventorymovementsservice.core.useCase.Error.CreateErrorDataUseCase;
import com.stockapp.trackinginventorymovementsservice.core.useCase.Error.GetAllErrorsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ErrorDataService implements CreateErrorDataUseCase, GetAllErrorsUseCase {

    private final ErrorDataRepository errorDataRepository;

    @Autowired
    public ErrorDataService(ErrorDataRepository errorDataRepository) {
        this.errorDataRepository = errorDataRepository;
    }

    @Override
    public Mono<ErrorData> create(ErrorData errorData) {
        return errorDataRepository.save(errorData);
    }

    @Override
    public Flux<ErrorData> getAll() {
        return errorDataRepository.findAll()
                .collectList()
                .flatMapMany(errors -> {
                    if (errors.isEmpty()) {
                        return Mono.error(new RuntimeException("La lista de errores está vacia"));
                    } else {
                        return Flux.fromIterable(errors);
                    }
                });
    }
}
