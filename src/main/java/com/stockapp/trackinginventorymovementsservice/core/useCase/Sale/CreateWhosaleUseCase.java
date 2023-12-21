package com.stockapp.trackinginventorymovementsservice.core.useCase.Sale;

import com.stockapp.trackinginventorymovementsservice.core.models.WhosaleData;
import reactor.core.publisher.Mono;

public interface CreateWhosaleUseCase {
    Mono<WhosaleData> createWhosale(WhosaleData saleData);

}
