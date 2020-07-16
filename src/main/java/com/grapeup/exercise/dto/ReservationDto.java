package com.grapeup.exercise.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReservationDto {
    private String username;
    private int numberOfPeople;
    private long roomNumber;
    private Date startDate, endDate;
}
