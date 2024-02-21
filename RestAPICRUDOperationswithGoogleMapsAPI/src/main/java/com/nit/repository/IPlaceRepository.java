package com.nit.repository;

import java.util.List;

import com.nit.model.Place;

public interface IPlaceRepository {
	     List<Place> findAll();
	    Place findById(String id);
	    Place save(Place place);
	    void deleteById(String id);

}
