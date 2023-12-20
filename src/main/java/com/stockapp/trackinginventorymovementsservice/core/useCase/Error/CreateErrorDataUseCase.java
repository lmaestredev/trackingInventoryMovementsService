package com.stockapp.trackinginventorymovementsservice.core.useCase.Error;

import com.stockapp.trackinginventorymovementsservice.core.models.ErrorData;
import reactor.core.publisher.Mono;

public interface CreateErrorDataUseCase {
    Mono<ErrorData> create(ErrorData errorData);

}
