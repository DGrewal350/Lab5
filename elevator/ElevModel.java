/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

/**
 *
 * @author Daniel
 */
class ElevModel {
    private Building build = new Building();
    private Elevator elev = new Elevator(build);

    public ElevModel() {
        try {
        elev.boardPassenger(3);
        elev.boardPassenger(5);
        }
        catch (ElevatorFullException efe)
        {
            System.err.println("Err: Full");
        }   
    }
    
    public void moveElev() {
        elev.move();
    }
    
    public int updateFloor() {
        return elev.currentFloor();
    }
    
    public int updatePass() {
        return elev.getPassengers();
    }
    
    public boolean updateDir() {
        return elev.getDirection();
    }
}
