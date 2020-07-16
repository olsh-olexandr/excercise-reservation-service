package com.grapeup.exercise.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum RoomType {
    BASIC (4),
    SUITE (6),
    PENTHOUSE (8);

    @Getter
    private int maxPeople;
}
