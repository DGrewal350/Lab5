package elevator;

/**
 *
 * @author daniel.grewal090
 */
public class Elevator {
    
    public final int MAX_CAPACITY = 10;
    
    private boolean moving_up;
    private int passenger_count;
    private int current_floor;
    private int[] passenger_targets;
    private Floor[] floors;
    private boolean[] stops;
    private int num_floors;
    
    public Elevator(Building building) {
        moving_up = true;
        passenger_count = 0;
        current_floor = 0;
        num_floors = building.NUM_FLOORS;
        passenger_targets = new int[num_floors];
        floors = new Floor[num_floors];
        stops = new boolean[num_floors];
        for (int i = 0; i < num_floors; i++) {
            floors[i] = building.floor(i + 1);
        }
    }
    
    public void move() {
        if (moving_up) {
            current_floor++;
        } else {
            current_floor--;
        }
        
        if (current_floor == 0) {
            moving_up = true;
        } else if (current_floor == num_floors - 1) {
            moving_up = false;
        }
        
        if (passenger_targets[current_floor] != 0) {
            stop();
        }
        if (stops[current_floor] == true) {
            stop();
        }
    }
    
    public void stop() {
        passenger_count -= passenger_targets[current_floor];
        passenger_targets[current_floor] = 0;
        stops[current_floor] = false;
        floors[current_floor].unloadPassengers(this, this.moving_up);
    }
    
    public void boardPassenger(int floor) throws ElevatorFullException{
        if (passenger_count < MAX_CAPACITY) {
            floor--;
            passenger_targets[floor]++;
            stops[floor] = true;
            passenger_count++;
        } else {
            throw new ElevatorFullException();
        }
    }
    
    public void registerRequest(int floor, boolean direction) {
        floor--;
        stops[floor] = true;
        moving_up = direction;
    }
    
    public int currentFloor() { return current_floor + 1; }
    public int getPassengers() { return passenger_count; }
    public boolean getDirection() { return moving_up; }
    
    public String toString() {
        int passengers = 0;
        for (int i = 0; i < passenger_targets.length; i++) {
            if (passenger_targets[i] > 0) {
                passengers += passenger_targets[i];
            }
        }
        return "Current Passengers: " + passengers + "\r\nCurrent Floor: " + (current_floor + 1) + "\r\nDirection: " + (moving_up ? "Up" : "Down");
    }
}
