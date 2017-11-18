package mgra.dao;

import java.util.List;

import mgra.model.Car;


public class TestConnection {
	public static void main(String[] args) {
		CarDAOImpl carDAOImpl=new CarDAOImpl();
		carDAOImpl.createCar(new Car(1L,"Joseé López","GSILBN", "HHH"));
		
		
			
			
			List<Car> cars=carDAOImpl.readAllCars();
			for(Car car:cars) {
				System.out.print(car);
	}
	

}
}

