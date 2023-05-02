package com.project.coches.project_coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

/*
* Dto de un cliente
*  */
@Getter @Setter
public class CustomerDto {

    private String carId;
    private String fullName;
    private String email;
    private  String numberCellphone;
    private Integer active;
    private String password;

    @Override
    public String toString() {
        return "CustomerDto{" +
                "carId='" + carId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", numberCellphone='" + numberCellphone + '\'' +
                ", active=" + active +
                ", password='" + password + '\'' +
                '}';
    }
}
