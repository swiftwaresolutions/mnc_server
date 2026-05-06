package com.ueniweb.swiftwaresolutions.rowmapper;

import com.ueniweb.swiftwaresolutions.data.ImgInvData;
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
public class ImgInvRowMapper implements RowMapper<ImgInvData> {
    private final String fromTable;
    private final Properties configProp = new Properties();
    InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("application.properties");

    public ImgInvRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM cli_xray_images x ");
        builder.append(" LEFT JOIN cash_config_head c ON x.`invId` = c.id ");
        this.fromTable = builder.toString();
    }
    public String FromTable() {return this.fromTable;}

    public String schema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("x.id,");
        builder.append("x.pat_id as patientId,");
        builder.append("x.visit_id as visitId, ");
        builder.append("x.imgName as imageName, ");
        builder.append("x.path as imagePath, ");
        builder.append("x.dtm as date, ");
        builder.append("x.ent_uid as entUid, ");
        builder.append("x.block_date as blockDate, ");
        builder.append("x.invDate as invDate, ");
        builder.append("x.is_blocked as isBlocked, ");
        builder.append("x.blocked_uid as blockedUid, ");
        builder.append("x.deptId as deptId, ");
        builder.append("x.invId as invId, ");
        builder.append("x.groupId as groupId, ");
        builder.append("x.otherInv as otherInvestigation, ");
        builder.append("c.name as invName ");
        builder.append(this.fromTable);
        return builder.toString();
    }

    @Value("${invImage.directory}")
    private String invImageDirectory;

    @Override
    public ImgInvData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id        = rs.getLong("id");
        final Long patientId        = rs.getLong("patientId");
        final Long visitId        = rs.getLong("visitId");
        final String imageName        = rs.getString("imageName");
        final String imagePath        = rs.getString("imagePath");
        final String date        = rs.getString("date");
        final Long entUid = rs.getLong("entUid");
        final String blockDate        = rs.getString("blockDate");
        final String invDate        = rs.getString("invDate");
        final String otherInv = rs.getString("otherInvestigation");
        final Boolean isBlocked = rs.getBoolean("isBlocked");
        final Long blockedUid = rs.getLong("blockedUid");
        final Long invId = rs.getLong("invId");
        final Long groupId = rs.getLong("groupId");
        final String invName = rs.getString("invName");

        try {
            configProp.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File file = new File(configProp.getProperty("invImage.directory") + "/" +patientId + "/" + imageName);
        final Boolean imageExist = file.isFile();
        return ImgInvData.createNewInstance(id,patientId,visitId,imageName,imagePath,
                date,entUid,blockDate,invDate, otherInv,isBlocked,blockedUid,imageExist,invId,groupId,invName);
    }
}
