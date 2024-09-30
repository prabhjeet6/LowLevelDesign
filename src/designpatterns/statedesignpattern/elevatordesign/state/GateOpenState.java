package designpatterns.statedesignpattern.elevatordesign.state;

import designpatterns.statedesignpattern.elevatordesign.data.Direction;
import designpatterns.statedesignpattern.elevatordesign.data.Floor;
import designpatterns.statedesignpattern.elevatordesign.data.State;
import designpatterns.statedesignpattern.elevatordesign.elevator.Elevator;

public class GateOpenState implements ElevatorState{

    private final Elevator elevator;

    public GateOpenState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void destine(Floor floor, Direction direction) {
        throw new RuntimeException();
    }



    @Override
    public void open(Floor floor) {
        throw new RuntimeException();
    }

    @Override
    public void close(Floor floor) {
        Direction direction = this.elevator.getMoveStore().getCurrentDirection();
        if (direction.equals(Direction.UP)) {
            this.elevator.setState(new MovingUpState(this.elevator));
        } else if (direction.equals(Direction.DOWN)) {
            this.elevator.setState(new MovingDownState(this.elevator));
        } else if (direction.equals(Direction.HALT)) {
            this.elevator.setState(new IdleState(this.elevator));
        }
    }

    @Override
    public void stop(Floor floor) {
        throw new RuntimeException();
    }

    @Override
    public State getName() {
        return State.GATEOPEN;
    }
}