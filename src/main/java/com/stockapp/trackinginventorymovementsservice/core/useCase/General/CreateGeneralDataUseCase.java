package com.stockapp.trackinginventorymovementsservice.core.useCase.General;

import com.stockapp.trackinginventorymovementsservice.core.models.GeneralData;
import reactor.core.publisher.Mono;

public interface CreateGeneralDataUseCase {
    Mono<GeneralData> create(GeneralData generalData);
}
