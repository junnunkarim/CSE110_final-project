import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseEnrollment {
  private HashMap<String, Student> students;
  private HashMap<String, List<Course>> studentCourses;

  public CourseEnrollment() {
    students = new HashMap<>();
    studentCourses = new HashMap<>();
  }

  public void addStudent(Student student) {
    students.put(student.getId(), student);
    studentCourses.put(student.getId(), student.getEnrolledCourses());
  }

  public void removeStudent(String studentId) {
    students.remove(studentId);
    studentCourses.remove(studentId);
  }

  public void updateStudent(String studentId) {
    Student student = students.get(studentId);
    if (student != null) {
      student.update();
      studentCourses.put(studentId, student.getEnrolledCourses());
    }
  }

  public void enrollStudent(String studentId, Course course) {
    Student student = students.get(studentId);
    if (student != null) {
      student.addCourse(course);
      studentCourses.put(studentId, student.getEnrolledCourses());
    }
  }

  public void withdrawStudent(String studentId, Course course) {
    Student student = students.get(studentId);
    if (student != null) {
      student.dropCourse(course);
      studentCourses.put(studentId, student.getEnrolledCourses());
    }
  }

  public Student getStudent(String id) {
    return students.get(id);
  }

  public List<Student> getStudentList() {
    return new ArrayList<>(students.values());
  }

  public List<Course> getEnrolledCourses(String studentId) {
    return studentCourses.get(studentId);
  }

  public double getStudentFee(String studentId) {
    Student student = students.get(studentId);
    if (student != null) {
      return student.calculateFee();
    }
    return 0;
  }
}