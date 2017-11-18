package mgra.dao;

import java.util.List;

import mgra.model.Car;


public interface CarDAO {

Car readCar(Long id);
void deleteCar(Long id);
void updateCar(Car car);
List<Car> readAllCars();
	
}
