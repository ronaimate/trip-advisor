package com.ronaimate.tripadvisor.dto;

import java.util.List;

public record Transportation(List<CarRental> carRentals,
							 List<PublicTransportation> publicTransportations) {

}
