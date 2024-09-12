package com.example.calendartodo_pjt.Events.domain;

import java.time.LocalDate;
import lombok.Data;

@Data
public class EventRequestDTO {
    private int         id ;
    private LocalDate  day ;
    private String title ;
    private String content ;
    private String color ;


}
