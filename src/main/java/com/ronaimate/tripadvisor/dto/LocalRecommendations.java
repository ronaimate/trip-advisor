package com.ronaimate.tripadvisor.dto;

import java.util.List;

public record LocalRecommendations(List<String> restaurants,
								   List<String> sightseeing) {

}
