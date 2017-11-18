
package mgra.controller;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mgra.dao.CarDAOImpl;
import mgra.model.Car;
/**
 * Servlet implementation class StudentController
 */
@WebServlet("/CarController")
public class CarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Car car;
	private List<Car> cars;
	private CarDAOImpl carDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarController() {
        super();
       car =new Car();
        cars= new ArrayList<Car>();
        carDAO=new CarDAOImpl();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
if (request.getParameter("btn_save")!= null) {
			
			car.setBrand(request.getParameter("brand"));
			car.setModel(request.getParameter("model"));
			car.setCapacity(request.getParameter("capacity"));
			
			
            
			if(car.getId()==0L) {
				carDAO.createCar(car);
			}else {
				carDAO.updateCar(car);
			}
			cars=carDAO.readAllCars();


			
			request.setAttribute("cars", cars);
			request.getRequestDispatcher("cars_list.jsp").forward(request, response);
			
		}else if (request.getParameter("btn_new")!=null) {
			car = new Car();
			request.getRequestDispatcher("cars_form.jsp").forward(request, response);
		
		}else if(request.getParameter("btn_edit")!=null) {	
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				car = carDAO.readCar(id);
				
			}catch (Exception e) {
				
				car = new Car();
			}
			request.setAttribute("car", car );
			
			request.getRequestDispatcher("cars_form.jsp").forward(request, response);
			
		}else if(request.getParameter("btn_delete")!=null) {
		
			
			try {
			Long id = Long.parseLong(request.getParameter("id"));
			carDAO.deleteCar(id);
			cars= carDAO.readAllCars();
			
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
			request.setAttribute("cars", cars);
			request.getRequestDispatcher("cars_list.jsp").forward(request, response);
		}else {
			cars = carDAO.readAllCars();
			request.setAttribute("cars", cars);
			request.getRequestDispatcher("foros_list.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
