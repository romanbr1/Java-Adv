package ua.lviv.lgs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class CinemaTest {
	private Cinema cinema;
	private Schedule sched;
	private Movie movie;

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("failed-->" + description.getMethodName());
		};

		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("sacced-->" + description.getMethodName());
		};
	};

	@Before
	public void beforeTest() {
		sched = new Schedule();
		movie = new Movie("", 0);
	}

	@After
	public void afterTest() {
		sched = null;
		movie=null;
	}

	@Test
	public void addSeanceTest() {
		sched.addSeance(new Seance(new Movie("Comedy", 95), new Time(16, 45)));
	}
	
	
	@Test
	public void removeSeanceTest() {
		sched.removeSeance("Comedy");
	}
	
	@Test
	public void SeanceTest() {
		sched.addSeance(new Seance(new Movie("Comedy", 95), new Time(16, 45)));
		
		int endHour=sched.getSchedule().iterator().next().endTime.getHour();
		int exceptedEndHour=18;
		Assert.assertEquals(exceptedEndHour, endHour);
		
	}
	
	@Test
	public void MovieTittleTest() {

		movie.setTitle("Comedy");
		movie.setDuration(100);

		String s=movie.toString();
		
		String exceptedString = "title=Comedy, duration=1:40";
		Assert.assertEquals(exceptedString, s);
	}

}
