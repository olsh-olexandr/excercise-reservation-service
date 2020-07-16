package com.grapeup.exercise.dto;

import com.grapeup.exercise.entity.RoomType;
import lombok.Data;

@Data
public class RoomDto {
    private boolean available;
    private int number;
    private RoomType type;
}
