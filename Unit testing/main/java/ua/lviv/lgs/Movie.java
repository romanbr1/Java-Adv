package ua.lviv.lgs;

public class Movie {
private String title;
private Time duration;

public Movie(String title, int duration) {
	
	this.title = title;
	this.duration = new Time(duration);
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public Time getDuration() {
	return duration;
}

public void setDuration(Time duration) {
	this.duration = duration;
}

public void setDuration(int duration) {
	this.duration=new Time(duration);
}

@Override
public String toString() {
	
	return "title=" + title + ", duration=" + duration;
	
}
public int compareTo(Movie o) {
	return this.title.compareTo(o.getTitle());
}

}
