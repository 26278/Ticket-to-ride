package ttr.Model;

import ttr.Constants.Locations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConnectionModel {
    private List<Set<Locations>> connections = new ArrayList<>();
    private static final int NOT_A_SET = -1;

    /**
     * This method adds a route to the keeper by giving the 2 locations that the route connects
     *
     * @param ELocation1 First Location of the route to be added
     * @param ELocation2 Second Location of the route to be added
     */
    public void addLocations(Locations ELocation1, Locations ELocation2) {
        int indexSet1 = getSetForELocation(ELocation1);
        int indexSet2 = getSetForELocation(ELocation2);
        if (isMergeable(indexSet1, indexSet2)) {
            mergeSets(indexSet1, indexSet2);
        } else if (isAddable(indexSet1)) {
            addELocationToSet(indexSet1, ELocation2);
        } else if (isAddable(indexSet2)) {
            addELocationToSet(indexSet2, ELocation1);
        } else {
            createNewSet(ELocation1, ELocation2);
        }
        System.out.println(connections);
    }

    /**
     * Add the locations associated with a route to the ConnectionKeeper
     *
     * @param route the route with the locations to add
     */
    public void addRoute(RouteModel route) {
        Locations[] locs = route.getLocations();
        addLocations(locs[0], locs[1]);
    }


    private boolean isMergeable(int set1, int set2) {
        return set1 != set2 && set1 != NOT_A_SET && set2 != NOT_A_SET;
    }

    private boolean isAddable(int set) {
        return set != NOT_A_SET;
    }


    /**
     * This method return the set that a location is found in
     *
     * @param ELocation1 Location to be checked
     * @return set that the location is found in
     */
    private int getSetForELocation(Locations ELocation1) {
        for (int i = 0, length = connections.size(); i < length; i++) {
            if (connections.get(i).contains(ELocation1)) {
                return i;
            }
        }
        return NOT_A_SET;
    }

    /**
     * Add ELocation to given set id
     *
     * @param set the set to add to
     * @param loc the location to add
     */
    private void addELocationToSet(int set, Locations loc) {
        connections.get(set).add(loc);
    }

    /**
     * Creates a new set for the given location
     *
     * @param ELocation1 first location
     * @param ELocation2 second location
     */
    private void createNewSet(Locations ELocation1, Locations ELocation2) {
        Set<Locations> newSet = new HashSet<>();
        newSet.add(ELocation1);
        newSet.add(ELocation2);
        connections.add(newSet);
    }

    /**
     * Merge two sets into one
     *
     * @param set1 first set
     * @param set2 second set
     */
    private void mergeSets(int set1, int set2) {
        connections.get(set1).addAll(connections.get(set2));
        connections.remove(set2);
    }

    /**
     * This method checks whether or not 2 locations are connected by a players routes
     *
     * @param ELocation1 First location of the complete route
     * @param ELocation2 Second location of the complete route
     * @return if the 2 locations are connected by the players routes
     */
    public boolean checkForRouteCompleted(Locations ELocation1, Locations ELocation2) {
        int set1 = getSetForELocation(ELocation1);
        int set2 = getSetForELocation(ELocation2);
        return set1 == set2 && set1 != NOT_A_SET;
    }

    /**
     * Checks if a RouteCrd is finished. Calls checkForRouteCompleted internally
     *
     * @param routeCard the RouteCard to check
     * @return true if a routecard is completed or false
     */
//    public boolean isRouteCardCompleted(RouteCard routeCard) {
//        return checkForRouteCompleted(routeCard.getStart(), routeCard.getEnd());
//    }
}

