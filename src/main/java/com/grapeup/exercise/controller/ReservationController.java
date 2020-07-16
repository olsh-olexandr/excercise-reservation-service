package com.grapeup.exercise.controller;

import com.grapeup.exercise.dto.ReservationDto;
import com.grapeup.exercise.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController extends AbstractCrudRestController<ReservationDto, ReservationService> {

    @GetMapping(params="roomNumber")
    public List<ReservationDto> getByRoomNumber(@RequestParam("roomNumber") long roomNumber){
        return getService().getByRoomNumber(roomNumber);
    }
}
