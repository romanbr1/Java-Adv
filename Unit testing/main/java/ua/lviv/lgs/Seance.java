package ua.lviv.lgs;

public class Seance implements Comparable<Seance> {
Movie movie;
private Integer id;
Time startTime;
Time endTime;
private static int count = 0;
public Seance(Movie movie, Time startTime) {
	this.movie = movie;
	this.startTime = startTime;
	this.endTime=new Time(startTime.getHour()+movie.getDuration().getHour(), startTime.getMin()+movie.getDuration().getMin());
	id = count++;
}
public Movie getMovie() {
	return movie;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public void setMovie(Movie movie) {
	this.movie = movie;
}
public Time getStartTime() {
	return startTime;
}
public void setStartTime(Time startTime) {
	this.startTime = startTime;
}
public Time getEndTime() {
	return endTime;
}
@Override
public String toString() {
	return "\n\t\t " + movie + ", startTime=" + startTime + ", endTime=" + endTime + "";
}
@Override
public int compareTo(Seance o) {
	return id.compareTo(o.getId());
}


}
