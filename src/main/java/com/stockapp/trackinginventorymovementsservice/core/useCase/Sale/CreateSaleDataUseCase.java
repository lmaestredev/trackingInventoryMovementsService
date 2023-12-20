package com.stockapp.trackinginventorymovementsservice.core.useCase.Sale;

import com.stockapp.trackinginventorymovementsservice.core.models.SaleData;
import reactor.core.publisher.Mono;

public interface CreateSaleDataUseCase {
    Mono<SaleData> create(SaleData saleData);
}
