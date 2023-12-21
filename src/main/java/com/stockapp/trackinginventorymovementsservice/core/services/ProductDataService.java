package com.stockapp.trackinginventorymovementsservice.core.services;

import com.stockapp.trackinginventorymovementsservice.core.models.ProductData;
import com.stockapp.trackinginventorymovementsservice.core.port.repositories.ProductDataRepository;
import com.stockapp.trackinginventorymovementsservice.core.useCase.Product.CreateProductDataUseCase;
import com.stockapp.trackinginventorymovementsservice.core.useCase.Product.GetAllProductsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductDataService implements CreateProductDataUseCase, GetAllProductsUseCase {

    private final ProductDataRepository productDataRepository;

    @Autowired
    public ProductDataService(ProductDataRepository productDataRepository) {
        this.productDataRepository = productDataRepository;
    }

    @Override
    public Mono<ProductData> create(ProductData productData) {
        return productDataRepository.save(productData);
    }

    @Override
    public Flux<ProductData> getAll() {
        return productDataRepository.findAll()
                .collectList()
                .flatMapMany(products -> {
                    if (products.isEmpty()) {
                        return Mono.error(new RuntimeException("La lista de productos está vacia"));
                    } else {
                        return Flux.fromIterable(products);
                    }
                });
    }
}
