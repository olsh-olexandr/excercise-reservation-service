package com.grapeup.exercise.mapper;

import com.grapeup.exercise.dto.ReservationDto;
import com.grapeup.exercise.entity.Reservation;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DtoMapper {
    private final ModelMapper modelMapper;

    public ReservationDto convertToDto(Reservation reservation) {
        return modelMapper.map(reservation, ReservationDto.class);
    }

    public Reservation convertToEntity(ReservationDto reservationDto) {
        return modelMapper.map(reservationDto, Reservation.class);
    }
}
