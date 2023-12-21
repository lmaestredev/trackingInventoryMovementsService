package com.stockapp.trackinginventorymovementsservice.core.port.repositories;

import com.stockapp.trackinginventorymovementsservice.core.models.WhosaleData;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface WhosaleDataRepository extends ReactiveMongoRepository<WhosaleData, String> {
}
