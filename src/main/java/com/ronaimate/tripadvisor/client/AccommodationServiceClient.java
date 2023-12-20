package com.ronaimate.tripadvisor.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import com.ronaimate.tripadvisor.dto.Accommodation;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccommodationServiceClient {

	private final RestClient client;

	public List<Accommodation> getAccommodations(String airportCode) {
		return this.client.get()
				.uri("{airportCode}", airportCode)
				.retrieve()
				.body(new ParameterizedTypeReference<>() {
				});
	}

}
