package com.torneo.futbol.dto;

import com.torneo.futbol.model.Position;

import lombok.Data;

@Data
public class PlayerDTO {
    private Long teamId;
    private String name;
    private String surname;
    private Position position;
    private Integer number;
    private Integer goals;
    private Integer yellowCards;
    private Integer redCards;
}
