package com.stockapp.trackinginventorymovementsservice.core.services;

import com.stockapp.trackinginventorymovementsservice.core.models.SaleData;
import com.stockapp.trackinginventorymovementsservice.core.port.repositories.SaleDataRepository;
import com.stockapp.trackinginventorymovementsservice.core.useCase.Sale.CreateSaleDataUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SaleDataService implements CreateSaleDataUseCase {

    private final SaleDataRepository saleDataRepository;

    @Autowired
    public SaleDataService(SaleDataRepository saleDataRepository) {
        this.saleDataRepository = saleDataRepository;
    }

    @Override
    public Mono<SaleData> create(SaleData saleData) {
        return saleDataRepository.save(saleData);
    }
}
