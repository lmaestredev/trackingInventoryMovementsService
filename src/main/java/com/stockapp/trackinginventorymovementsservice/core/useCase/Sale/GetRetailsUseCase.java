package com.stockapp.trackinginventorymovementsservice.core.useCase.Sale;

import com.stockapp.trackinginventorymovementsservice.core.models.RetailData;
import reactor.core.publisher.Flux;

public interface GetRetailsUseCase {
    Flux<RetailData> getAllRetails();

}
