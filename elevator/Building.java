package elevator;

/**
 *
 * @author daniel.grewal090
 */
public class Building {
    public final int NUM_FLOORS = 7;
    
    private Elevator elev;
    private Floor[] floors;
    
    public Building() {
        floors = new Floor[NUM_FLOORS];
        for (int i = 0; i < NUM_FLOORS; i++) {
            floors[i] = new Floor(this, i + 1);
        }
        elev = new Elevator(this);
    }
    
    Elevator elevator() { return elev; }
    Floor floor(int floorNumber) { return floors[floorNumber - 1]; }
}
