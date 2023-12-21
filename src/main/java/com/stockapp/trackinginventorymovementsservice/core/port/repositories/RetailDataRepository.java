package com.stockapp.trackinginventorymovementsservice.core.port.repositories;

import com.stockapp.trackinginventorymovementsservice.core.models.RetailData;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RetailDataRepository extends ReactiveMongoRepository<RetailData, String> {
}
