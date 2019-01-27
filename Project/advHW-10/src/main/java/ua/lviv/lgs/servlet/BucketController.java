package ua.lviv.lgs.servlet;

 import java.io.IOException;
import java.util.Date;

 import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 import ua.lviv.lgs.domain.Bucket;

import ua.lviv.lgs.service.BucketService;
import ua.lviv.lgs.service.impl.BucketServiceImpl;


 @WebServlet("/bucket")
public class BucketController extends HttpServlet {

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private	BucketService bucketService = BucketServiceImpl.getBucketService();




 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String magazinetId = request.getParameter("id");
		System.out.println("id"+magazinetId);
 		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("user_id");
		String purchase="purchase";
 		Bucket bucket = new Bucket(userId, Integer.parseInt(magazinetId),purchase , new Date());
		System.out.println(bucket);
 		bucketService.create(bucket);


 		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}
 	
 	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bucketId = request.getParameter("id");
		bucketService.delete(Integer.parseInt(bucketId));

 		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

 }