package designpatterns.statedesignpattern.elevatordesign.elevator;

import designpatterns.statedesignpattern.elevatordesign.data.Direction;
import designpatterns.statedesignpattern.elevatordesign.data.Floor;
import designpatterns.statedesignpattern.elevatordesign.moves.MoveStore;
import designpatterns.statedesignpattern.elevatordesign.state.ElevatorState;

public class Elevator {

    private Floor currentFloor;
    private ElevatorState state;

    public MoveStore getMoveStore() {
        return moveStore;
    }

    private final MoveStore moveStore;

    public Elevator(MoveStore moveStore) {
        this.moveStore = moveStore;
    }

    public void destine(Floor floor, Direction direction) {
        this.state.destine(floor, direction);
    }

    public void open(Floor floor) {
        this.state.open(floor);
    }

    public void close(Floor floor) {
        this.state.close(floor);
    }

    public void stop(Floor floor) {
        this.state.stop(floor);
    }


    public Floor getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Floor currentFloor) {
        this.currentFloor = currentFloor;
    }

    public ElevatorState getState() {
        return state;
    }

    public void setState(ElevatorState state) {
        this.state = state;
    }

}
