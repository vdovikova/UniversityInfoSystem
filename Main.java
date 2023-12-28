import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    public static void main(String[] args){

        Research_personal employee1 = new Research_personal(1, "Иван Иванович Иванов",
                "ivanov@ya.ru", "Органическая химия");

        ArrayList<Employee> employers = new ArrayList<>();
        employers.add(employee1);
        ArrayList<Research_personal> researchers = new ArrayList<>();
        researchers.add(employee1);

        Course course1 = new Course(1, "Коллоидная химия", 10);
        Course course2 = new Course(2, "Органическая химия", 10);
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);

        Project project1 = new Project(120, "Исследование белков",
                new Date(2024, 3, 12),  new Date(2025, 3, 12), researchers);
        ArrayList<Project> projects = new ArrayList<>();
        projects.add(project1);

        Institute institute1 = new Institute("Органической химии", "Береговая, 2",
                                            projects, researchers);
        ArrayList<Institute> institutes = new ArrayList<>();
        institutes.add(institute1);

        Dean dean = new Dean(employee1);

        Faculty faculty1 = new Faculty("Химии", dean, institutes);
        ArrayList<Faculty> faculties = new ArrayList<>();
        faculties.add(faculty1);

        University university = new University(employers, faculties);

        Scanner scanner = new Scanner(System.in);
        System.out.println(university);

//        System.out.println("Enter command: ");
//        System.out.printf("%-10s %-20s %-30s", "1 - Add university\t",
//                "2 - All universities\t", "3 - Info about university\n");
//        System.out.println();
//        String c = scanner.next();
//        switch (c){
//            case "1":
//
//        }
    }
}
