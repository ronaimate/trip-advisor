package com.ronaimate.tripadvisor.client;

import org.springframework.web.client.RestClient;

import com.ronaimate.tripadvisor.dto.Transportation;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TransportationServiceClient {

	private final RestClient restClient;

	public Transportation getTransportation(String airportCode) {
		return this.restClient.get()
				.uri("{airportCode}", airportCode)
				.retrieve()
				.body(Transportation.class);
	}

}
