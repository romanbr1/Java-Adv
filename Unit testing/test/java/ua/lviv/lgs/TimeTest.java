package ua.lviv.lgs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class TimeTest {
	private Time time;

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
		time = new Time(0, 0);
	}

	@After
	public void afterTest() {
		time = null;
	}

	@Test
	public void setTimeTest() {

		Time t1=new Time(145);
		
		Time t2=new Time(2,25);
		
		Assert.assertEquals(t2.toString(), t1.toString());

	}
}