package com.ueniweb.swiftwaresolutions.controllers.imgInv;

import com.ueniweb.swiftwaresolutions.request.CreateImgInvUploadRequest;
import com.ueniweb.swiftwaresolutions.services.ClinicalInfoReadPlatformService;
import com.ueniweb.swiftwaresolutions.services.ClinicalInfoWritePlatformService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/invImg")
@RequiredArgsConstructor
@Slf4j
public class ImgInvController {



    private final ClinicalInfoWritePlatformService clinicalInfoWritePlatformService;

    private final ClinicalInfoReadPlatformService clinicalInfoReadPlatformService;

    @PostMapping("/uploadImage")
    public ResponseEntity<String> uploadImage(
            @RequestParam("file") List<MultipartFile> files,
            @RequestParam("CreateImgInvUploadRequest") String invImageDetails
    ){
        return this.clinicalInfoWritePlatformService.uploadInvImage(files,invImageDetails);
    }

    @GetMapping("/getImage/{id}")
    public ResponseEntity<?> getImage(@PathVariable Long id) {
        return clinicalInfoReadPlatformService.getImageById(id);
    }

}
