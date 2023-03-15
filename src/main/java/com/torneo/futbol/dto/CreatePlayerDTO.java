package com.torneo.futbol.dto;

import lombok.Data;

@Data
public class CreatePlayerDTO {
    private Long teamId;
    private String name;
    private String surname;
    private String position;
    private Integer number;
    private Integer goals;
    private Integer yellowCards;
    private Integer redCards;
}
