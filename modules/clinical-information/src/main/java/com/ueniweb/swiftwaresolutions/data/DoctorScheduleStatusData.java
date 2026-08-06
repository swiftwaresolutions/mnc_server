package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class DoctorScheduleStatusData {

    private Long id;
    private Long doctorId;
    private String status;
    private String attendanceDate;

    public DoctorScheduleStatusData(Long id, Long doctorId, String status, String attendanceDate) {
        this.id = id;
        this.doctorId = doctorId;
        this.status = status;
        this.attendanceDate = attendanceDate;
    }

    public static DoctorScheduleStatusData newInstance(Long id, Long doctorId, String status, String attendanceDate) {
        return new DoctorScheduleStatusData(id, doctorId, status, attendanceDate);
    }
}

