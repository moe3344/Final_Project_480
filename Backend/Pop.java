package Backend;
import java.util.ArrayList;

public class Pop {
    
    public static void main(String[] args) {
        Connector dp = new Connector();
        ArrayList<Flight> nn = dp.getFlights();
        for (Flight o : nn){
            System.out.println(o.getFlightCost());
        }

    }
}