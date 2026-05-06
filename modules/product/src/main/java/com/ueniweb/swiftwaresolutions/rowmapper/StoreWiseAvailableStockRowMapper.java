package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.StoreWiseAvailableStockData;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class StoreWiseAvailableStockRowMapper implements RowMapper<StoreWiseAvailableStockData> {

    private final String schema;

    public StoreWiseAvailableStockRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM (SELECT a1.id AS storeId,a1.name AS storeName,IFNULL(SUM(a4.stock-getAvailableStockBatch(a3.`id`,a4.store_id)),0) AS availableStock,AVG(a3.mrp) AS mrpPrice " +
//                       " FROM ph_config_stores a1,ph_prods a2,ph_batch a3,ph_store_batch_totals a4 "
                " FROM ph_config_stores a1 JOIN ph_store_batch_totals a4 ON a1.id = a4.store_id JOIN ph_batch a3 ON a3.id = a4.batch_id JOIN ph_prods a2 ON a2.id = a3.prods_id "
        );
        this.schema = builder.toString();
        //   SUM(a4.stock)
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a5.storeId,a5.storeName,a5.availableStock,a5.mrpPrice");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public StoreWiseAvailableStockData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer storeId       = rs.getInt("storeId");
        final String storeName      = rs.getString("storeName");
        final Double availableStock = rs.getDouble("availableStock");
        final Double mrpPrice      = rs.getDouble("mrpPrice");
        return StoreWiseAvailableStockData.createNewInstance(storeId,storeName,availableStock,mrpPrice);
    }
}
