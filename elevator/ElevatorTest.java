package elevator;

/**
 *
 * @author daniel.grewal090
 */
public class ElevatorTest {
    static public void main(String argv[]) {
        Building test = new Building();
        Elevator elev = new Elevator(test);
        try{
            elev.boardPassenger(3);
            elev.boardPassenger(5);
        }
        catch (ElevatorFullException efe)
        {
            System.err.println("Err: Full");
        }
        System.out.printf("Floor %d: %d passengers\n", elev.currentFloor(), elev.getPassengers());
        for (int i = 0; i < 13; i++) {
            elev.move();
            System.out.printf("Floor %d: %d passengers\n", elev.currentFloor(), elev.getPassengers());
        }
    }
}
