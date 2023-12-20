package com.stockapp.trackinginventorymovementsservice.core.useCase.General;

import com.stockapp.trackinginventorymovementsservice.core.models.GeneralData;
import reactor.core.publisher.Flux;

public interface GetGeneralDataPaginatedUseCase {

    Flux<GeneralData> getPaginated(int pagina, int tamanoPagina);

}
