import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class CourseManager {
  // HashMap to store courses, where the key is the course code and the value is the course object
  private HashMap<String, Course> courses;
  // HashMap to store faculty, where the key is the faculty name and the value is the faculty object
  private HashMap<String, Faculty> faculty;
  // Reference to the SectionManager class
  private SectionManager sectionManager;

  public CourseManager(){
    courses = new HashMap<>();
    faculty = new HashMap<>();
    sectionManager = new SectionManager();
  }

  // Method to add a new course
  public void addCourse(String department, String courseCode, String prerequisite, double credit) {
    Course course = new Course(department, courseCode, prerequisite, credit);
    courses.put(courseCode, course);
  }

  // Method to remove a course
  public void removeCourse(String courseCode) {
    courses.remove(courseCode);
    sectionManager.removeSections(courseCode);
  }

  // Method to update a course
  public void updateCourse(String courseCode, String department, String prerequisite, double credit) {
    Course course = courses.get(courseCode);
    if(course != null){
      course.setDepartment(department);
      course.setPrerequisite(prerequisite);
      course.setCredit(credit);
      courses.put(courseCode, course);
    }
  }

  // Method to get a course by course code
  public Course getCourse(String courseCode) {
    return courses.get(courseCode);
  }

  // Method to get all courses
  public List<Course> getAllCourses() {
    return new ArrayList<>(courses.values());
  }

  // Method to add a new faculty member
  public void addFaculty(String name, String department, String email) {
    Faculty faculty = new Faculty(name, department, email);
    this.faculty.put(name, faculty);
  }

  // Method to remove a faculty member
  public void removeFaculty(String name) {
    faculty.remove(name);
    sectionManager.removeFaculty(name);
  }

  // Method to update a faculty member
  public void updateFaculty(String name, String department, String email) {
    Faculty faculty = this.faculty.get(name);
    if(faculty != null){
      faculty.setDepartment(department);
      faculty.setEmail(email);
      this.faculty.put(name, faculty);
    }
  }

  // Method to get a faculty member by name
  public Faculty getFaculty(String name) {
    return faculty.get(name);
  }

  // Method to get all faculty members
  public List<Faculty> getAllFaculty() {
    return new ArrayList<>(faculty.values());
  }

  // Method to assign a faculty member to a section
  public void assignFacultyToSection(String courseCode, int sectionNo, String facultyName) {
    Course course = courses.get(courseCode);
    if(course != null){
      Faculty faculty = this.faculty.get(facultyName);
      if(faculty != null){
        sectionManager.assignFacultyToSection(course, sectionNo, faculty);
      }
    }
  }
  // Method to unassign a faculty member from a section
  public void unassignFacultyFromSection(String courseCode, int sectionNo) {
    sectionManager.unassignFacultyFromSection(courseCode, sectionNo);
  }
  // Method to get a section by course code and section number
  public Section getSection(String courseCode, int sectionNo) {
    return sectionManager.getSection(courseCode, sectionNo);
  }
  // Method to get all sections of a course
  public List<Section> getSections(String courseCode) {
    return sectionManager.getSections(courseCode);
  }
  // Method to add a new section to a course
  public void addSection(String courseCode, int sectionNo, String time24, String weekDate, int room, int capacity) {
    Course course = courses.get(courseCode);
    if(course != null){
      sectionManager.addSection(course, sectionNo, time24, weekDate, room, capacity);
    }
  }
  // Method to remove a section from a course
  public void removeSection(String courseCode, int sectionNo) {
    sectionManager.removeSection(courseCode, sectionNo);
  }
  // Method to update a section
  public void updateSection(String courseCode, int sectionNo, String time24, String weekDate, int room, int capacity) {
    sectionManager.updateSection(courseCode, sectionNo, time24, weekDate, room, capacity);
  }
}