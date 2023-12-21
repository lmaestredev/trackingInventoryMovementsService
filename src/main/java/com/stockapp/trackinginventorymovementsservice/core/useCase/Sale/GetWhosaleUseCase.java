package com.stockapp.trackinginventorymovementsservice.core.useCase.Sale;

import com.stockapp.trackinginventorymovementsservice.core.models.WhosaleData;
import reactor.core.publisher.Flux;

public interface GetWhosaleUseCase {
    Flux<WhosaleData> getAllWhosale();

}
