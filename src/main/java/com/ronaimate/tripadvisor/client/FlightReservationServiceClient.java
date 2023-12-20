package com.ronaimate.tripadvisor.client;

import org.springframework.web.client.RestClient;

import com.ronaimate.tripadvisor.dto.FlightReservationRequest;
import com.ronaimate.tripadvisor.dto.FlightReservationResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FlightReservationServiceClient {

	private final RestClient client;

	public FlightReservationResponse reserve(FlightReservationRequest request) {
		return this.client.post()
				.body(request)
				.retrieve()
				.body(FlightReservationResponse.class);
	}

}
