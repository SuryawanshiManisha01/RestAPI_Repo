package com.nit.service;

import java.util.List;

import com.nit.model.Place;

public interface IPlaceService {
	
	List<Place> getAllPlaces();
    Place getPlaceById(String id);
    Place createPlace(Place place);
    void deletePlaceById(String id);

}
