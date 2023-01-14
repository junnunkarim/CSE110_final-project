import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Student {
  private String name;
  private String id;
  private String department;
  private String semesterEnrolled;
  private String currentSemester;
  private String password;
  private double totalCredit;
  private double cgpa;
  private double termGpa;
  private int maxCourseLimit;
  private boolean probationStatus;
  private List<String> currentCourseList; // courseCode
  //private List<Course> completedCourseList;
  private HashMap<String, Double> courseGradeList; // <courseCode, CGPA>
  private HashMap<String, Boolean> courseEligibilityList;  // <courseCode, true of false> check what courses can the student take
  private HashMap<String, Boolean> courseWithdrawStatus; // <courseCode, true or false>
  private HashMap<String, Boolean> courseFailedStatus; // <courseCode, true or false>

  public Student(String name, String id, String department, String semesterEnrolled, String password) {
    this.name = name;
    this.id = id;
    this.department = department;
    this.semesterEnrolled = semesterEnrolled;
    this.currentSemester = semesterEnrolled;
    this.password = password;
    this.totalCredit = 0.0;
    this.cgpa = 0.0;
    this.termGpa = 0.0;
    this.maxCourseLimit = 5;
    this.probationStatus = false;

    currentCourseList = new ArrayList<>();
    completedCourseList = new ArrayList<>();
    courseGrade = new HashMap<>();

  }

  // methods
  public void updateCourseEligibilityList()
  {

  }
  public void enrollCourse(Course course) {
    if (currentCourses.size() < maxCourseLimit) {
      currentCourses.add(course);
      totalCredit += course.getCredit();
    } else {
      System.out.println("Sorry, you have reached the maximum course limit.");
    }
  }

  public void withdrawCourse(Course course) {
    if (currentCourses.contains(course)) {
      currentCourses.remove(course);
      totalCredit -= course.getCredit();
    } else {
      System.out.println("You are not enrolled in this course.");
    }
  }

  public void showPayCheck() {
    // code to calculate and display student's fee
  }

  public void showProfile() {
    System.out.println("Name: " + name);
    System.out.println("ID: " + id);
    System.out.println("Department: " + department);
    System.out.println("Semester Enrolled: " + semesterEnrolled);
    System.out.println("Current Semester: " + currentSemester);
    System.out.println("Total Credit: " + totalCredit);
    System.out.println("CGPA: " + cgpa);
    System.out.println("Term GPA: " + termGpa);
    System.out.println("Max Course Limit: " + maxCourseLimit);
    System.out.println("Probation Status: " + probationStatus);
    System.out.println("Current Courses: " + currentCourses);
    System.out.println("Completed Courses: " + completedCourses);
  }

  public void listOptions() {
    // code to display available options for the student
  }

  public void newSemester() {
    // code to update student's information for a new semester
  }
}