import java.sql.*;
import java.util.ArrayList;

public class Connector{
 protected Connection dbConnect;
  protected ResultSet results;
   protected ArrayList < Flight > myFlights;
  Connector(){
     myFlights = new ArrayList <> ();
    createConnection();
selectFLights();}
  public void createConnection() {

    try {
      dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/ewr", "ENSF 380", "0953326601");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public void selectFLights () {
   

    try {

      Statement myStmt = dbConnect.createStatement();
      results = myStmt.executeQuery("SELECT * FROM animals");
      

      while (results.next()) {
        

        Flight newFlight = new Flight(results.getInt("FlightID"), results.getString("FlightStartPoint"), results.getString("FlightDest"),results.getDouble("FlightCost"), results.getDate("FlightArrivalTime"),results.getDate("FlightLeavingTime"),results.getInt("AvailableBussinesSeats"),results.getInt("AvailableComfortSeats"),results.getInt("AvailableOrdinarySeats"));

        //Adding read object to the arraylist of animals
        myFlights.add(newFlight);
        
      }
    
    }
    catch (SQLException ex) {
        ex.printStackTrace();
      }
  }
  public ArrayList<Flight> getFlights(){
    return myFlights;

  }
}