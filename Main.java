
import java.util.*;

public class Main {

    public static void main(String[] args){

        ArrayList<Employee> employers = new ArrayList<>();
        ArrayList<Faculty> faculties = new ArrayList<>();
        University university = new University(employers, faculties);
        ArrayList<Research_personal> researchers = new ArrayList<>();

        Research_personal employee1 = new Research_personal(1, "���� �������� ������",
                "ivanov@ya.ru", "������������ �����");
        university.addEmployee(employee1);
        researchers.add(employee1);
        Dean dean = new Dean(employee1);

        university.addFaculty("�����", dean);
        university.getFacultyByName("�����").addInstitute("������������ �����", "���������, 2");
        university.getFacultyByName("�����").getInstituteByName("������������ �����").setResearch_personal(researchers);
        university.getFacultyByName("�����").getInstituteByName("������������ �����").addProject(120, "������������ ������",
                new Date(2024, 3, 12),  new Date(2025, 3, 12), new int[]{1});
        university.getFacultyByName("�����").getInstituteByName("������������ �����").addCourse(1,
                "���������� �����", 10);
        university.getFacultyByName("�����").getInstituteByName("������������ �����").addCourse(2,
                "������������ �����", 10);

        Scanner scanner = new Scanner(System.in);
        String c = "";
        while (!c.equals("5")){
            System.out.println("������� �������: ");
            System.out.println("1 - �������� ���������\t" +
                    "2 - �������� �������\t" + "3 - �������� ����������\n" + "4 - ���������� �� ������������\t" +
                    "5 - ��������� ���������\t");
            c = scanner.next();
            switch (c){
//                �������� ���������
                case "1":
                    System.out.println("�������� ����������: ");
                    String facName = scanner.next();

                    System.out.println("���������� ��� ������: ");
                    String deanSocNum = scanner.next();
                    for (Employee e : employers){
                        if (String.valueOf(e.getSocial_security_number()).equals(deanSocNum)){
                            Dean newDean = new Dean((Research_personal) e);
                            university.addFaculty(facName, newDean);
                            break;
                        } else {
                            System.out.println("��� ������ ����������");
                        }
                    }
                    break;
                // �������� �������
                case "2":
                    System.out.println("�������� �������: ");
                    String fName = scanner.next();
                    boolean isFacultyExist = false;
                    int facIndex = 0;
                    for (Faculty f : university.getFaculties()){
                        if (Objects.equals(f.getName(), fName)){
                            isFacultyExist = true;
                            facIndex = university.getFaculties().indexOf(f);
                            break;
                        }
                    }
                    if (isFacultyExist){
                        String instName = "";
                        while (!instName.equals("����")){
                            System.out.println("(������� '����', ���� ������ ��������� ���� ������) �������� �������: ");
                            instName = scanner.next();
                            System.out.println("����� �������: ");
                            String instAddress = scanner.next();
                            university.getFaculties().get(facIndex).addInstitute(instName, instAddress);
                        }
                    } else {
                        System.out.println("������ ���������� �� ����������");
                        break;
                    }
                    break;
                // �������� ����������
                case "3":
                    System.out.println("���������� ���: ");
                    int socNum = scanner.nextInt();
                    System.out.println("���: ");
                    String fname = scanner.next();
                    String secname = scanner.next();
                    String surname = scanner.next();
                    String name = fname + " " + secname + " " + surname;
                    System.out.println("�����: ");
                    String email = scanner.next();
                    university.addEmployee(socNum, name, email);
                    break;
                // ���� �� ������������
                case "4":
                    System.out.println(university);
            }
        }
    }
}
