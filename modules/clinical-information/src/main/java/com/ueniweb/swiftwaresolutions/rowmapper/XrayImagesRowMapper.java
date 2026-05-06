package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.PatientUploadImageData;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.RowMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application.properties")
@Getter
@Setter
public class XrayImagesRowMapper implements RowMapper<PatientUploadImageData> {
    private final String FromTable;
    private final Properties configProp = new Properties();
    InputStream in = this.getClass().getClassLoader().getResourceAsStream("application.properties");


    public XrayImagesRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cli_xray_images x ");
        this.FromTable = builder.toString();
    }

    public String FromTable() {
        return this.FromTable;
    }

    public String schema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("x.id,");
        builder.append("x.pat_id as patientId,");
        builder.append("x.visit_id as visitId, ");
        builder.append("x.path as imagePath, ");
        builder.append("x.dtm as date ");
        builder.append(this.FromTable);
        return builder.toString();
    }
    @Value("${xrayImage.folder}")
    private String xrayImageFolderLocation;

    @Override
    public PatientUploadImageData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id        = rs.getLong("id");
        final Long patientId        = rs.getLong("patientId");
        final Long visitId        = rs.getLong("visitId");
        final String imagePath        = rs.getString("imagePath");
        final String date        = rs.getString("date");

        try {
            configProp.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File file = new File(configProp.getProperty("xrayImage.folder")+imagePath);
        final Boolean imageExist = file.isFile();
        return PatientUploadImageData.createNewInstance(id,patientId,visitId,imagePath,date,imageExist);
    }
}


