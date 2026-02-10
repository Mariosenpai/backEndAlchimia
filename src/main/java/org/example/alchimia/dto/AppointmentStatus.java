package org.example.alchimia.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class AppointmentStatus {

    private String doctorId;
    private Integer procedureCode;
    private Date dateTime;
    private String patientName;
    private Boolean status;

}
