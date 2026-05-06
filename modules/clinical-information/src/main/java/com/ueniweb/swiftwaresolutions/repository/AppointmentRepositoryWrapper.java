package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.Appointment;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class AppointmentRepositoryWrapper {

    private final AppointmentRepository appointmentRepository;

    @Transactional(readOnly = true)
    public Appointment findOneWithNotFoundDetection(final Long id){
        return this.appointmentRepository.findById(id).orElseThrow(()-> new NotFoundException("Appointment Register not found for id : "+id));
    }
}
