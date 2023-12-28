import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class Project {

	private int hours;
	private String name;
	private Date starting_date;
	private Date end_date;
	private ArrayList<Research_personal> research_personal = new ArrayList<>();

	Project(int hours, String name, Date starting_date, Date end_date,
			ArrayList<Research_personal> research_personal){
		this.hours = hours;
		this.name = name;
		this.starting_date = starting_date;
		this.end_date = end_date;
		this.research_personal = research_personal;
	}

	public Project() {

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public void setStarting_date(Date starting_date) {
		this.starting_date = starting_date;
	}

	public void setResearch_personal(ArrayList<Research_personal> research_personal) {
		this.research_personal = research_personal;
	}

	public String getName() {
		return name;
	}

	public int getHours() {
		return hours;
	}

	public Date getStarting_date() {
		return starting_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public ArrayList<Research_personal> getResearch_personal() {
		return research_personal;
	}

	@Override
	public String toString() {
		return "Project{" + "name=" + name +
				", hours=" + hours +
				", starting_date=" + starting_date +
				", end_date=" + end_date +
				", research_personal=" + research_personal +
				'}';
	}
}