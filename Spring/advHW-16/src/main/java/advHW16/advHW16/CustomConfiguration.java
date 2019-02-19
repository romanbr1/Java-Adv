package advHW16.advHW16;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ua.lviv.lgs.dao.impl.StudentDaoImpl;

@Configuration
public class CustomConfiguration {

	@Bean(name = "student")
	public Student getStudent() {
		Student student= new Student();
		student.setName("john");
		student.setAge(18);
		student.setId(1);
		return student;
	}

	@Bean(name = "consoleEventLogger")
	public ConsoleEventLogger getConsoleEventLogger() {
		return new ConsoleEventLogger();
	}

	@Bean(name = "studentDao")
	public StudentDaoImpl dao(){
		return new StudentDaoImpl();
	} 
}
