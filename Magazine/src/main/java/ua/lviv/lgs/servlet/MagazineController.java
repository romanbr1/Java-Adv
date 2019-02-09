package ua.lviv.lgs.servlet;

 import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.service.MagazineService;
import ua.lviv.lgs.service.impl.MagazineServiceImpl;

 @WebServlet("/magazine")
public class MagazineController extends HttpServlet {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MagazineService magazineService = MagazineServiceImpl.getMagazineService();

 	// to create resource (product)
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String price = request.getParameter("price");

		Magazine magazine  = new Magazine(title, category, (float) getValidatedPrice(price));
		magazineService.create(magazine);
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

 	private double getValidatedPrice(String price) {
		if(price == null || price.isEmpty()) {
			return 0;
		}
		return Double.parseDouble(price);
	}

 	// to get resource (magazine)
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String magazineId = request.getParameter("id");

		Magazine magazine = magazineService.read(Integer.parseInt(magazineId));

 		request.setAttribute("magazine", magazine);
		request.getRequestDispatcher("singleProduct.jsp").forward(request, response);
	}

 	// to update resource (magazine)
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

 		super.doPut(req, resp);
	}

 	// to delete resource (product)
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

 		super.doDelete(req, resp);
	}

 }