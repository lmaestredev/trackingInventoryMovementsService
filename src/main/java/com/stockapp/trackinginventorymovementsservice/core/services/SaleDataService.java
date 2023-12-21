package com.stockapp.trackinginventorymovementsservice.core.services;

import com.stockapp.trackinginventorymovementsservice.core.models.RetailData;
import com.stockapp.trackinginventorymovementsservice.core.models.SaleData;
import com.stockapp.trackinginventorymovementsservice.core.models.WhosaleData;
import com.stockapp.trackinginventorymovementsservice.core.port.repositories.RetailDataRepository;
import com.stockapp.trackinginventorymovementsservice.core.port.repositories.SaleDataRepository;
import com.stockapp.trackinginventorymovementsservice.core.port.repositories.WhosaleDataRepository;
import com.stockapp.trackinginventorymovementsservice.core.useCase.Sale.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SaleDataService implements CreateSaleDataUseCase, GetRetailsUseCase, GetWhosaleUseCase, CreateRetailUseCase, CreateWhosaleUseCase {

    private final SaleDataRepository saleDataRepository;
    private final RetailDataRepository retailDataRepository;
    private final WhosaleDataRepository whosaleDataRepository;

    @Autowired
    public SaleDataService(SaleDataRepository saleDataRepository, RetailDataRepository retailDataRepository, WhosaleDataRepository whosaleDataRepository) {
        this.saleDataRepository = saleDataRepository;
        this.retailDataRepository = retailDataRepository;
        this.whosaleDataRepository = whosaleDataRepository;
    }

    @Override
    public Mono<SaleData> create(SaleData saleData) {
        return saleDataRepository.save(saleData);
    }


    @Override
    public Flux<RetailData> getAllRetails() {
        return retailDataRepository.findAll();
    }

    @Override
    public Flux<WhosaleData> getAllWhosale() {
        return whosaleDataRepository.findAll();
    }

    @Override
    public Mono<RetailData> createRetail(RetailData saleData) {
        return retailDataRepository.save(saleData);
    }

    @Override
    public Mono<WhosaleData> createWhosale(WhosaleData saleData) {
        return whosaleDataRepository.save(saleData);
    }
}
