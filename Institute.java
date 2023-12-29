import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Institute {

	private String name;
	private String address;
	private ArrayList<Project> projects;
	private ArrayList<Research_personal> research_personal;
	private ArrayList<Course> courses;

	Institute(String name, String address, ArrayList<Project> projects,
			  ArrayList<Research_personal> research_personal, ArrayList<Course> courses){
		this.name = name;
		this.address = address;
		this.projects = projects;
		this.research_personal = research_personal;
		this.courses = courses;
	}

	Institute(String name, String address){
		this.name = name;
		this.address = address;
		this.projects = new ArrayList<Project>();
		this.research_personal = new ArrayList<Research_personal>();
		this.courses = new ArrayList<Course>();
	}

	public Institute() {

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setResearch_personal(ArrayList<Research_personal> research_personal) {
		this.research_personal = research_personal;
	}

	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public String getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Research_personal> getResearch_personal() {
		return research_personal;
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public void addProject(int hours, String name, Date starting_date, Date end_date, int[] soc_num) {
		boolean isUnique = true;
		for (Project j : projects){
			if (Objects.equals(name, j.getName())){
				isUnique = false;
				break;
			}
		}
		if (isUnique) {
			ArrayList <Research_personal> rp = new ArrayList<>();
			Project proj = new Project();
			proj.setHours(hours);
			proj.setName(name);
			proj.setStarting_date(starting_date);
			proj.setEnd_date(end_date);
			for (int i = 0; i < soc_num.length; i++){
				for (Research_personal j : research_personal){
					if (i == j.getSocial_security_number()){
						rp.add(j);
						break;
					}
				}
			}
			proj.setResearch_personal(rp);
			projects.add(proj);
			System.out.println("Project " + name + " successfully added");
		} else {
			System.out.println("Project with this name already exists");
		}
	}

	public void addProject (Project project){
		boolean isUnique = true;
		for (Project j : projects){
			if (Objects.equals(project.getName(), j.getName())){
				isUnique = false;
				break;
			}
		}
		if (isUnique) {
			projects.add(project);
			System.out.println("Project " + project.getName() + " successfully added");
		} else {
			System.out.println("Project with this name already exists");
		}
	}

	public void addCourse(int unique_number, String name, int weekly_duration) {
		boolean isUnique = true;
		for (Course j : courses){
			if (Objects.equals(name, j.getName())){
				isUnique = false;
				break;
			}
		}
		if (isUnique) {
			Course course = new Course(unique_number, name, weekly_duration);
			courses.add(course);
			System.out.println("Course " + name + " successfully added");
		} else {
			System.out.println("Course with this name already exists");
		}
	}

	public void deleteProjectByName(String name) {
		for (Project j : projects){
			if (Objects.equals(name, j.getName())){
				projects.remove(j);
				System.out.println("Project " + name + " successfully deleted");
				break;
			}
		}
	}

	public void deleteProject(Project project) {
			projects.remove(project);
			System.out.println("Project successfully deleted");
	}

	@Override
	public String toString() {
		return "\n\t\t\t Название: " + name +
				"\n\t\t\t Адрес: " + address +
				"\n\t\t\t Проекты: " + projects +
				"\n\t\t\t Курсы: " + courses +
				"\n\t\t\t Работники кафедры: \n\t\t\t\t" + research_personal;
	}
}