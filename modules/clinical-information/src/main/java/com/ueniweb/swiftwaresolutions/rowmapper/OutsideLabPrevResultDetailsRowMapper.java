package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.OutsideLabPrevResultDetailsData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OutsideLabPrevResultDetailsRowMapper implements RowMapper<OutsideLabPrevResultDetailsData> {

    private final String schema;

    public OutsideLabPrevResultDetailsRowMapper() {
        final StringBuilder stringBuilder = new StringBuilder(200);

        stringBuilder.append("FROM cli_patient_outside_lab a,");
        stringBuilder.append("cli_patient_outside_lab_result b LEFT OUTER JOIN lab_config_master_dept d ON b.deptId = d.dept_code ");
        stringBuilder.append("LEFT OUTER JOIN lab_config_master_test e ON b.`testId` = e.test_id , \n");
        stringBuilder.append("cli_patient_outside_lab_result_value c LEFT OUTER JOIN lab_config_master_test_fld f ON c.`fldId` = f.`fieldid` ");
        stringBuilder.append("LEFT OUTER JOIN lab_config_master_field1 g ON c.`fldId` = g.`field_id`");
        this.schema = stringBuilder.toString();
    }
    public String schema() {return this.schema;}

    public String tableSchema() {
        final StringBuilder stringBuilder = new StringBuilder(200);

        stringBuilder.append("d.dept_name as deptName,");
        stringBuilder.append("e.test_name as testName,");
        stringBuilder.append("b.notes as notes,");
        stringBuilder.append("f.fieldname as fieldName,");
        stringBuilder.append("c.value as value,");
        stringBuilder.append("b.deptId as deptId,");
        stringBuilder.append("b.testId as testId,");
        stringBuilder.append("c.fldId as fldId,");
        stringBuilder.append("f.unit AS unit,");
        stringBuilder.append("IFNULL(g.`lower_bounds`,'0.00') AS lowerValue,");
        stringBuilder.append("IFNULL(g.`upper_bounds`,'0.00') AS upperValue ");
        stringBuilder.append(this.schema());
        return stringBuilder.toString();
    }

    @Override
    public OutsideLabPrevResultDetailsData mapRow(ResultSet rs, int rowNum) throws SQLException {

        final String deptName = rs.getString("deptName");
        final String testName = rs.getString("testName");
        final String notes = rs.getString("notes");
        final String fieldName = rs.getString("fieldName");
        final String value = rs.getString("value");
        final Long deptId = rs.getLong("deptId");
        final Long testId = rs.getLong("testId");
        final Long fldId = rs.getLong("fldId");
        final String unit =  rs.getString("unit");
        final String lowerValue = rs.getString("lowerValue");
        final String upperValue = rs.getString("upperValue");

        return OutsideLabPrevResultDetailsData.CreateNewInstance(deptName, testName, notes, fieldName, value, deptId, testId, fldId,unit,lowerValue,upperValue);
    }

}
