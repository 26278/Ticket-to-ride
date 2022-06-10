package ttr.Model;

import javafx.util.Pair;
import ttr.Constants.Locations;
import ttr.Shared.ConnectionAndLengthPair;

import java.util.*;

public class ConnectionModel {
    private List<ConnectionAndLengthPair> connections = new ArrayList<>();
    private static final int NOT_A_SET = -1;

    /**
     * This method adds a route to the keeper by giving the 2 locations that the route connects
     *
     * @param ELocation1 First Location of the route to be added
     * @param ELocation2 Second Location of the route to be added
     */
    public void addLocations(Locations ELocation1, Locations ELocation2, int length) {
        int indexSet1 = getSetForELocation(ELocation1);
        int indexSet2 = getSetForELocation(ELocation2);
        if (isMergeable(indexSet1, indexSet2)) {
            mergeSets(indexSet1, indexSet2);
        } else if (isAddable(indexSet1)) {
            addELocationToSet(indexSet1, ELocation2, length);
        } else if (isAddable(indexSet2)) {
            addELocationToSet(indexSet2, ELocation1, length);
        } else {
            createNewSet(ELocation1, ELocation2, length);
        }
        for (ConnectionAndLengthPair pair : connections) {
            System.out.println(pair.getLocationsSet() + "+" + pair.getLength());
        }
    }

    /**
     * Add the locations associated with a route to the ConnectionKeeper
     *
     * @param route the route with the locations to add
     */
    public void addRoute(RouteModel route) {
        Locations[] locs = route.getLocations();
        addLocations(locs[0], locs[1], route.getLength());
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
        for (int i = 0; i < connections.size(); i++) {
            if (connections.get(i).getLocationsSet().contains(ELocation1)) {
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
    private void addELocationToSet(int set, Locations loc, int length) {
        connections.get(set).getLocationsSet().add(loc);
        connections.get(set).setLength(connections.get(set).getLength() + length);
    }

    /**
     * Creates a new set for the given location
     *
     * @param ELocation1 first location
     * @param ELocation2 second location
     */
    private void createNewSet(Locations ELocation1, Locations ELocation2, int length) {
        Set<Locations> newSet = new HashSet<>();
        newSet.add(ELocation1);
        newSet.add(ELocation2);
        connections.add(new ConnectionAndLengthPair(newSet, length));
    }

    /**
     * Merge two sets into one
     *
     * @param set1 first set
     * @param set2 second set
     */
    private void mergeSets(int set1, int set2) {
        Set<Locations> locSet1 = connections.get(set1).getLocationsSet();
        Set<Locations> locSet2 = connections.get(set2).getLocationsSet();
        int set1Length = connections.get(set1).getLength();
        int set2Length = connections.get(set2).getLength();
        locSet1.addAll(locSet2);
        connections.get(set1).setLength(set1Length + set2Length);
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

    public int getLongestRoute() {
        int longestRouteLength = 0;
        for (ConnectionAndLengthPair pair : connections) {
            if (pair.getLength() > longestRouteLength) {
                longestRouteLength = pair.getLength();
            }
        }
        return longestRouteLength;
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

