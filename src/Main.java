import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

class Main {
  private CourseManager courseManager;
  private CourseEnrollment courseEnrollment;

  public static void main(String[] args) {
    Main main = new Main();
    main.initialize();
    main.run();
  }

  public void initialize() {
    courseManager = new CourseManager();
    courseEnrollment = new CourseEnrollment();

    loadData();
  }

  public void run() {
    Scanner input = new Scanner(System.in);
    boolean running = true;

    while (running) {
      System.out.println("1. Load data from file");
      System.out.println("2. Save data to file");
      System.out.println("3. Add course");
      System.out.println("4. Remove course");
      System.out.println("5. Update course");
      System.out.println("6. Add student");
      System.out.println("7. Remove student");
      System.out.println("8. Update student");
      System.out.println("9. Exit");

      int choice = input.nextInt();

      switch (choice) {
        case 1:
          loadData();
          break;
        case 2:
          saveData();
          break;
        case 3:
          addCourse();
          break;
        case 4:
          removeCourse();
          break;
        case 5:
          updateCourse();
          break;
        case 6:
          addStudent();
          break;
        case 7:
          removeStudent();
          break;
        case 8:
          updateStudent();
          break;
        case 9:
          running = false;
          break;
        default:
          System.out.println("Invalid choice");
      }
    }

    input.close();
  }

  public void loadData() {
    try {
      FileInputStream fis = new FileInputStream("courses.dat");
      ObjectInputStream ois = new ObjectInputStream(fis);

      courseManager = (CourseManager) ois.readObject();

      fis = new FileInputStream("enrollments.dat");
      ois = new ObjectInputStream(fis);

      courseEnrollment = (CourseEnrollment) ois.readObject();

      ois.close();
      fis.close();

      System.out.println("Data loaded successfully");
    } catch (Exception e) {
      System.out.println("Error loading data: " + e.getMessage());
    }
  }

  public void saveData() {
    try {
      FileOutputStream fos = new FileOutputStream("courses.dat");
      ObjectOutputStream oos = new ObjectOutputStream(fos);

      oos.writeObject(courseManager);

      fos = new FileOutputStream("enrollments.dat");
      oos = new ObjectOutputStream(fos);

      oos.writeObject(courseEnrollment);

      oos.close();
      fos.close();

      System.out.println("Data saved successfully");
    } catch (Exception e) {
      System.out.println("Error saving data: " + e.getMessage());
    }
  }

  public void addCourse() {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter course department:");
    String department = input.nextLine();
    System.out.println("Enter course code:");
    String courseCode = input.nextLine();
    System.out.println("Enter course prerequisite:");
    String prerequisite = input.nextLine();
    System.out.println("Enter course credit:");
    double credit = input.nextDouble();
    input.nextLine(); // Consume the remaining newline character
    System.out.println("Enter course faculty:");
    String faculty = input.nextLine();

    Course newCourse = new Course(department, courseCode, prerequisite, credit, faculty);
    courseManager.addCourse(newCourse);
    System.out.println("Course added successfully.");
  }

  public void removeCourse() {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter course code:");
    String courseCode = input.nextLine();

    courseManager.removeCourse(courseCode);
    System.out.println("Course removed successfully.");
  }

  public void updateCourse() {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter course code:");
    String courseCode = input.nextLine();
    System.out.println("Enter new course department:");
    String department = input.nextLine();
    System.out.println("Enter new course prerequisite:");
    String prerequisite = input.nextLine();
    System.out.println("Enter new course credit:");
    double credit = input.nextDouble();
    input.nextLine(); // Consume the remaining newline character
    System.out.println("Enter new course faculty:");
    String faculty = input.nextLine();

    courseManager.updateCourse(courseCode, department, prerequisite, credit, faculty);
    System.out.println("Course updated successfully.");
  }

  public void addStudent() {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter student name:");
    String studentName = input.nextLine();
    System.out.println("Enter student id:");
    String studentId = input.nextLine();
    System.out.println("Enter student department:");
    String studentDepartment = input.nextLine();
    System.out.println("Enter student semester enrolled:");
    String studentSemesterEnrolled = input.nextLine();
    System.out.println("Enter student current semester:");
    String studentCurrentSemester = input.nextLine();
    System.out.println("Enter student password:");
    String studentPassword = input.nextLine();

    Student newStudent = new Student(studentName, studentId, studentDepartment, studentSemesterEnrolled, studentCurrentSemester, studentPassword);
    courseEnrollment.addStudent(newStudent);
    System.out.println("Student added successfully.");
  }

  public void removeStudent() {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter student id:");
    String studentId = input.nextLine();

    courseEnrollment.removeStudent(studentId);
    System.out.println("Student removed successfully.");
  }

  public void updateStudent() {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter student id:");
    String studentId = input.nextLine();
    System.out.println("Enter new student name:");
    String studentName = input.nextLine();
    System.out.println("Enter new student department:");
    String studentDepartment = input.nextLine();
    System.out.println("Enter new student semester enrolled:");
    String studentSemesterEnrolled = input.nextLine();
    System.out.println("Enter new student current semester:");
    String studentCurrentSemester = input.nextLine();
    System.out.println("Enter new student password:");
    String studentPassword = input.nextLine();

    courseEnrollment.updateStudent(studentId, studentName, studentDepartment, studentSemesterEnrolled, studentCurrentSemester, studentPassword);
    System.out.println("Student updated successfully.");
  }

}

