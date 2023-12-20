package com.stockapp.trackinginventorymovementsservice.core.port.repositories;

import com.stockapp.trackinginventorymovementsservice.core.models.SaleData;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SaleDataRepository extends ReactiveMongoRepository<SaleData, String> {
}
