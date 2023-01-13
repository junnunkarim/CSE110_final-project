import java.util.ArrayList;
import java.util.Scanner;
public class Admin {
    private String password;

    public Admin(String password) {
        this.password = password;
    }

    void addStudent(){
        String name,id, department, semesterEnrolled, password;
        Scanner input = new Scanner(System.in);

        System.out.print("Student Name: ");
        name = input.nextLine();
        System.out.print("ID (format- 2022-1-60-162): ");
        id = input.nextLine();
        System.out.print("Department: ");
        department = input.nextLine();
        System.out.print("SemesterEnrolled (format- Spring-2023: ");
        semesterEnrolled = input.nextLine();
        System.out.print("Password: ");
        password = input.nextLine();
        Student student = new Student(name,id,department,semesterEnrolled,password);
        Main.studentList.add(student);
    }



    //Getter & Setter
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
