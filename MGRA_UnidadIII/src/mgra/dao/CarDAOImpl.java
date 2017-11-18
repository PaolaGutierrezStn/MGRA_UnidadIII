package mgra.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import mgra.model.Car;


public class CarDAOImpl implements CarDAO {
	private Connection connection;
	private PreparedStatement prepareStatement;
	private ResultSet resultSet;
	
	public CarDAOImpl() {
		getConnection();
	}
	
	public  Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/car","pollo","1234");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
		
	}

public void createCar(Car car) {
	if(connection!=null) {
		try {
		prepareStatement=connection.prepareStatement("INSERT INTO car (brand, model,capacity)values(?,?,?);");
		prepareStatement.setString(1, car.getBrand());
		prepareStatement.setString(2, car.getModel());
		prepareStatement.setString(3, car.getCapacity());
		prepareStatement.execute();

		
		
		
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
		
	}
	
}

	public Car readCar(Long id) {
	Car car=null;
	 try {
		if(connection!=null) {
			
				prepareStatement=connection.prepareStatement("SELECT * FROM car where id=?;");
				prepareStatement.setLong(1, id);
				resultSet=prepareStatement.executeQuery();
				if(resultSet.next()) {
					car=new Car(resultSet.getLong(1),
							resultSet.getString(2),
							resultSet.getString(3),
							resultSet.getString(4));
					
				
				}
		}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		return car;
	}

	public void deleteCar(Long id) {
	if(connection!=null) {
		try {
		prepareStatement=connection.prepareStatement("DELETE FROM car where id=?;");
		
		prepareStatement.setLong(1,id);
		prepareStatement.execute();
	}catch(SQLException e) {
		e.printStackTrace();
	}
		
	}
		
		
	}

	public void updateCar(Car car) {
	if(connection!=null) {
		try {
		prepareStatement=connection.prepareStatement("UPDATE car SET brand =?, model=?,"+
				"capacity=? where id=?;");
		prepareStatement.setString(1, car.getBrand());
		prepareStatement.setString(2, car.getModel());
		prepareStatement.setString(3, car.getCapacity());
		prepareStatement.setLong(4, car.getId());
		prepareStatement.execute();
	}catch(SQLException e) {
		e.printStackTrace();
	}
		
	}
		
		
	}

	public List<Car> readAllCars() {
	List <Car> cars=new ArrayList<Car>();
if(connection!=null) {  //revisar si falla
		try {
			prepareStatement=connection.prepareStatement("SELECT * FROM car");
			
			resultSet=prepareStatement.executeQuery();
			while(resultSet.next()) {
				Car car=new Car(resultSet.getLong(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4));
				cars.add(car);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return cars;
	
	}



}
