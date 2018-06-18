package backend;

import simulation.AnimationParts;
import simulation.Board;
import simulation.Graph;
import simulation.carAnimation;
import sun.awt.geom.AreaOp;

import java.util.ArrayList;

public class CollisionDetection {

    public ArrayList<Car> cars;

    public CollisionDetection() {
        this.cars = new ArrayList<>();

    }

    public void addCar(Car car) {
        this.cars.add(car);
    }



    //TODO orientation of the rectangular bounding box. at the moment its just a square.
    public boolean collisionDetection(int dir) {

        if (cars.size() == 1) {
            return false;
        }

        for (int i = 0; i < cars.size(); i++) {

            for (int j = 0; j < cars.size(); j++) {

                if((dir == 6 || dir == 4) && cars.get(i).getLocX() <= cars.get(j).getLocX() + 25 &&
                        cars.get(i).getLocX() + 25 >= cars.get(j).getLocX() &&
                        cars.get(i).getLocY() <= cars.get(j).getLocY() + 10 &&
                        cars.get(i).getLocY() + 10 >= cars.get(j).getLocY() &&
                        cars.get(i) != cars.get(j)){
                    return true;
                }

                if((dir == 2 || dir == 8) && cars.get(i).getLocX() <= cars.get(j).getLocX() + 10 &&
                        cars.get(i).getLocX() + 10 >= cars.get(j).getLocX() &&
                        cars.get(i).getLocY() <= cars.get(j).getLocY() + 25 &&
                        cars.get(i).getLocY() + 25 >= cars.get(j).getLocY() &&
                        cars.get(i) != cars.get(j)){
                    return true;
                }


            }

        }

        return false;

    }

    public boolean frontCarCollisionDetection(Car car) {

        if (cars.size() == 1) {
            return false;
        }

        for (int i = 0; i < cars.size(); i++) {

            if(     cars.get(i) != car && returnCarInFront(car) == null && car.getLocRoad().getDirection() == 6 &&
                    car.getLocX() + 90 >= cars.get(i).getLocX() && car.getLocX() + 25 <= cars.get(i).getLocX() &&
                    car.getLocY() + 15 >= cars.get(i).getLocY() && car.getLocY() - 15 <= cars.get(i).getLocY() ) {
                return true;

            }
            else if(cars.get(i) != car && returnCarInFront(car) == null && car.getLocRoad().getDirection() == 4 &&
                    car.getLocX() - 90 <= cars.get(i).getLocX() && car.getLocX() - 25 >= cars.get(i).getLocX() &&
                    car.getLocY() + 15 >= cars.get(i).getLocY() && car.getLocY() - 15 <= cars.get(i).getLocY() ) {
                return true;
            }
            else if(cars.get(i) != car && returnCarInFront(car) == null && car.getLocRoad().getDirection() == 8 &&
                    car.getLocY() - 90 <= cars.get(i).getLocY() && car.getLocY() - 25 >= cars.get(i).getLocY() &&
                    car.getLocX() + 15 >= cars.get(i).getLocX() && car.getLocX() - 15 <= cars.get(i).getLocX() ) {
                return true;
            }
            else if(cars.get(i) != car && returnCarInFront(car) == null && car.getLocRoad().getDirection() == 2 &&
                    car.getLocY() + 90 >= cars.get(i).getLocY() && car.getLocY() + 25 <= cars.get(i).getLocY() &&
                    car.getLocX() + 15 >= cars.get(i).getLocX() && car.getLocX() - 15 <= cars.get(i).getLocX() ) {
                return true;
            }

        }

        return false;
    }


    //return the velocity of the car that is in front of the current car (return that car object)
    //if there is a car on current road && the percentageOnRoad is larger than the current one => return the car in the front, get its velocity.

    public Car returnCarInFront(Car currentCar) {

        int returnIndex = 10000000;
        double distanceDiff = 1000000000;

        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i) != currentCar) {
                if (currentCar.getLocEdge().start == cars.get(i).getLocEdge().start && currentCar.getLocEdge().end == cars.get(i).getLocEdge().end
                        && currentCar.getPercentageOnCurrentRoad() < cars.get(i).getPercentageOnCurrentRoad()) {

                    double tempDistDiff = cars.get(i).getPercentageOnCurrentRoad() - currentCar.getPercentageOnCurrentRoad();

                    if (distanceDiff > tempDistDiff) {
                        distanceDiff = tempDistDiff;
                        returnIndex = i;
                    }

                }

            }
        }

        if (returnIndex == 10000000) {
            return null;
        } else {

            return cars.get(returnIndex);
        }

    }


}
