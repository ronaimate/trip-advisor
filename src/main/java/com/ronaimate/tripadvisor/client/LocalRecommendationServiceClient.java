package com.ronaimate.tripadvisor.client;

import org.springframework.web.client.RestClient;

import com.ronaimate.tripadvisor.dto.LocalRecommendations;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LocalRecommendationServiceClient {

	private final RestClient restClient;

	public LocalRecommendations getRecommendations(String airportCode) {
		return this.restClient.get()
				.uri("{airportCode}", airportCode)
				.retrieve()
				.body(LocalRecommendations.class);
	}

}
