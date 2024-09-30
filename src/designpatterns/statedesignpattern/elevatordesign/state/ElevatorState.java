package designpatterns.statedesignpattern.elevatordesign.state;

import designpatterns.statedesignpattern.elevatordesign.data.Direction;
import designpatterns.statedesignpattern.elevatordesign.data.Floor;
import designpatterns.statedesignpattern.elevatordesign.data.State;

public interface ElevatorState {
    void destine(Floor floor, Direction direction);
    void open(Floor floor);
    void close(Floor floor);
    void stop(Floor floor);
    State getName();
}
