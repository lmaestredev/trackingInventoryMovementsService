package com.stockapp.trackinginventorymovementsservice.core.useCase.Product;

import com.stockapp.trackinginventorymovementsservice.core.models.ProductData;
import reactor.core.publisher.Flux;

public interface GetAllProductsUseCase {
    Flux<ProductData> getAll();

}
