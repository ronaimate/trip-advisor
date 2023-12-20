package com.ronaimate.tripadvisor.service;

import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;

import com.ronaimate.tripadvisor.client.AccommodationServiceClient;
import com.ronaimate.tripadvisor.client.EventServiceClient;
import com.ronaimate.tripadvisor.client.LocalRecommendationServiceClient;
import com.ronaimate.tripadvisor.client.TransportationServiceClient;
import com.ronaimate.tripadvisor.client.WeatherServiceClient;
import com.ronaimate.tripadvisor.dto.TripPlan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class TripPlanService {

	private final EventServiceClient eventServiceClient;

	private final WeatherServiceClient weatherServiceClient;

	private final AccommodationServiceClient accommodationServiceClient;

	private final TransportationServiceClient transportationServiceClient;

	private final LocalRecommendationServiceClient localRecommendationServiceClient;

	private final ExecutorService executor;

	public TripPlan getTripPlan(String airportCode) {
		var events = this.executor.submit(() -> this.eventServiceClient.getEvents(airportCode));
		var weather = this.executor.submit(() -> this.weatherServiceClient.getWeather(airportCode));
		var accommodations =
				this.executor.submit(() -> this.accommodationServiceClient.getAccommodations(airportCode));
		var transportation =
				this.executor.submit(() -> this.transportationServiceClient.getTransportation(airportCode));
		var recommendations =
				this.executor.submit(() -> this.localRecommendationServiceClient.getRecommendations(airportCode));
		return new TripPlan(
				airportCode,
				getOrElse(accommodations, Collections.emptyList()),
				getOrElse(weather, null),
				getOrElse(events, Collections.emptyList()),
				getOrElse(recommendations, null),
				getOrElse(transportation, null)
		);
	}

	private <T> T getOrElse(Future<T> future, T defaultValue) {
		try {
			return future.get();
		} catch (Exception e) {
			log.error("error", e);
		}
		return defaultValue;
	}

}