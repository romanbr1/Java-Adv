package advHW16.advHW16;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.lviv.lgs.dao.impl.StudentDaoImpl;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		Student student = (Student) ctx.getBean("student");
		
		ConsoleEventLogger cel = (ConsoleEventLogger) ctx.getBean("consoleEventLogger");
		cel.logEvent(student.getId() + "  " + student.getAge() + "  " + student.getName());
	
		
		
		
		
		StudentDaoImpl sdao=(StudentDaoImpl) ctx.getBean("studentDao");
		sdao.create("Ivan", 27);
		sdao.create("Ivan", 27);
		sdao.create("Ivan", 27);
		sdao.readAll();
		
		sdao.update(2, "Vasil", 33);
		sdao.read(2);
		sdao.delete(3);
		
		sdao.readAll();
	
	}

}
