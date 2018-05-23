package backend;

import java.util.ArrayList;

public class CollisionDetection {

    private ArrayList<Car> cars;

    public CollisionDetection() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    //TODO orientation of the rectangular bounding box. at the moment its just a square.
    public boolean collisionDetection() {

        if (cars.size() == 1) {
            return false;
        }

        for (int i = 0; i < cars.size(); i++) {

            for (int j = 0; j < cars.size(); j++) {

                 if(cars.get(i).getLocX() <= cars.get(j).getLocX() + 25 &&
                    cars.get(i).getLocX() + 25 >= cars.get(j).getLocX() &&
                    cars.get(i).getLocY() <= cars.get(j).getLocY() + 25 &&
                    cars.get(i).getLocY() + 25 >= cars.get(j).getLocY() &&
                         cars.get(i) != cars.get(j)){
                    return true;
                 }
            }

        }

        return false;

    }

    public Car returnCarInFront(Car currentCar){

        for (int i = 0; i < cars.size(); i++) {
            if(cars.get(i) != currentCar){
                if(currentCar.getLocEdge().start == cars.get(i).getLocEdge().start && currentCar.getLocEdge().end == cars.get(i).getLocEdge().end
                        && currentCar.getPercentageOnCurrentRoad() < cars.get(i).getPercentageOnCurrentRoad()){
                    return cars.get(i);
                }

            }
        }

        return null;
    }

}
