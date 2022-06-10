package ttr.Model;

import ttr.Constants.Locations;

public class RouteModel {
    private Locations location1, location2;

    public RouteModel(Locations location1, Locations location2) {
        this.location1 = location1;
        this.location2 = location2;
    }

    public Locations[] getLocations() {
        return new Locations[]{location1, location2};
    }
}
