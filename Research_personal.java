public class Research_personal extends Employee {

	private String research_area;

	Research_personal(int soc_sec_num, String name, String email, String research_area) {
		super(soc_sec_num, name, email);
		this.research_area = research_area;
	}

	public void setResearch_area(String research_area) {
		this.research_area = research_area;
	}

	public String getResearch_area() {
		return research_area;
	}

	@Override
	public String toString() {
		return  "Социальный код: \t" + social_security_number +
				",\t Имя: \t" + name +
				",\t E- mail: \t" + email +
				",\t Область исследований: \t" + research_area;
	}
}