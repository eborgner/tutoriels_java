package quatredesuite.enumerations;

import java.util.ArrayList;
import java.util.List;

public class Direction {

    public int incrementHorizontal;
    public int incrementVertical;

    public static List<Direction> directions;

    static{

        directions = new ArrayList<>();

        // horizontal
        directions.add(new Direction(1,0));

        // vertical
        directions.add(new Direction(0,1));

        // diagonale /
        directions.add(new Direction(1,1));

        // diagonale \
        directions.add(new Direction(1,-1));

    }

    public Direction(int incrementHorizontal, int incrementVertical){
        this.incrementHorizontal = incrementHorizontal;
        this.incrementVertical = incrementVertical;
    }
}
