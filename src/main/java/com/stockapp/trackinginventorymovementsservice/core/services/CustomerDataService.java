package com.stockapp.trackinginventorymovementsservice.core.services;

import com.stockapp.trackinginventorymovementsservice.core.models.CustomerData;
import com.stockapp.trackinginventorymovementsservice.core.port.repositories.CustomerDataRepository;
import com.stockapp.trackinginventorymovementsservice.core.useCase.Customer.CreateCustomerDataUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CustomerDataService implements CreateCustomerDataUseCase {

    private final CustomerDataRepository customerDataRepository;

    @Autowired
    public CustomerDataService(CustomerDataRepository customerDataRepository) {
        this.customerDataRepository = customerDataRepository;
    }

    @Override
    public Mono<CustomerData> create(CustomerData customer) {
        return customerDataRepository.save(customer);
    }
}
