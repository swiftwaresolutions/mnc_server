package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.Anthropometry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnthropometryRepository extends JpaRepository<Anthropometry, Long> {

    @Query("select a from Anthropometry a where a.vstId=:vstId")
    List<Anthropometry> fetchanthropometryListByvstId(@Param("vstId") Long vstId);

}
