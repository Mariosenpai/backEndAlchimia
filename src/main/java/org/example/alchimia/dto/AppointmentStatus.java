package org.example.alchimia.dto;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AppointmentStatus {

    private String doctorId;
    private String procedureCode;
    private LocalDateTime dateTime;
    private String patientName;
    private Boolean status;

}
