package SWProject.Model.storage;

import java.util.ArrayList;
import SWProject.Model.users.admin.*;
import SWProject.Model.users.passengers.*;
import SWProject.Model.users.drivers.*;
import SWProject.Model.booking.*;

public class SystemData implements ISystemData {

    private static SystemData instance;
    private ISystemDataStrategy dataContainer;

    private SystemData(){
        dataContainer = new ArrayListStrategy(); //default type
    }

    public static SystemData getInstance(){
        if (instance == null)
            instance = new SystemData();
        return instance;
    }
    
    @Override
    public void setStrategy(ISystemDataStrategy strategy) {
        dataContainer = strategy;
    }

    @Override
    public IAdmin getAdmin(String username) {
        return dataContainer.getAdmin(username);
    }

    @Override
    public boolean addRegistrationRequest(IRegistrationRequest registrationRequest) {
        return dataContainer.addRegistrationRequest(registrationRequest);
    }

    @Override
    public boolean addDriver(IDriver driver) {
        return dataContainer.addDriver(driver);
    }

    @Override
    public boolean addPassenger(IPassenger passenger) {
        return dataContainer.addPassenger(passenger);
    }

    @Override
    public boolean addOffer(IOffer offer) {
        return dataContainer.addOffer(offer);
    }

    @Override
    public boolean addRideRequest(IRideRequest rideRequest) {
        return dataContainer.addRideRequest(rideRequest);
    }

    @Override
    public boolean addRide(IRide ride) {
        return dataContainer.addRide(ride);
    }

    @Override
    public boolean addRating(IRating rating) {
        return dataContainer.addRating(rating);
    }

    @Override
    public IRegistrationRequest getRegistrationRequestById(int id) {
        return dataContainer.getRegistrationRequestById(id);
    }

    @Override
    public IRegistrationRequest getRegistrationRequest(String username) {
        return dataContainer.getRegistrationRequest(username);
    }

    @Override
    public IRideRequest getRideRequest(int index) {
        return dataContainer.getRideRequest(index);
    }

    @Override
    public IDriver getDriver(String username) {
        return dataContainer.getDriver(username);
    }

    @Override
    public IPassenger getPassenger(String username) {
        return dataContainer.getPassenger(username);
    }

    @Override
    public boolean removeRegisrationRequest(IRegistrationRequest registrationRequest) {
        return dataContainer.removeRegisrationRequest(registrationRequest);
    }

    @Override
    public String displayAllRegistrations() {
        return dataContainer.displayAllRegistrations();
    }

    @Override
    public String displayAllRideRequests() {
        return dataContainer.displayAllRideRequests();
    }

    @Override
    public ArrayList<IDriver> getDriversWithFavouriteArea(String area) {
        return dataContainer.getDriversWithFavouriteArea(area);
    }

    @Override
    public ArrayList<IOffer> getOffersOfPassenger(IPassenger passenger) {
        return dataContainer.getOffersOfPassenger(passenger);
    }

    @Override
    public ArrayList<IOffer> getOffersOfDriver(IDriver driver) {
        return dataContainer.getOffersOfDriver(driver);
    }

    @Override
    public ArrayList<IRating> gerRatingsOfDriver(IDriver driver) {
        return dataContainer.gerRatingsOfDriver(driver);
    }

    @Override
    public ArrayList<IRideRequest> getRidesOfDriverFavouriteAreas(IDriver driver) {
        return dataContainer.getRidesOfDriverFavouriteAreas(driver);
    }

    @Override
    public boolean containsRideOfPassenger(IPassenger passenger) {
        return dataContainer.containsRideOfPassenger(passenger);
    }

    @Override
    public boolean containsDiscountArea(String destination) {
        return dataContainer.containsDiscountArea(destination);
    }

    @Override
    public boolean addDiscountArea(String area) {
        return dataContainer.addDiscountArea(area);
    }

    @Override
    public boolean removeDiscountArea(String area) {
        return dataContainer.removeDiscountArea(area);
    }

    @Override
    public IRideRequest getRideRequestByID(int id) {
        return dataContainer.getRideRequestByID(id);
    }

    @Override
    public IOffer getOfferByID(int id) {
        return dataContainer.getOfferByID(id);
    }
}
