package com.example.calendartodo_pjt.openapi.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class HistoryDaysDTO {

    private String dateName;

    private String locdate;

}
