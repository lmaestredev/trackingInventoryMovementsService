package com.stockapp.trackinginventorymovementsservice.core.useCase.Error;

import com.stockapp.trackinginventorymovementsservice.core.models.ErrorData;
import reactor.core.publisher.Flux;

public interface GetAllErrorsUseCase {
    Flux<ErrorData> getAll();

}
