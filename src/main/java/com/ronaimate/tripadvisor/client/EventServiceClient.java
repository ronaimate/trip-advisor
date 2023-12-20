package com.ronaimate.tripadvisor.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import com.ronaimate.tripadvisor.dto.Event;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EventServiceClient {

	private final RestClient client;

	public List<Event> getEvents(String airportCode) {
		return this.client.get()
				.uri("{airportCode}", airportCode)
				.retrieve()
				.body(new ParameterizedTypeReference<>() {
				});
	}

}
