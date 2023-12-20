package com.stockapp.trackinginventorymovementsservice.core.useCase.Product;

import com.stockapp.trackinginventorymovementsservice.core.models.ProductData;
import reactor.core.publisher.Mono;

public interface CreateProductDataUseCase {
    Mono<ProductData> create(ProductData productData);
}
