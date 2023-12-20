package com.stockapp.trackinginventorymovementsservice.core.port.repositories;

import com.stockapp.trackinginventorymovementsservice.core.models.ErrorData;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ErrorDataRepository extends ReactiveMongoRepository<ErrorData, String> {
}
