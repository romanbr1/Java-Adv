package ua.lviv.lgs.servlet;

 import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.BucketService;
import ua.lviv.lgs.service.MagazineService;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.BucketServiceImpl;
import ua.lviv.lgs.service.impl.MagazineServiceImpl;
import ua.lviv.lgs.service.impl.UserServiceImpl;


 @WebServlet("/bucket")
public class BucketController extends HttpServlet {

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private	BucketService bucketService = BucketServiceImpl.getBucketService();
private	MagazineService magazineService = MagazineServiceImpl.getMagazineService();
private UserService userService = UserServiceImpl.getUserService();



 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String magazinetId = request.getParameter("id");

		Magazine magazine =magazineService.read(Integer.parseInt(magazinetId));
		
 		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("user_id");
		User user =userService.read(userId);
		
		
		
		String purchase="purchase";
// 		Bucket bucket = new Bucket(userId, Integer.parseInt(magazinetId),purchase , new Date());
		Bucket bucket=new Bucket();
		bucket.setId(UUID.randomUUID().toString());
		bucket.setMagazine(magazine);
		bucket.setUser(user);
		bucket.setPurchase_time(new Date());
		bucketService.create(bucket);
		
//		bucket.setMagazine_id();
		
		

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