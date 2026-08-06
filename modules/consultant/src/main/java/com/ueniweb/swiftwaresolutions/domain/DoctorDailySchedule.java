package com.ueniweb.swiftwaresolutions.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity(name = "DoctorDailySchedule")
@Table(name = "doctor_daily_schedule")
@Getter
@Setter
public class DoctorDailySchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "doctor_id")
    private Long doctorId;

    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "attendance_date")
    private LocalDate attendanceDate;

    @Column(name = "scheduled_start_time")
    private LocalTime scheduledStartTime;

    @Column(name = "scheduled_end_time")
    private LocalTime scheduledEndTime;

    @Column(name = "actual_check_in")
    private LocalTime actualCheckIn;

    @Column(name = "actual_check_out")
    private LocalTime actualCheckOut;

    @Column(name = "max_tokens")
    private Integer maxTokens;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "is_leave")
    private Integer isLeave;

    @Column(name = "leave_reason")
    private String leaveReason;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "is_valid")
    private Integer isValid;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_by")
    private Long updatedBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
