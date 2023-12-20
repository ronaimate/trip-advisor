package com.ronaimate.tripadvisor.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import com.ronaimate.tripadvisor.dto.Flight;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FlightSearchServiceClient {

	private final RestClient client;

	public List<Flight> getFlights(String departure, String arrival) {
		return this.client.get()
				.uri("/{departure}/{arrival}", departure, arrival)
				.retrieve()
				.body(new ParameterizedTypeReference<>() {
				});
	}

}
