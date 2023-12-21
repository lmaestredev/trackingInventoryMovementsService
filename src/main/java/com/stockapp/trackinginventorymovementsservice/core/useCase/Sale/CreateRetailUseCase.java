package com.stockapp.trackinginventorymovementsservice.core.useCase.Sale;

import com.stockapp.trackinginventorymovementsservice.core.models.RetailData;
import reactor.core.publisher.Mono;

public interface CreateRetailUseCase {
    Mono<RetailData> createRetail(RetailData saleData);
}
