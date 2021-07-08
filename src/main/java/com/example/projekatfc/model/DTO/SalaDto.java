package com.example.projekatfc.model.DTO;

import com.example.projekatfc.model.FitnesCentar;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalaDto {
    private Long id;

    private Integer kapacitet;

    private String oznaka;

    private Long FitnesCentarId;
}
