package com.grapeup.exercise.service;

import com.grapeup.exercise.dto.ReservationDto;
import com.grapeup.exercise.entity.Reservation;
import com.grapeup.exercise.mapper.DtoMapper;
import com.grapeup.exercise.repo.ReservationRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivilegedAction;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservationService implements SimpleRestService<ReservationDto> {
    private final ReservationRepository reservationRepository;
    private final DtoMapper mapper;

    @Override
    public List<? extends ReservationDto> getAll() {
        return reservationRepository.findAll()
                .stream()
                .map(mapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void removeById(long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public long create(ReservationDto reservationDto) {
        Function<ReservationDto, Reservation> convertToDto = mapper::convertToEntity;
        return convertToDto
                .andThen(reservationRepository::save)
                .apply(reservationDto)
                .getId();
    }

    @Override
    public void update(ReservationDto reservationDto, long id) {
        Function<ReservationDto, Reservation> convertToDto = mapper::convertToEntity;
        convertToDto
            .andThen(entity -> entity.setId(id))
            .andThen(reservationRepository::save)
            .apply(reservationDto);
    }

    @Override
    public Optional<ReservationDto> getById(long id) {
        return reservationRepository.findById(id)
                .map(mapper::convertToDto);
    }

    public List<ReservationDto> getByRoomNumber(long roomNumber) {
        return reservationRepository.findAllByRoomNumber(roomNumber)
                .stream()
                .map(mapper::convertToDto)
                .collect(Collectors.toList());
    }
}
