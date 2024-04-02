package GameLogic;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * This class initializes a Frogger game. It uses Frog and Car objects. It initializes a Frog and 4 Car objects.
 * It implements moving the Frog and also checks if the player was hit or whether the player has won yet or not
 * @author Arash Tashakori
 */
public class Game{
    private Frog player;
    private ArrayList <Car> cars;

    /**
     * This methods creates a new game by initializing the player (a Frog object) and  four Car objects
     * @param name
     * @param startingPosition
     */
    public Game (String name, Point startingPosition){
        player = new Frog (name, startingPosition);

        cars = new ArrayList<>();
        //First Car:
        Point firstCarsPoint = new Point (100,400);
        Car firstCar = new Car (firstCarsPoint, Color.BLACK, 10, 120, 75, false);
        //Second Car:
        Point secondCarsPoint = new Point (0,300);
        Car secondCar = new Car (secondCarsPoint, Color.BLUE, 30, 200, 75, false);
        //Third Car:
        Point thirdCarsPoint = new Point (100, 150);
        Car thirdCar = new Car (thirdCarsPoint, Color.BLACK, 10, 120, 75, true);
        //Fourth Car:
        Point fourthCarsPoint = new Point (0,80);
        Car fourthCar = new Car (fourthCarsPoint, Color.BLACK, 20, 120, 75, true);

        cars.add(firstCar);
        cars.add(secondCar);
        cars.add(thirdCar);
        cars.add(fourthCar);
    }

    /**
     * Returns the Frog object
     * @return
     */
    public Frog getPlayer(){
        return player;
    }

    /**
     * Returns the ArrayList of Car objects in the game
     * @return
     */
    public ArrayList<Car> getCars(){
        return cars;
    }

    /**
     * This method moves the player (Frog) according the method's parameters. If the arrow keys are pressed it will
     * take the Frog to that direction for a number of steps determined by the second input
     * @param keyCode 37 for left / 38 for up / 39 for right / 40 for down
     * @param steps the number of steps that each method call moves the player
     */
    public void movePlayer(int keyCode, int steps){
        if (keyCode == 38){ //If the up arrow key is pushed
            player.move(0,-(steps));
        }
        else if (keyCode == 40){  //If the down arrow key is pushed
            player.move(0,steps);
        }
        else if (keyCode == 37){  //If the left arrow key is pushed
            player.move(-(steps),0);
        }
        else if (keyCode == 39){  //If the right arrow key is pushed
            player.move(steps,0);
        }
    }

    /**
     * This method receives an int parameter which determines the right edge of the game. If the cars have reached the
     * end of their path (x=0 for cars that move from right to left and x=edgeOfTheGame for cars that move from left
     * to right), it resets their location back to their initial position instead of calling their move methods.
     * @param edgeOfTheGame  determines the right edge of the game
     */
    public void moveCars(int edgeOfTheGame){
        for (int i = 0; i < cars.size(); i++){

            if (cars.get(i).isMoveLeft()){  //If the car's movement is from right to left
                //If the car has not yet reached the left edge (unless it has less than one move to reach it)
                if (cars.get(i).getCurrentPosition().getX() >= cars.get(i).getMovementSpeed()){
                    cars.get(i).move();
                }
                //If the car has reached the left edge (or it has less than one move to reach it)
                else if (cars.get(i).getCurrentPosition().getX() < cars.get(i).getMovementSpeed()){
                    //Reset the car's position
                    cars.get(i).getCurrentPosition().setLocation(edgeOfTheGame, cars.get(i).getCurrentPosition().getY());
                }
            }
            else{   //If the car's movement is from left to right
                //If the car has not yet reached the right edge (unless if it has less than one move to reach it)
                if (cars.get(i).getCurrentPosition().getX() <= (edgeOfTheGame-cars.get(i).getMovementSpeed())){
                    cars.get(i).move();
                }
                //If the car has reached the right edge (or it has less than one move to reach it)
                else if (cars.get(i).getCurrentPosition().getX() > (edgeOfTheGame-cars.get(i).getMovementSpeed())){
                    //Reset the car's position
                    cars.get(i).getCurrentPosition().setLocation(0, cars.get(i).getCurrentPosition().getY());
                }
            }
        }
    }

    /**
     * This method checks if the player (Frog object) is hit by a Car object or not, by checking if the player's
     * collision bound intersects any Car object's collision bound.
     * @return  true if the player was hit, false otherwise
     */
    public boolean isPlayerHit (){
        boolean isPlayerHit = false;

        for (int i = 0; i < cars.size(); i++){ //For all cars
            if (cars.get(i).getCollisionBounds().intersects(player.getCollisionBounds())){
                isPlayerHit = true;
            }
        }

        return isPlayerHit;
    }

    /**
     * This method determines if the player has won the game (Checks if the player's position's Y <= 20)
     * @return  true if the player has won the game, false otherwise
     */
    public boolean hasPlayerWon(){
        boolean playerHasWon = false;

        if (player.getCurrentPosition().getY() <= 20){
            playerHasWon = true;
        }

        return playerHasWon;
    }

}