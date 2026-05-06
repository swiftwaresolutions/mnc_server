package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class StoreWiseAvailableStockData {

    private Integer storeId;

    private String storeName;

    private Double availableStock;

    private Double mrpPrice;

    public StoreWiseAvailableStockData(final Integer storeId, final String storeName, final Double availableStock, final Double mrpPrice) {
        this.storeId        = storeId;
        this.storeName      = storeName;
        this.availableStock = availableStock;
        this.mrpPrice      = mrpPrice;
    }

    public static StoreWiseAvailableStockData createNewInstance(final Integer storeId, final String storeName, final Double availableStock, final Double mrpPrice) {
        return new StoreWiseAvailableStockData(storeId,storeName,availableStock,mrpPrice);
    }

}
