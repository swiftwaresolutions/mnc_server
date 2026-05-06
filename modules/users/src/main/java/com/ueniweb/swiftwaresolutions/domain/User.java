package com.ueniweb.swiftwaresolutions.domain;

import com.ueniweb.swiftwaresolutions.dtos.UserDTO;
import com.ueniweb.swiftwaresolutions.repository.DepartmentRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.Date;

@Entity(name = "Users")
@Table(name = "admin_users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "pass")
    private String pass;

    @Column(name = "is_block")
    private int isBlock;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "sex")
    private String sex;

    @Column(name = "is_married")
    private int isMarried;

    @Column(name = "dom")
    private Date dom;

    @Column(name = "is_msg_displayed")
    private int isMsgDisplayed;

    @Column(name = "is_doctor")
    private int isDoctor;

    @Column(name = "doctor_id")
    private Long doctor_id;

    @Column(name = "is_admin")
    private int is_admin;

    public UserDTO to(ConsultantRepository consultantRepo, DepartmentRepository deptRepo) {
        UserDTO userDTO = new UserDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(this, userDTO);
        userDTO.setIsDoctor(isDoctor);
        userDTO.setDoctorId(doctor_id);
        userDTO.setIsAdmin(is_admin);


        if (doctor_id != 0 ) {
            Consultant consultant = consultantRepo.findById(doctor_id).orElse(null);
            if (consultant != null) {
                userDTO.setDoctorName(consultant.getName());
                if (consultant.getDeptId() != null) {
                    Department department = deptRepo.findById(consultant.getDeptId()).orElse(null);
                    if (department != null) {
                        userDTO.setDepartmentId(department.getId());
                        userDTO.setDepartmentName(department.getName());
                    }
                }
            }
        }

        return userDTO;
    }
}
