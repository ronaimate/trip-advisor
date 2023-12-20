package com.ronaimate.tripadvisor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronaimate.tripadvisor.dto.FlightReservationResponse;
import com.ronaimate.tripadvisor.dto.TripPlan;
import com.ronaimate.tripadvisor.dto.TripReservationRequest;
import com.ronaimate.tripadvisor.service.TripPlanService;
import com.ronaimate.tripadvisor.service.TripReservationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("trip")
@RestController
public class TripController {

	private final TripPlanService planService;

	private final TripReservationService reservationService;

	@GetMapping("{airportCode}")
	public TripPlan planTrip(@PathVariable String airportCode) {
		return planService.getTripPlan(airportCode);
	}

	@PostMapping("reserve")
	public FlightReservationResponse reserve(@RequestBody TripReservationRequest request) {
		return reservationService.reserve(request);
	}


}
