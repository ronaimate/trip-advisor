package com.ronaimate.tripadvisor.client;

import org.springframework.web.client.RestClient;

import com.ronaimate.tripadvisor.dto.Weather;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WeatherServiceClient {

	private final RestClient restClient;

	public Weather getWeather(String airportCode) {
		return this.restClient.get()
				.uri("{airportCode}", airportCode)
				.retrieve()
				.body(Weather.class);
	}

}
