import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class University {

	private ArrayList<Employee> employers;
	private int number_of_employers;
	private ArrayList<Faculty> faculties;

	University(ArrayList<Employee> employers, ArrayList<Faculty> faculties){
		this.employers = employers;
		this.number_of_employers = employers.size();
		this.faculties = faculties;
	}

	public void setEmployers(ArrayList<Employee> employers) {
		this.employers = employers;
	}

	public void setFaculties(ArrayList<Faculty> faculties) {
		this.faculties = faculties;
	}

	private void setNumber_of_employers() {
		this.number_of_employers = employers.size();
	}

	public ArrayList<Employee> getEmployers() {
		return employers;
	}

	public ArrayList<Faculty> getFaculties() {
		return faculties;
	}

	public int getNumber_of_employers() {
		return number_of_employers;
	}

	public void addEmployee(int social_security_number, String name, String email) {
		boolean isUnique = true;
		for (Employee e : employers){
			if (social_security_number == e.getSocial_security_number()){
				isUnique = false;
				break;
			}
		}
		if (isUnique) {
			Employee emp = new Employee(social_security_number, name, email);
			employers.add(emp);
		} else {
			System.out.println("Employee with social security number "+ social_security_number
					+ " already exists");
		}
	}

	public void addEmployee(int social_security_number, String name, String email,
							String research_area) {
		boolean isUnique = true;
		for (Employee e : employers){
			if (social_security_number == e.getSocial_security_number()){
				isUnique = false;
				break;
			}
		}
		if (isUnique) {
			Research_personal emp =
					new Research_personal(social_security_number, name, email, research_area);
			employers.add(emp);
		} else {
			System.out.println("Employee with social security number "+ social_security_number
					+ " already exists");
		}
	}

	public void addEmployee(int social_security_number, String name, String email,
							String research_area, ArrayList<Course> courses) {
		boolean isUnique = true;
		for (Employee e : employers){
			if (social_security_number == e.getSocial_security_number()){
				isUnique = false;
				break;
			}
		}
		if (isUnique) {
			Lecturer emp = new Lecturer(social_security_number, name, email, research_area, courses);
			employers.add(emp);
		} else {
			System.out.println("Employee with social security number "+ social_security_number
					+ " already exists");
		}
	}

	public void addEmployee(Employee employee) {
		boolean isUnique = true;
		for (Employee e : employers){
			if (employee.getSocial_security_number() == e.getSocial_security_number()){
				isUnique = false;
				break;
			}
		}
		if (isUnique) {
			employers.add(employee);
		} else {
			System.out.println("Employee with social security number "
					+ employee.getSocial_security_number() + " already exists");
		}
	}

	public void deleteEmployee(int social_security_number) {
		for (int i = 0; i<employers.size(); i++){
			if (employers.get(i).getSocial_security_number() == social_security_number){
				employers.remove(i);
				break;
			}
		}
	}

	public void addFaculty(String name, Dean dean) {
		boolean isUnique = true;
		for (Faculty j : faculties){
			if (Objects.equals(name, j.getName())){
				isUnique = false;
				break;
			}
		}
		if (isUnique) {
			Faculty faculty = new Faculty();
			faculty.setName(name);
			faculty.setDean(dean);
			ArrayList<Institute> institutes = new ArrayList<>();
			faculty.setInstitutes(institutes);
			faculties.add(faculty);
			System.out.println("Faculty " + name + " successfully added");
		} else {
			System.out.println("Faculty " + name + " already exists");
		}

	}

	public void addFaculty(Faculty faculty) {
		boolean isUnique = true;
		for (Faculty j : faculties){
			if (Objects.equals(faculty.getName(), j.getName())){
				isUnique = false;
				break;
			}
		}
		if (isUnique) {
			faculties.add(faculty);
			System.out.println("Faculty " + faculty.getName() + " successfully added");
		} else {
			System.out.println("Faculty " + faculty.getName() + " already exists");
		}
	}

	public void deleteFacultyByName(String name) {
		for (Faculty j : faculties){
			if (Objects.equals(name, j.getName())){
				faculties.remove(j);
				System.out.println("Faculty " + name + " successfully deleted");
				break;
			}
		}
	}

	public void deleteFaculty(Faculty faculty) {
		faculties.remove(faculty);
		System.out.println("Faculty successfully deleted");
	}

	public Faculty getFacultyByName(String name) {
		int f = 0;
		for (Faculty i : faculties) {
			if (Objects.equals(name, i.getName())){
				f = faculties.indexOf(i);
				break;
			}
		}
		return faculties.get(f);
	}

	@Override
	public String toString() {
		return "»Õ‘Œ–Ã¿÷»ŒÕÕ¿ﬂ —»—“≈Ã¿ ”Õ»¬≈–—»“≈“¿\n" +
				"\t —ÓÚÛ‰ÌËÍË: \n" + employers +
				"\n \t  ÓÎË˜ÂÒÚ‚Ó ÒÓÚÛ‰ÌËÍÓ‚: " + number_of_employers +
				"\n \t ‘‡ÍÛÎ¸ÚÂÚ˚: \n" + faculties;
	}
}