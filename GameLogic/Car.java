package GameLogic;

import java.awt.*;

/**
 * This class creates a new Car object for the game. It implements the car object, its movement and bounds
 * @author Arash Tashakori
 */
public class Car{
    private Point currentPosition;
    private Color bodyColour;
    private int movementSpeed;  //(in pixels)
    private int xSize;
    private int ySize;
    private boolean moveLeft;

    /**
     * Creates a new Car object for the Frogger game
     * @param currentPosition
     * @param bodyColour
     * @param movementSpeed how fast the car moves (in pixels)
     * @param xSize    car's size (in pixel) in the horizontal (x) direction
     * @param ySize    car's size (in pixel) in the vertical (y) direction
     * @param moveLeft  cars move from right to left (if true) or left to right (if false)
     */
    public Car (Point currentPosition, Color bodyColour, int movementSpeed, int xSize, int ySize, boolean moveLeft){
        //Initializing the instance variables based on the parameters:
        this.currentPosition = currentPosition;
        this.bodyColour = bodyColour;
        this.movementSpeed = movementSpeed;
        this.xSize = xSize;
        this.ySize = ySize;
        this.moveLeft = moveLeft;
    }

    /**
     * Returns the current position of the Car object
     * @return
     */
    public Point getCurrentPosition(){
        return currentPosition;
    }

    /**
     * Returns the Car object's body colour
     * @return
     */
    public Color getBodyColour(){
        return bodyColour;
    }

    /**
     * Returns the car's size (in pixel) in the horizontal (x) direction
     * @return
     */
    public int getXSize(){
        return xSize;
    }

    /**
     * Returns the car's size (in pixel) in the vertical (y) direction
     * @return
     */
    public int getYSize(){
        return ySize;
    }

    /**
     * Returns the Car object's movement speed (in pixels)
     * @return
     */
    public int getMovementSpeed() {
        return movementSpeed;
    }

    /**
     * Returns whether the car is moving from right to left or left to right
     * @return true if the car is moving from right to left; false otherwise
     */
    public boolean isMoveLeft(){
        return moveLeft;
    }

    /**
     * This method moves the Car object according to movement speed (step/value) and the direction of movement.
     * If the moveLeft variable is true, the movement will be from right to left, otherwise, it will be from left
     * to right.
     */
    public void move(){
        if (moveLeft){
            currentPosition.setLocation(currentPosition.getX() - movementSpeed, currentPosition.getY());
        }
        else{
            currentPosition.setLocation(currentPosition.getX() + movementSpeed, currentPosition.getY());
        }
    }

    /**
     * Returns the bounds of the car object which can be used to detect collision
     * @return A Rectangle object defining the bounds of the car
     */
    public Rectangle getCollisionBounds(){
        return new Rectangle(currentPosition.x, currentPosition.y,xSize,ySize);
    }
}