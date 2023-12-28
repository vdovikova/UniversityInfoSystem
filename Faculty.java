import java.util.ArrayList;
import java.util.Objects;

public class Faculty {

	private String name;
	private Dean dean;
	private ArrayList<Institute> institutes = new ArrayList<>();

	Faculty(String name, Dean dean, ArrayList<Institute> institutes){
		this.name = name;
		this.dean = dean;
		this.institutes = institutes;
	}

    public Faculty() {

    }

	public void setName(String name) {
		this.name = name;
	}

	public void setDean(Dean dean) {
		this.dean = dean;
	}

	public Dean getDean() {
		return dean;
	}

	public String getName() {
		return name;
	}

	public void setInstitutes(ArrayList<Institute> institutes) {
		this.institutes = institutes;
	}

	public ArrayList<Institute> getInstitutes() {
		return institutes;
	}

	public Institute getInstituteByName(String name) {
		int inst = 0;
		for (Institute i : institutes) {
			if (Objects.equals(name, i.getName())){
				inst = institutes.indexOf(i);
				break;
			}
		}
		return institutes.get(inst);
	}

	public void addInstitute(String name, String address) {
		boolean isUnique = true;
		for (Institute j : institutes){
			if (Objects.equals(name, j.getName())){
				isUnique = false;
				break;
			}
		}
		if (isUnique) {
			Institute institute = new Institute();
			institute.setAddress(address);
			institute.setName(name);
			ArrayList<Research_personal> rp = new ArrayList<>();
			ArrayList<Project> pr = new ArrayList<>();
			institute.setResearch_personal(rp);
			institute.setProjects(pr);
			institutes.add(institute);
			System.out.println("Institute " + name + " successfully added");
		} else {
			System.out.println("Institute " + name + " already exists");
		}

	}

	public void addInstitute(Institute institute) {
		boolean isUnique = true;
		for (Institute j : institutes){
			if (Objects.equals(institute.getName(), j.getName())){
				isUnique = false;
				break;
			}
		}
		if (isUnique) {
			institutes.add(institute);
			System.out.println("Institute " + name + " successfully added");
		} else {
			System.out.println("Institute " + name + " already exists");
		}

	}

	public void deleteInstitute(Institute institute) {
			institutes.remove(institute);
			System.out.println("Institute successfully deleted");
	}

	public void deleteInstituteByName(String name) {
		for (Institute j : institutes){
			if (Objects.equals(name, j.getName())){
				institutes.remove(j);
				System.out.println("Institute " + name + " successfully deleted");
				break;
			}
		}
	}

	@Override
	public String toString() {
		return "\t\tНазвание: " + name +
				"\n\t\tДекан: " + dean.name +
				"\n\t\tКафедры: " + institutes;
	}
}