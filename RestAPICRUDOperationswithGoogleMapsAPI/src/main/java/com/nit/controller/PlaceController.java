package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.model.Place;
import com.nit.service.IPlaceService;

@RestController
@RequestMapping("/api/places")
public class PlaceController {
	@Autowired(required = true)
	private IPlaceService placeService;

    @GetMapping
    public List<Place> getAllPlaces() {
        return placeService.getAllPlaces();
    }

    @GetMapping("/{id}")
    public Place getPlaceById(@PathVariable String id) {
        return placeService.getPlaceById(id);
    }

    @PostMapping
    public Place createPlace(@RequestBody Place place) {
        return placeService.createPlace(place);
    }

    @DeleteMapping("/{id}")
    public void deletePlaceById(@PathVariable String id) {
        placeService.deletePlaceById(id);
    }

}
