package elevator;

/**
 *
 * @author daniel.grewal090
 */
public class ElevatorFullException extends java.lang.Exception {
	public ElevatorFullException(String message) {
		super(message);
	}
	public ElevatorFullException() {
		super("Elevator Full:");
	}
}