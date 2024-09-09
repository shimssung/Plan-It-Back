package com.example.calendartodo_pjt.bbs.domain;

import java.time.LocalDate;
import lombok.Data;

@Data
public class EventRequestDTO {
    private LocalDate  day ;
    private String title ;
    private String content ;
    private String color ;


}
