package com.ueniweb.swiftwaresolutions.repository;

import com.ueniweb.swiftwaresolutions.domain.InvImgUpload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImgInvRepository extends JpaRepository<InvImgUpload, Long> {
}
