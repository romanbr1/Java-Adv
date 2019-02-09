package ua.lviv.lgs.servlet;

 import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.dto.BucketDto;
import ua.lviv.lgs.service.BucketService;
import ua.lviv.lgs.service.MagazineService;
import ua.lviv.lgs.service.impl.BucketServiceImpl;
import ua.lviv.lgs.service.impl.MagazineServiceImpl;


 @WebServlet("/buckets")
public class BucketsController extends HttpServlet {

 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private	BucketService bucketService = BucketServiceImpl.getBucketService();
	private MagazineService magazineService = MagazineServiceImpl.getMagazineService();


 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Bucket> buckets = bucketService.readAll();
		Map<Integer, Magazine> idToMagazine = magazineService.readAllMap();
		List<BucketDto> listOfBucketDtos = map(buckets, idToMagazine);

 		String json = new Gson().toJson(listOfBucketDtos);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}


 	public List<BucketDto> map(List<Bucket> buckets, Map<Integer, Magazine> idToMagazine){

 		return	buckets.stream().map(bucket->{
			BucketDto bucketDto = new BucketDto();
			bucketDto.id=bucket.getId();
			bucketDto.Purchase_time = bucket.getPurchase_time();

			Magazine magazine = idToMagazine.get(bucket.getMagazine().getId());
		    bucketDto.title = magazine.getTitle();
		    bucketDto.category = magazine.getCategory();
		    bucketDto.price = magazine.getPrice();

 			return bucketDto;
		}).collect(Collectors.toList());

 	} 
}