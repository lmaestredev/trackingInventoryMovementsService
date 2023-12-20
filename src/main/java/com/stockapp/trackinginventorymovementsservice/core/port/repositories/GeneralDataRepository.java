package com.stockapp.trackinginventorymovementsservice.core.port.repositories;

import com.stockapp.trackinginventorymovementsservice.core.models.GeneralData;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface GeneralDataRepository extends ReactiveMongoRepository<GeneralData, String> {
    Flux<GeneralData> findAllBy(Pageable pageable);

}
