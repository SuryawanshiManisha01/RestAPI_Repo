package com.nit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nit.Exception.PlaceNotFoundException;
import com.nit.controller.PlaceController;
import com.nit.model.Place;
import com.nit.repository.IPlaceRepository;


@SpringBootTest(classes = RestApicrudOperationswithGoogleMapsApiApplication.class)
public class PlaceControllerTest {

   @Autowired
    private PlaceController placeController;
    @Autowired
    private IPlaceRepository placeRepository;

    

    @Test
    public void getAllPlaces_ReturnsListOfPlaces() {
        List<Place> places = new ArrayList<>();
        places.add(new Place("1", "Place1", null, null));
        places.add(new Place("2", "Place2", null, null));

        placeRepository.save(new Place("1", "Place1", null, null));
        placeRepository.save(new Place("2", "Place2", null, null));

        List<Place> responsePlaces = placeController.getAllPlaces();

        assertEquals(places.size(), responsePlaces.size());
    }

    @Test
    public void getPlaceById_ReturnsPlace() {
        String placeId = "1";
        Place place = new Place(placeId, "Place1", placeId, null);

        placeRepository.save(new Place("1", "Place1", placeId, null));

        Place responsePlace = placeController.getPlaceById(placeId);

        assertEquals(place, responsePlace);
    }

    @Test
    public void createPlace_ReturnsCreatedPlace() {
        Place newPlace = new Place("3", "NewPlace", null, null);

        Place createdPlace = placeController.createPlace(newPlace);

        assertEquals(newPlace, createdPlace);
    }

    @Test
    public void deletePlaceById_ReturnsNoContent() {
        String placeId = "1";
        Place place = new Place(placeId, "Place1", placeId, null);

        placeRepository.save(new Place("1", "Place1", placeId, null));

        placeController.deletePlaceById(placeId);

        assertThrows(PlaceNotFoundException.class, () -> placeController.getPlaceById(placeId));
    }
}
