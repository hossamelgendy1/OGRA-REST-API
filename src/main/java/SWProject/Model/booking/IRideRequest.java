package SWProject.Model.booking;

import java.util.ArrayList;

import SWProject.Model.users.passengers.IPassenger;

public interface IRideRequest {
    public ArrayList<String> getEvents();
    public int getID();
    public void setSource(String source);
    public String getSource();
    public void setDestination(String destination);
    public String getDestination();
    public void setNoOfPassengers(int noOfPassengers);
    public int getNoOfPassengers();
    public void setItsPassenger(IPassenger itsPassenger);
    public IPassenger getItsPassenger();
    public void setAcceptedOffer(IOffer offer);
    public IOffer getAcceptedOffer();
    public void setPrice(double price);
    public double getPrice();
    //public double getDiscount();
    public double getCost(double price);
    public void addEvent(String eventName, String eventParticipants);
    public String showEvents();
}
