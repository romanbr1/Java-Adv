package ua.lviv.lgs;

public class Time {
	private int hour;
	private int min;

	public Time(int hour, int min) {
		this.min = min % 60;
		this.hour = hour % 24;
		if (min > 60) {
			this.hour = hour % 24 + min / 60;
			this.min = min % 60;
		}
	}

	public Time(int duration) {
		this.hour = duration / 60;
		this.min = duration % 60;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	@Override
	public String toString() {
		return hour + ":" + min;
	}

}
