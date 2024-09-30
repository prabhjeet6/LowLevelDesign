package designpatterns.statedesignpattern.elevatordesign.moves;

import designpatterns.statedesignpattern.elevatordesign.data.Direction;
import designpatterns.statedesignpattern.elevatordesign.data.Move;

import java.util.Optional;

public interface MoveStore {

    void addMove(Move move);

    Optional<Move> getTop();

    void clearTop();

    Direction getCurrentDirection();

}
