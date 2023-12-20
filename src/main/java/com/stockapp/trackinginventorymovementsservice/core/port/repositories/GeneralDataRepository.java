package com.stockapp.trackinginventorymovementsservice.core.port.repositories;

import com.stockapp.trackinginventorymovementsservice.core.models.GeneralData;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface GeneralDataRepository extends ReactiveMongoRepository<GeneralData, String> {
}
