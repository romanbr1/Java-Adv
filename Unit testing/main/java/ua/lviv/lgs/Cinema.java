package ua.lviv.lgs;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Supplier;


public class Cinema {
	TreeMap<Days, Schedule> cinemaMap = new TreeMap<>();
	Time open;
	Time close;

	Schedule name = new Schedule();
	Days[] days = Days.values();
	
	Supplier<Movie> addMovie = () -> {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter title of movie: ");
		String title = sc.nextLine();
		System.out.println("movie duration: ");
		int duration = sc.nextInt();
		return new Movie(title, duration);
	};

		Supplier<Time> addTime = () -> {
		Scanner sc = new Scanner(System.in);
		System.out.println("startTime hour: ");
		int sh = sc.nextInt();
		System.out.println("startTime min: ");
		int sm = sc.nextInt();
		return new Time(sh, sm);
	};

	public void addData() {
		open = new Time(9, 0);
		close = new Time(22, 0);
		Movie first = new Movie("First", 150);
//		Movie second = new Movie("Second", 110);
//		Movie third = new Movie("Third", 125);
		Time t1 = new Time(10, 30);
//		Time t2 = new Time(15, 15);
//		Time t3 = new Time(19, 45);
		Seance s1 = new Seance(first, t1);
//		Seance s2 = new Seance(second, t2);
//		Seance s3 = new Seance(third, t3);
		Schedule sch = new Schedule();
		sch.addSeance(s1);
//		sch.addSeance(s2);
//		sch.addSeance(s3);
		cinemaMap.put(Days.MONDAY, sch);
//		for (Days days2 : days) {
//			cinemaMap.put(days2, sch);
//		}
	}

	public void printSchedule() {
		System.out.println(cinemaMap);
	}

	public void addMovie(Time... time) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter day of week 1..7: ");
		int day = sc.nextInt()-1;
		Movie movie = addMovie.get();
		Schedule sch = new Schedule();

		for (Time t : time) {
			Seance s = new Seance(movie, t);
			sch.addSeance(s);
			cinemaMap.put(days[day], sch);
		}

	};

	public void addSeance() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter day of week 1..7: ");
		int day = sc.nextInt()-1;
		Movie movie = addMovie.get();
		Time time = addTime.get();
		Seance s = new Seance(movie, time);

		if (s.getEndTime().getHour() > close.getHour()) {
			System.out.println("cinema will close at" + close.toString() + "pm");
		} else if (s.getStartTime().getHour() < open.getHour()) {
			System.out.println("cinema close to " + open.getHour() + "am");
		} else {
			Schedule sch = new Schedule();
			sch.addSeance(s);
			cinemaMap.put(days[day], sch);
		}
	}

	public void removeMovie() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter title of movie: ");
		String title = sc.nextLine();
		
		for (Days d : days) {
			cinemaMap.get(d).getSchedule().removeIf(o -> o.movie.getTitle().equalsIgnoreCase(title));
		}

	}


	public void removeSeance() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter day of week 1..7: ");
		int day = sc.nextInt();
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter title of movie: ");
		String title = sc2.nextLine();
		cinemaMap.get(days[day]).getSchedule().removeIf(o -> o.movie.getTitle().equalsIgnoreCase(title));
	};

}
