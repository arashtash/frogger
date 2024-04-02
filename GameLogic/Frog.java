package GameLogic;

import java.awt.*;

/**
 * This class creates a Frog object for the game. It can initialize, move and translate the frog and it can also find
 * the distance of the frog object's current location with any given point, get its collision bounds.
 * @author Arash Tashakori
 */
public class Frog {

    private String name;
    private Point currentPosition;

    /**
     * Initializes a new Frog object with a given name and creates it in a given location in the game.
     * @param name  the name of the frog
     * @param currentPosition   the initial location of the new frog object in the game
     */
    public Frog (String name, Point currentPosition){
        this.name = name;
        this.currentPosition = currentPosition;
    }

    /**
     * Initializes a new Frog object with a given name and creates it at position (0,0)
     * @param name
     */
    public Frog (String name){
        this.name = name;
        currentPosition = new Point (0,0);
    }

    /**
     * Returns the current position of the Frog object as it moves through the game
     * @return
     */
    public Point getCurrentPosition(){
        return currentPosition;
    }

    /**
     * Returns the name of the frog
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * Moves (translates) the Frog object in the game by receiving an X and Y translations as parameters
     * @param dx  Change in x
     * @param dy   Change in y
     * @return
     */
    public Point move (int dx, int dy){
        currentPosition.translate(dx,dy);
        return currentPosition;
    }

    /**
     * This method receives a given Point as a parameter and returns the distance between that given Point and the
     * current location of the Frog object
     * @param givenPoint
     * @return  distance between point and Frog
     */
    public double distanceFromPoint (Point givenPoint){
        double distance = currentPosition.distance(givenPoint);
        return distance;
    }

    /**
     * Returns the bounds of the car object which can be used to detect collision
     * @return
     */
    public Rectangle getCollisionBounds(){
        return new Rectangle(currentPosition.x,currentPosition.y,30,30);
    }

    /**
     * Returns a String representation of the frog object
     * @return
     */
    public String toString(){
        String frogToString = "";
        frogToString = "The frog named " + name + " is at (";
        frogToString += (int)currentPosition.getX() + "," + (int)currentPosition.getY() + ")";
        return frogToString;
    }
}