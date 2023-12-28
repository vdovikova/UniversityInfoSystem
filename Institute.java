import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Institute {

	private String name;
	private String address;
	private ArrayList<Project> projects;
	private ArrayList<Research_personal> research_personal;

	Institute(String name, String address, ArrayList<Project> projects,
			  ArrayList<Research_personal> research_personal){
		this.name = name;
		this.address = address;
		this.projects = projects;
		this.research_personal = research_personal;
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
		return "Institute{" +
				"name='" + name + '\'' +
				", address='" + address + '\'' +
				", projects=" + projects +
				", research_personal=" + research_personal +
				'}';
	}
}