package src;

public class Elevator {
    private boolean isOpen;
    private int currCapacity;
    private int currFloor;
    private int direction;
    private int destination;
    public Elevator (int iFloor){
        this.destination = iFloor;
    }

    public String toString(){
        return "This elevator is heading up to floor " + destination;
    }
}
