package com.stockapp.trackinginventorymovementsservice.core.port.bus;


import com.google.gson.Gson;
import com.stockapp.trackinginventorymovementsservice.core.models.*;
import com.stockapp.trackinginventorymovementsservice.handler.CommonHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.rabbitmq.Receiver;

@Component
public class RabbitMqMessageConsumer implements CommandLineRunner {

    @Autowired
    private Receiver receiver;

    @Autowired
    private Gson gson;

    private final  CommonHandler commonHandler;

    //queues
    @Value("${customerQueue}")
    private String CUSTOMER_QUEUE;

    @Value("${productQueue}")
    private String PRODUCT_QUEUE;

    @Value("${saleQueue}")
    private String SALE_QUEUE;

    @Value("${errorQueue}")
    private String ERROR_QUEUE;

    @Value("${retailQueue}")
    private String RETAIL_QUEUE;

    @Value("${whosaleQueue}")
    private String WHOSALE_QUEUE;

    public RabbitMqMessageConsumer(CommonHandler commonHandler) {
        this.commonHandler = commonHandler;
    }

    @Override
    public void run(String... args) throws Exception {


        receiver.consumeAutoAck(CUSTOMER_QUEUE)
                .map(message -> {
                   Object customer = gson
                           .fromJson(new String(message.getBody()),
                                   Object.class);

                    System.out.println("Customer in process:  " + customer);
                    commonHandler.saveGeneralData(new GeneralData(customer)).subscribe();
                    commonHandler.saveCustomerData(new CustomerData(customer)).subscribe();
                    return customer;
                }).subscribe();

        receiver.consumeAutoAck(PRODUCT_QUEUE)
                .map(message -> {
                    Object product = gson
                            .fromJson(new String(message.getBody()),
                                    Object.class);

                    System.out.println("Product in process:  " + product);
                    commonHandler.saveGeneralData(new GeneralData(product)).subscribe();
                    commonHandler.saveProductData(new ProductData(product)).subscribe();
                    return product;
                }).subscribe();

        receiver.consumeAutoAck(SALE_QUEUE)
                .map(message -> {
                    Object sale = gson
                            .fromJson(new String(message.getBody()),
                                    Object.class);

                    System.out.println("Sale in process:  " + sale);
                    commonHandler.saveGeneralData(new GeneralData(sale)).subscribe();
                    commonHandler.saveSaleData(new SaleData(sale)).subscribe();
                    return sale;
                }).subscribe();

        receiver.consumeAutoAck(ERROR_QUEUE)
                .map(message -> {
                    Object error = gson
                            .fromJson(new String(message.getBody()),
                                    Object.class);

                    System.out.println("Error in process:  " + error);
                    commonHandler.saveGeneralData(new GeneralData(error)).subscribe();
                    commonHandler.saveErrorData(new ErrorData(error)).subscribe();
                    return error;
                }).subscribe();

        receiver.consumeAutoAck(RETAIL_QUEUE)
                .map(message -> {
                    Object sale = gson
                            .fromJson(new String(message.getBody()),
                                    Object.class);

                    commonHandler.saveGeneralData(new GeneralData(sale)).subscribe();
                    commonHandler.saveRetailData(new RetailData(sale)).subscribe();
                    return sale;
                }).subscribe();

        receiver.consumeAutoAck(WHOSALE_QUEUE)
                .map(message -> {
                    Object sale = gson
                            .fromJson(new String(message.getBody()),
                                    Object.class);

                    System.out.println("Sale in process:  " + sale);
                    commonHandler.saveGeneralData(new GeneralData(sale)).subscribe();
                    commonHandler.saveWhosaleData(new WhosaleData(sale)).subscribe();
                    return sale;
                }).subscribe();
    }
}
