package ua.lviv.lgs;


import java.text.ParseException;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import ua.lviv.lgs.domain.Univercity;

import ua.lviv.lgs.service.UnivercityService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws ParseException {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		UnivercityService service = ctx.getBean(UnivercityService.class);

		Univercity univercity = new Univercity();
		univercity.setName("LP");
		univercity.setLevel(5);
		univercity.setNumberOfInstitutes(15);
		univercity.setNumberOfStudents(20000);
		univercity.setAdress("LVIV");
		
	

		// save user to DB
		service.save(univercity);

		// read from DB
		System.out.println(service.findById((long) 2));

		System.out.println(service.findByName("LNU"));
		
		System.out.println(service.findByLevel(4));
		
		System.out.println(service.findByAdress("NY"));
		
		
		// update from DB
//		Univercity forUpdate = service.findById((long) 1);
//		forUpdate.setName("Logos");
//		service.update(forUpdate);

		
//		 readAll
//		service.findAll().stream().forEach(System.out::println);
		
		
//		delete from db
//		service.deleteById((long)3);

	}
}
