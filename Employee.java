public class Employee {

	protected int social_security_number;
	protected String name;
	protected String email;

	Employee(int soc_sec_num, String name, String email){
		this.social_security_number = soc_sec_num;
		this.name = name;
		this.email = email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSocial_security_number(int social_security_number) {
		this.social_security_number = social_security_number;
	}

	public int getSocial_security_number() {
		return social_security_number;
	}

	public String getName(){
		return name;
	}

	public String getEmail(){
		return name;
	}

	@Override
	public String toString() {
		return "Employee{\n" +
				"social_security_number=" + social_security_number +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}