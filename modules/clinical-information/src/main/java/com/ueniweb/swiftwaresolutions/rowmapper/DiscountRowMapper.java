package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.DiscountData;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class DiscountRowMapper  implements RowMapper<DiscountData> {

    @Override
    public DiscountData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id                = rs.getInt("id");
        final Integer patId       = rs.getInt("patId");
        final String datetime       = rs.getString("datetime");
        final Double discAmt       = rs.getDouble("discAmt");
        return DiscountData.createNewInstance(id,patId,datetime,discAmt);
    }
}
