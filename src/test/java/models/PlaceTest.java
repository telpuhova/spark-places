package models;

import org.junit.Test;

import static org.junit.Assert.*;


public class PlaceTest {
    @Test
    public void Place_createObject_true() throws Exception {
        Place place = new Place("New York City");
        assertEquals(true, place instanceof Place);
        assertEquals("New York City", place.getName());
    }

    @Test
    public void getAll_returnAllPlaces() throws Exception {
        Place.clearAll();
        Place place1 = new Place("New York City");
        Place place2 = new Place("Grand Canyon");
        assertEquals(2, Place.getAll().size());
        assertEquals("Grand Canyon", Place.getAll().get(1).getName());
    }
}