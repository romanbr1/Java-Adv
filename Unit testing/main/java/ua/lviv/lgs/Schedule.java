package ua.lviv.lgs;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;




public class Schedule {
	private Set<Seance> schedule; 
	public Schedule() {
		this.schedule = new TreeSet<>();
	}

	public Set<Seance> getSchedule() {
		return schedule;
	}

	public void setSchedule(Set<Seance> schedule) {
		this.schedule = schedule;
	}

	public void printSchedule() {
		for (Seance seance : schedule) {
			System.out.println(seance);
		}
	}

	public void addSeance(Seance seance) {
		
		schedule.add(seance);
	};

	public void removeSeance(String title) {

	 schedule.removeIf(o -> (o.getMovie().getTitle().equalsIgnoreCase(title)));
	}

	@Override
	public String toString() {
		return "Schedule" + schedule + "\n";
	};
	
}