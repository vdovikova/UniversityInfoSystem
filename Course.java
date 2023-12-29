public class Course {

	private int unique_number;
	private String  name;
	private int weekly_duration;

	Course(int unique_number, String name, int weekly_duration){
		this.name = name;
		this.unique_number = unique_number;
		this.weekly_duration = weekly_duration;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUnique_number(int unique_number) {
		this.unique_number = unique_number;
	}

	public void setWeekly_duration(int weekly_duration) {
		this.weekly_duration = weekly_duration;
	}

	public int getUnique_number() {
		return unique_number;
	}

	public int getWeekly_duration() {
		return weekly_duration;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Номер курса: " + unique_number +
				" Название курса: " + name +
				" Длительность: " + weekly_duration;
	}
}