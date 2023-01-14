import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Admin {
    private String password;
    Scanner input = new Scanner(System.in);
    private CourseManager courseManager = new CourseManager();
    //private CourseEnrollment courseEnrollment = new CourseEnrollment();

    public Admin(String password) {
        this.password = password;
    }

    public void addCourse() {

        List<String> departmentList = new ArrayList<>();
        String courseCode;
        String prerequisite;
        double credit;

        System.out.println("Input the Course information to add the Course");
        System.out.println("Input the Departmentlist: ");
        while(true){
            System.out.print("Enter the Department: ");
            String department =  input.nextLine();
            if(department.equalsIgnoreCase("Q")) break;
            departmentList.add(department);
        }
        System.out.print("Input the CourseCode: ");
        courseCode =  input.nextLine();
        System.out.print("Input the Prerequisite(If none then write 'null'): ");
        prerequisite =  input.nextLine();
        System.out.print("Input the credit: ");
        credit =  Double.parseDouble(input.nextLine());

        courseManager.addCourse(departmentList,courseCode,prerequisite,credit);
    }

    public void removeCourse() {
        String courseCode;
        System.out.print("Input the CourseCode: ");
        courseCode = input.nextLine();
        courseManager.removeCourse(courseCode);
    }

    public void updateCourse() {
        String courseCode;
        List<String> departmentList = new ArrayList<>();
        String prerequisite;
        double credit;

        System.out.println("Input the Course information to Update");

        System.out.print("Input the CourseCode: ");
        courseCode =  input.nextLine();
        System.out.println("Input the Departmentlist: ");
        while(true){
            System.out.print("Enter the Department: ");
            String department =  input.nextLine();
            if(department.equalsIgnoreCase("Q")) break;
            departmentList.add(department);
        }

        System.out.print("Input the Prerequisite: ");
        prerequisite =  input.nextLine();
        System.out.print("Input the credit: ");
        credit =  Double.parseDouble(input.nextLine());

        courseManager.updateCourse(courseCode,departmentList,prerequisite,credit);
    }


    public void addStudent() {

        String name;
        String studentID;
        String department;
        String semesterEnrolled;
        String password;

        System.out.println("Input the Student information to Add");
        System.out.print("Input the Name: ");
        name =  input.nextLine();
        System.out.print("Input the Student ID: ");
        studentID =  input.nextLine();
        System.out.print("Input the department: ");
        department =  input.nextLine();
        System.out.print("Input the number of Semester Enrolled: ");
        semesterEnrolled =  input.nextLine();
        System.out.print("Input the Password: ");
        password =  input.nextLine();

       courseManager.addStudent(name, studentID, department, semesterEnrolled, password);
   }

    public void removeStudent() {
        String studentID;

        System.out.println("Input the Student information to Remove");
        System.out.print("Input the Student ID: ");
        studentID =  input.nextLine();

        courseManager.removeStudent(studentID);
    }

    public void updateStudent() {

        String studentID;
        String name;
        String department;
        String semesterEnrolled;
        String password;

        System.out.println("Input the Student information to Add");
        System.out.print("Input the Student ID: ");
        studentID =  input.nextLine();
        System.out.print("Input the Name: ");
        name =  input.nextLine();
        System.out.print("Input the department: ");
        department =  input.nextLine();
        System.out.print("Input the number of Semester Enrolled: ");
        semesterEnrolled =  input.nextLine();
        System.out.print("Input the Password: ");
        password =  input.nextLine();

        courseManager.updateStudent(studentID,name,department,semesterEnrolled,password);
    }


    public void addFaculty() {
        String name;
        String department;

        System.out.println("Input the Faculty information to Add");
        System.out.print("Input the CourseCode: ");
        name =  input.nextLine();
        System.out.print("Input the Department: ");
        department =  input.nextLine();

        courseManager.addFaculty(name, department);
    }

    public void removeFaculty() {
        String facultyName;

        System.out.println("Input the Faculty information to remove");
        System.out.print("Input the Faculty Name: ");
        facultyName =  input.nextLine();

        courseManager.removeFaculty(facultyName);
    }

    public void updateFaculty() {

        String name;
        String department;

        System.out.println("Input the Faculty information to Update");
        System.out.print("Input the name: ");
        name =  input.nextLine();
        System.out.print("Input the Department: ");
        department =  input.nextLine();

        courseManager.updateFaculty(name, department);
    }

    public void assignFacultyToCourse() {
        String courseCode;
        String facultyName;

        System.out.println("Input the information to assign Faculty to Course");
        System.out.print("Input the Course Code: ");
        courseCode =  input.nextLine();
        System.out.print("Input the Faculty name: ");
        facultyName =  input.nextLine();

        courseManager.assignFacultyToCourse(courseCode, facultyName);
    }

    public void unassignFacultyFromCourse() {
        String courseCode;
        String facultyName;

        System.out.println("Input the information to unassign Faculty from the Course");
        System.out.print("Input the Course Code: ");
        courseCode =  input.nextLine();
        System.out.print("Input the Faculty name: ");
        facultyName =  input.nextLine();

        courseManager.unassignFacultyFromCourse(courseCode, facultyName);
    }
}