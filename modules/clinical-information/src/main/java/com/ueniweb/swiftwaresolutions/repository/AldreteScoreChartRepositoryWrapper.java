package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.AldreteScoreChart;
import com.ueniweb.swiftwaresolutions.infrastructure.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class AldreteScoreChartRepositoryWrapper {
    @Autowired
    public AldreteScoreChartRepository aldreteScoreChartRepository;
    @Transactional(readOnly = true)
    public AldreteScoreChart findOneWithNotFoundDetection(final Long chId) {
        return this.aldreteScoreChartRepository.findById(chId).orElseThrow(() -> new NotFoundException("Aldrete ScoreChart not found for id : " + chId));
    }
}
