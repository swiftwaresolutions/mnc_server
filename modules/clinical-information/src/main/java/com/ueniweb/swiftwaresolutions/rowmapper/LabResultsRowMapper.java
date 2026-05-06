package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.LabResultData;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class LabResultsRowMapper implements RowMapper<LabResultData> {

    private final String selectSchema;

    private final String tableSchema;

    public LabResultsRowMapper() {
        this.tableSchema = " FROM cash_final_bill a,lab_test_reg b,lab_config_master_specimen c,lab_reg_test_value d,lab_test_value e," +
                "lab_config_master_test_fld f,lab_reg_dept_regno h,lab_reg_maj_regno i ";
        this.selectSchema = "SELECT DATE_FORMAT(b.ent_date,'%d-%m-%Y') AS date,c.spec_name,b.test_name,e.value,f.unit," +
                "f.fieldname,i.normalpat_id,b.dept_autoid,e.field_id ";
    }
    @Override
    public LabResultData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String date = rs.getString("date");
        final String specName = rs.getString("spec_name");
        final String testName = rs.getString("test_name");
        final String value = rs.getString("value");
        final String unit = rs.getString("unit");
        final String fieldName = rs.getString("fieldname");
        final Long normalPatId = rs.getLong("normalpat_id");
        final Long deptAutoId = rs.getLong("dept_autoid");
        final Long fieldId = rs.getLong("field_id");
        return LabResultData.createNewInstance(date, specName, testName, value, unit, fieldName, normalPatId, deptAutoId, fieldId);
    }
}
