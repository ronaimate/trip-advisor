package com.ronaimate.tripadvisor.service;

import java.util.Comparator;

import org.springframework.stereotype.Service;

import com.ronaimate.tripadvisor.client.FlightReservationServiceClient;
import com.ronaimate.tripadvisor.client.FlightSearchServiceClient;
import com.ronaimate.tripadvisor.dto.Flight;
import com.ronaimate.tripadvisor.dto.FlightReservationRequest;
import com.ronaimate.tripadvisor.dto.FlightReservationResponse;
import com.ronaimate.tripadvisor.dto.TripReservationRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TripReservationService {

	private final FlightSearchServiceClient searchServiceClient;

	private final FlightReservationServiceClient reservationServiceClient;

	public FlightReservationResponse reserve(TripReservationRequest request) {
		var flights = this.searchServiceClient.getFlights(request.departure(), request.arrival());
		var bestDeal = flights.stream().min(Comparator.comparingInt(Flight::price));
		var flight = bestDeal.orElseThrow(() -> new IllegalStateException("no flights found"));
		var reservationRequest =
				new FlightReservationRequest(request.departure(), request.arrival(), flight.flightNumber(),
						request.date());
		return this.reservationServiceClient.reserve(reservationRequest);
	}

}