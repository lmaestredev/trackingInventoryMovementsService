package com.stockapp.trackinginventorymovementsservice.handler;

import com.stockapp.trackinginventorymovementsservice.core.models.*;
import com.stockapp.trackinginventorymovementsservice.core.useCase.Customer.CreateCustomerDataUseCase;
import com.stockapp.trackinginventorymovementsservice.core.useCase.Error.CreateErrorDataUseCase;
import com.stockapp.trackinginventorymovementsservice.core.useCase.General.CreateGeneralDataUseCase;
import com.stockapp.trackinginventorymovementsservice.core.useCase.General.GetGeneralDataPaginatedUseCase;
import com.stockapp.trackinginventorymovementsservice.core.useCase.Product.CreateProductDataUseCase;
import com.stockapp.trackinginventorymovementsservice.core.useCase.Sale.CreateSaleDataUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class CommonHandler {

    private final CreateCustomerDataUseCase createCustomerDataUseCase;
    private final CreateErrorDataUseCase createErrorDataUseCase;
    private final CreateGeneralDataUseCase createGeneralDataUseCase;
    private final CreateProductDataUseCase createProductDataUseCase;
    private final GetGeneralDataPaginatedUseCase getGeneralDataPaginatedUseCase;
    private final CreateSaleDataUseCase createSaleDataUseCase;

    @Autowired
    public CommonHandler(CreateCustomerDataUseCase createCustomerDataUseCase, CreateErrorDataUseCase createErrorDataUseCase, CreateGeneralDataUseCase createGeneralDataUseCase, CreateProductDataUseCase createProductDataUseCase, GetGeneralDataPaginatedUseCase getGeneralDataPaginatedUseCase, CreateSaleDataUseCase createSaleDataUseCase) {
        this.createCustomerDataUseCase = createCustomerDataUseCase;
        this.createErrorDataUseCase = createErrorDataUseCase;
        this.createGeneralDataUseCase = createGeneralDataUseCase;
        this.createProductDataUseCase = createProductDataUseCase;
        this.getGeneralDataPaginatedUseCase = getGeneralDataPaginatedUseCase;
        this.createSaleDataUseCase = createSaleDataUseCase;
    }

    public Mono<CustomerData> saveCustomerData(CustomerData customer) {
        return createCustomerDataUseCase.create(customer).map(customerSaved -> {
            return customerSaved;
        });
    }

    public Mono<ProductData> saveProductData(ProductData product) {
        return createProductDataUseCase.create(product).map(productSaved -> {
            return productSaved;
        });
    }

    public Mono<ErrorData> saveErrorData(ErrorData error) {
        return createErrorDataUseCase.create(error).map(errorSaved -> {
            return errorSaved;
        });
    }

    public Mono<GeneralData> saveGeneralData(GeneralData general) {
        return createGeneralDataUseCase.create(general).map(generalSaved -> {
            return generalSaved;
        });
    }

    public Mono<SaleData> saveSaleData(SaleData sale) {
        return createSaleDataUseCase.create(sale).map(saleSaved -> {
            return saleSaved;
        });
    }

    public Mono<ServerResponse> getPaginated(ServerRequest request) {
        int pageNumber = Integer.parseInt(request.pathVariable("pageNumber"));
        int pageSize = Integer.parseInt(request.pathVariable("pageSize"));

        return getGeneralDataPaginatedUseCase.getPaginated(pageNumber, pageSize)
                .collectList()
                .flatMap(
                        productDtoRes -> {
                            return ServerResponse.ok().bodyValue(productDtoRes);
                        }
                );

    }


}
