public class Dean extends Research_personal {

    Dean(int soc_sec_num, String name, String email, String research_area, Faculty faculty) {
        super(soc_sec_num, name, email, research_area);
    }

    Dean(Research_personal employee) {
        super(employee.getSocial_security_number(), employee.getName(), employee.getEmail(),
                employee.getResearch_area());
    }


}