package com.stockapp.trackinginventorymovementsservice.core.useCase.Customer;

import com.stockapp.trackinginventorymovementsservice.core.models.CustomerData;
import reactor.core.publisher.Mono;

public interface CreateCustomerDataUseCase{
    Mono<CustomerData> create(CustomerData customer);

}
