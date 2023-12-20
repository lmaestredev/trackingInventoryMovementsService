package com.stockapp.trackinginventorymovementsservice.core.services;

import com.stockapp.trackinginventorymovementsservice.core.models.ProductData;
import com.stockapp.trackinginventorymovementsservice.core.port.repositories.ProductDataRepository;
import com.stockapp.trackinginventorymovementsservice.core.useCase.Product.CreateProductDataUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProductDataService implements CreateProductDataUseCase {

    private final ProductDataRepository productDataRepository;

    @Autowired
    public ProductDataService(ProductDataRepository productDataRepository) {
        this.productDataRepository = productDataRepository;
    }

    @Override
    public Mono<ProductData> create(ProductData productData) {
        return productDataRepository.save(productData);
    }
}
