package com.stockapp.trackinginventorymovementsservice.core.port.repositories;

import com.stockapp.trackinginventorymovementsservice.core.models.CustomerData;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CustomerDataRepository extends ReactiveMongoRepository<CustomerData, String> {
}
