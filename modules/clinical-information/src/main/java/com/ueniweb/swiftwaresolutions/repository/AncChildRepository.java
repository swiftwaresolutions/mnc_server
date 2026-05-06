package com.ueniweb.swiftwaresolutions.repository;
import com.ueniweb.swiftwaresolutions.domain.AncChildDetialsSheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AncChildRepository extends JpaRepository<AncChildDetialsSheet, Long>{
//    @Query("SELECT xy FROM AncChildDetialsSheet xy WHERE xy.anc_id = :id ")
//    List<AncChildDetialsSheet> fetchAncChildDetials(@Param("id") Long anc_id);


}
