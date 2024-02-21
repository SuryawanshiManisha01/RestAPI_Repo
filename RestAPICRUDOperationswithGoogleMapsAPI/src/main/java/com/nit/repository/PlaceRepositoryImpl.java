package com.nit.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.nit.model.Place;
@Repository
public class PlaceRepositoryImpl implements IPlaceRepository{

	private final Map<String, Place> placeMap = new HashMap<>();

    @Override
    public List<Place> findAll() {
        return placeMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Place findById(String id) {
        return placeMap.get(id);
    }

    @Override
    public Place save(Place place) {
        placeMap.put(place.getId(), place);
        return place;
    }

    @Override
    public void deleteById(String id) {
        placeMap.remove(id);
    }
	

}
