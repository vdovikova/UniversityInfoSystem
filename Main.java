import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    public static void main(String[] args){

        Research_personal employee1 = new Research_personal(1, "���� �������� ������",
                "ivanov@ya.ru", "������������ �����");

        ArrayList<Employee> employers = new ArrayList<>();
        employers.add(employee1);
        ArrayList<Research_personal> researchers = new ArrayList<>();
        researchers.add(employee1);

        Course course1 = new Course(1, "���������� �����", 10);
        Course course2 = new Course(2, "������������ �����", 10);
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);

        Project project1 = new Project(120, "������������ ������",
                new Date(2024, 3, 12),  new Date(2025, 3, 12), researchers);
        ArrayList<Project> projects = new ArrayList<>();
        projects.add(project1);

        Institute institute1 = new Institute("������������ �����", "���������, 2",
                                            projects, researchers);
        ArrayList<Institute> institutes = new ArrayList<>();
        institutes.add(institute1);

        Dean dean = new Dean(employee1);

        Faculty faculty1 = new Faculty("�����", dean, institutes);
        ArrayList<Faculty> faculties = new ArrayList<>();
        faculties.add(faculty1);

        University university = new University(employers, faculties);

        Scanner scanner = new Scanner(System.in);
        String c = "";
        while (!c.equals("5")){
            System.out.println("������� �������: ");
            System.out.printf("1 - �������� ���������\t" +
                    "2 - �������� �������\t" + "3 - �������� ����������\n" + "4 - ���������� �� ������������\t" +
                    "5 - ��������� ���������\t");
            System.out.println();
            c = scanner.next();
            switch (c){
                case "1":
                    String n = scanner.next("��������: ");
                    String n0 = "";
                    ArrayList<Institute> il = new ArrayList<>();
                    while (!n0.equals("����")){
                        n0 = scanner.next("(������� ����, ���� ������ ��������� ���� ������) �������� �������: ");
                        Institute i = new Institute();
                        i.setName(n0);
                        n0 = scanner.next("����� �������: ");
                        i.setAddress(n0);
                        ArrayList<Project> p = new ArrayList<>();
                        i.setProjects(p);
                        ArrayList<Research_personal> rp = new ArrayList<>();
                        i.setResearch_personal(rp);
                        il.add(i);
                    }
                    String n1 = scanner.next("���������� ��� ������: ");
                    for (Employee e : employers){
                        if (String.valueOf(e.getSocial_security_number()).equals(n1)){
                            Dean nd = new Dean((Research_personal) e);
                            Faculty nf = new Faculty(n, nd, il);
                            break;
                        }
                    }
                case "2":
                    String q = scanner.next("�������� ����������: ");
                    boolean isFacultyExist = false;
                    for (Faculty f : faculties){
                        if (Objects.equals(f.getName(), q)){
                            isFacultyExist = true;
                            break;
                        }
                    }
                    if (isFacultyExist){
                        n0 = scanner.next("�������� �������: ");
                        Institute i = new Institute();
                        i.setName(n0);
                        n0 = scanner.next("����� �������: ");
                        i.setAddress(n0);
                        ArrayList<Project> p = new ArrayList<>();
                        i.setProjects(p);
                        ArrayList<Research_personal> rp = new ArrayList<>();
                        i.setResearch_personal(rp);
                        university.getFacultyByName(q).addInstitute(i);
                    } else {
                        System.out.println("������ ���������� �� ����������");
                    }
                case "3":
                    Employee emp = new Employee();
                    System.out.println("���������� ���: ");
                    emp.setSocial_security_number(scanner.nextInt());
                    System.out.println("���: ");
                    emp.setName(scanner.next());
                    System.out.println("�����: ");
                    emp.setEmail(scanner.next());
                    employers.add(emp);
                case "4":
                    System.out.println(university);
            }
        }
    }
}
