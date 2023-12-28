import java.util.ArrayList;

public class Lecturer extends Research_personal {
    private ArrayList<Course> courseList;

    Lecturer(int soc_sec_num, String name, String email, String research_area,
             ArrayList<Course> courseList) {
        super(soc_sec_num, name, email, research_area);
        this.courseList = courseList;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "social_security_number=" + social_security_number +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", courseList=" + courseList +
                '}';
    }
}