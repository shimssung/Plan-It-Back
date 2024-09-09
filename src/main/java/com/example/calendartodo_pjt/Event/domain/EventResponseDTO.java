package com.example.calendartodo_pjt.Event.domain;

import java.time.LocalDate;

import lombok.Data;


// @Data 는 Getter, Setter, ToString을 모두 포함
@Data
public class EventResponseDTO {
    private int         id    ;
    private LocalDate   day ;
    private String      title ;
    private String      content ;
    private String      color ;
}
