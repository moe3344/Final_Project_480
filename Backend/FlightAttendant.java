package Backend;

import java.util.ArrayList;

public class FlightAttendant extends User {
    FlightAttendant(String userName, String password) {
        super(userName, password);

    }

    public void showPassengerList(ArrayList<User> x) {
        for (User s : x) {
            System.out.print(s.getName());
            System.out.print("     " + s.getUserID());
            System.out.print("    Dlight ID" + s.getSelectedFlight());
            System.out.print("    DueAmount" + s.getDueAmount());

            System.out.print("    SelectedSeat" + s.getSelectedSeat());
            System.out.print("    Phone number" + s.getPhone());
            System.out.print("    Address" + s.getAddress());
            System.out.println();
            System.out.println();

        }

    }

}
