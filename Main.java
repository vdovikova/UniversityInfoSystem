
import java.util.*;

public class Main {

    public static void main(String[] args){

        ArrayList<Employee> employers = new ArrayList<>();
        ArrayList<Faculty> faculties = new ArrayList<>();
        University university = new University(employers, faculties);
        ArrayList<Research_personal> researchers = new ArrayList<>();

        Research_personal employee1 = new Research_personal(1, "Иван Иванович Иванов",
                "ivanov@ya.ru", "Органическая химия");
        university.addEmployee(employee1);
        researchers.add(employee1);
        Dean dean = new Dean(employee1);

        university.addFaculty("Химии", dean);
        university.getFacultyByName("Химии").addInstitute("Органической химии", "Береговая, 2");
        university.getFacultyByName("Химии").getInstituteByName("Органической химии").setResearch_personal(researchers);
        university.getFacultyByName("Химии").getInstituteByName("Органической химии").addProject(120, "Исследование белков",
                new Date(2024, 3, 12),  new Date(2025, 3, 12), new int[]{1});
        university.getFacultyByName("Химии").getInstituteByName("Органической химии").addCourse(1,
                "Коллоидная химия", 10);
        university.getFacultyByName("Химии").getInstituteByName("Органической химии").addCourse(2,
                "Органическая химия", 10);

        Scanner scanner = new Scanner(System.in);
        String c = "";
        while (!c.equals("5")){
            System.out.println("Введите команду: ");
            System.out.println("1 - Добавить факультет\t" +
                    "2 - Добавить кафедры\t" + "3 - Добавить сотрудника\n" + "4 - Информация об университете\t" +
                    "5 - Завершить программу\t");
            c = scanner.next();
            switch (c){
//                Добавить факультет
                case "1":
                    System.out.println("Название факультета: ");
                    String facName = scanner.next();

                    System.out.println("Социальный код декана: ");
                    String deanSocNum = scanner.next();
                    for (Employee e : employers){
                        if (String.valueOf(e.getSocial_security_number()).equals(deanSocNum)){
                            Dean newDean = new Dean((Research_personal) e);
                            university.addFaculty(facName, newDean);
                            break;
                        } else {
                            System.out.println("Нет такого сотрудника");
                        }
                    }
                    break;
                // Добавить кафедру
                case "2":
                    System.out.println("Название кафедры: ");
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
                        while (!instName.equals("стоп")){
                            System.out.println("(Введите 'стоп', если хотите закончить ввод кафедр) Название кафедры: ");
                            instName = scanner.next();
                            System.out.println("Адрес кафедры: ");
                            String instAddress = scanner.next();
                            university.getFaculties().get(facIndex).addInstitute(instName, instAddress);
                        }
                    } else {
                        System.out.println("Такого факультета не существует");
                        break;
                    }
                    break;
                // Добавить сотрудника
                case "3":
                    System.out.println("Социальный код: ");
                    int socNum = scanner.nextInt();
                    System.out.println("Имя: ");
                    String fname = scanner.next();
                    String secname = scanner.next();
                    String surname = scanner.next();
                    String name = fname + " " + secname + " " + surname;
                    System.out.println("Почта: ");
                    String email = scanner.next();
                    university.addEmployee(socNum, name, email);
                    break;
                // инфо об университете
                case "4":
                    System.out.println(university);
            }
        }
    }
}
