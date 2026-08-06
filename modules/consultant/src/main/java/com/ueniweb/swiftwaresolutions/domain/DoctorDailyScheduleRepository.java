package com.ueniweb.swiftwaresolutions.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface DoctorDailyScheduleRepository extends JpaRepository<DoctorDailySchedule, Long> {

    boolean existsByDoctorIdAndAttendanceDate(Long doctorId, LocalDate attendanceDate);

    @Modifying
    @Query("UPDATE DoctorDailySchedule d SET d.scheduledStartTime = :scheduledStartTime, d.status = :status " +
           "WHERE d.doctorId = :doctorId AND d.attendanceDate = :attendanceDate")
    int updateScheduledStartTime(@Param("doctorId") Long doctorId,
                                 @Param("attendanceDate") LocalDate attendanceDate,
                                 @Param("scheduledStartTime") LocalTime scheduledStartTime,
                                 @Param("status") String status);
}

