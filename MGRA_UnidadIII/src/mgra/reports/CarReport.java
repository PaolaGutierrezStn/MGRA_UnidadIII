package mgra.reports;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Servlet implementation class MasterReport
 */
@WebServlet("/CarReport")
public class CarReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path="C:\\Users\\Juan Bosco Carrillo\\JaspersoftWorkspace\\MyReports\\CarReport.jrxml";
		try {
			JasperReport report=JasperCompileManager.compileReport(path);
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("image_car", this.getServletContext().getRealPath("/")+"images/image_car.JPG");
			data.put("image_car2", this.getServletContext().getRealPath("/")+"images/image_car2.jpg");
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/car","pollo", "1234");
			JasperPrint print =JasperFillManager.fillReport(report, data, connection);
			
			JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}catch (JRException e) {
			e.printStackTrace();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
