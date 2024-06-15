package org.firstgradle.firstgradle.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private LocalDate dateOfJoining;
    @JsonProperty("isActive")
    private boolean isActive;


}
