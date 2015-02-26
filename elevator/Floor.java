package elevator;

/**
 *
 * @author daniel.grewal090
 */
public class Floor {
    private int floor_num;
    private int passengers_waiting_up;
    private int passengers_waiting_down;
    
    public Floor(Building building, int floorNumber) {
        floor_num = floorNumber;
        passengers_waiting_up = 0;
        passengers_waiting_down = 0;
        
    }
    
    int passengersWaiting() { return passengers_waiting_up + passengers_waiting_down; }
    void waitForElevator() { 
        if (floor_num > 2)
            passengers_waiting_down++;
        else
            passengers_waiting_up++;
    }
    
    public void unloadPassengers(Elevator elev, boolean going_up) {
        int passengers = going_up?passengers_waiting_up:passengers_waiting_down;
        for(; passengers > 0; passengers--) {
            try {
                elev.boardPassenger(1);
            }
            catch (ElevatorFullException e) {
                System.out.println(e.getMessage());
                elev.registerRequest(floor_num, going_up);
                break;
            }
        }
    }
}
