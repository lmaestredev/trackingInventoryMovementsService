package com.stockapp.trackinginventorymovementsservice.core.port.repositories;

import com.stockapp.trackinginventorymovementsservice.core.models.ProductData;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductDataRepository extends ReactiveMongoRepository<ProductData, String> {
}
