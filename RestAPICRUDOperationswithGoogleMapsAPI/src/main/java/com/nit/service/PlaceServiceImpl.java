package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.Exception.PlaceNotFoundException;
import com.nit.model.Place;
import com.nit.repository.IPlaceRepository;

@Service
public class PlaceServiceImpl implements IPlaceService{
	
	@Autowired
	private IPlaceRepository placeRepository;


    @Override
	public List<Place> getAllPlaces() {
     return placeRepository.findAll();
	}

	@Override
	public Place getPlaceById(String id){
		Place place = placeRepository.findById(id);
		if (place == null) {
			throw new PlaceNotFoundException("Place not found with ID: " + id);
		}
		return place;
	}

	@Override
	public Place createPlace(Place place) {
		// Implement logic to create a new place in the repository
		return placeRepository.save(place);
	}

	@Override
	public void deletePlaceById(String id) {
		Place place = placeRepository.findById(id);
		if (place == null) {
			throw new PlaceNotFoundException("Place not found with ID: " + id);
		}
		placeRepository.deleteById(id);
	}

}
