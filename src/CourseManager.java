import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class CourseManager {
  public CourseManager() {}

  // Method to add a new course
  public void addCourse(String department, String courseCode, String prerequisite, double credit)
  {
    Course course = new Course(department, courseCode, prerequisite, credit);
    Main.courseMap.put(courseCode, course);
  }

  // Method to remove a course
  public void removeCourse(String courseCode)
  {
    Main.courseMap.remove(courseCode);
  }

  // Method to update a course
  public void updateCourse(String courseCode, String department, String prerequisite, double credit)
  {
    Course course = Main.courseMap.get(courseCode);

    if(course != null){
      course.setDepartment(department);
      course.setPrerequisite(prerequisite);
      course.setCredit(credit);

      Main.courseMap.put(courseCode, course);
    }
  }

  // Method to get a course by course code
  public Course getCourse(String courseCode)
  {
    return Main.courseMap.get(courseCode);
  }

  // Method to get all courses
  public List<Course> getAllCourses()
  {
    return new ArrayList<>(Main.courseMap.values());
  }

  // Method to add a new faculty member
  public void addFaculty(String name, String department)
  {
    Faculty faculty = new Faculty(name, department);
    Main.facultyMap.put(name, faculty);
  }

  // Method to remove a faculty member
  public void removeFaculty(String facultyName)
  {
    HashMap<String, List<Integer>> list = Main.facultyMap.get(facultyName).getCourseList(); //<courseCode, Section list of that course>

    for(String courseCode : list.keySet())
    {
      Course course = Main.courseMap.get(courseCode);

      course.getFacultyList().remove(facultyName);
    }

    Main.facultyMap.remove(facultyName);
  }

  // Method to update a faculty member
  public void updateFaculty(String name, String department) {
    Faculty faculty = Main.facultyMap.get(name);
    if(faculty != null){
      faculty.setDepartment(department);
      Main.facultyMap.put(name, faculty);
    }
  }

  // Method to get a faculty member by name
  public Faculty getFaculty(String facultyName)
  {
    return Main.facultyMap.get(facultyName);
  }

  // Method to get all faculty members
  public List<Faculty> getAllFaculty()
  {
    return new ArrayList<>(Main.facultyMap.values());
  }

  // Method to assign a faculty member to a Course
  public void assignFacultyToCourse(String courseCode, String facultyName)
  {
    Course course = Main.courseMap.get(courseCode);
    if(course != null){
      Faculty faculty = Main.facultyMap.get(facultyName);
      if(faculty != null){
        course.getFacultyList().add(faculty.getName());
      }
    }
  }

  // Method to unassign a faculty member from a Course
  public void unassignFacultyFromCourse(String courseCode, String facultyName)
  {
    Main.courseMap.get(courseCode).getFacultyList().remove(facultyName);
  }

  // Method to assign a faculty member to a Course
  public void assignSectionToFaculty(String courseCode, String facultyName, int sectionNo)
  {
    Course course = Main.courseMap.get(courseCode);
    if(course != null)
    {
      List<String> facultyList = course.getFacultyList();
      List<Section> sectionList = course.getSectionList();

      if(facultyList.contains(facultyName))
      {
        for(Section section : sectionList)
        {
          if( (section.getSectionNo() == sectionNo) && (section.getFacultyName().equals("null")) )
          {
            section.setFacultyName(facultyName);

            HashMap<String, List<Integer>> list = Main.facultyMap.get(facultyName).getCourseList();
            list.get(courseCode).add(sectionNo);

            break;
          }
        }
      }
      else
        System.out.println("Faculty not assigned to the given course!");
    }
    else
      System.out.println("Course not found!");
  }

  // Method to unassign a faculty member from a Course
  public void unassignSectionFromFaculty(String courseCode, String facultyName, int sectionNo)
  {
    Course course = Main.courseMap.get(courseCode);
    if(course != null){
      List<String> facultyList = course.getFacultyList();
      List<Section> sectionList = course.getSectionList();

      if(facultyList.contains(facultyName))
      {
        for(Section section : sectionList)
        {
          if( (section.getSectionNo() == sectionNo) && (section.getFacultyName().equals(facultyName)) )
          {
            section.setFacultyName("null");

            HashMap<String, List<Integer>> list = Main.facultyMap.get(facultyName).getCourseList();
            list.get(courseCode).remove(sectionNo);

            break;
          }
        }
      }
      else
        System.out.println("Faculty not assigned to the given course!");
    }
    else
      System.out.println("Course not found!");
  }

  public void addSectionToCourse(String courseCode, String time24, String weekDate, int room, int capacity)
  {
    Course course = Main.courseMap.get(courseCode);
    if(course != null)
    {
      course.incrementSectionCount();
      Section section = new Section(courseCode, time24, weekDate, room, course.getSectionCount(), capacity);
      course.getSectionList().add(section);
    }
    else
      System.out.println("Course not found!");
  }

  public void removeSectionFromCourse(String courseCode, int sectionNo)
  {
    Course course = Main.courseMap.get(courseCode);
    if(course != null)
    {
      for(Section section : course.getSectionList())
      {
        if (section.getSectionNo() == sectionNo)
        {
          course.decrementSectionCount();

          String facultyName = section.getFacultyName();
          if(section.getFacultyName().equals(facultyName))
          {
            Main.facultyMap.get(facultyName).getCourseList().get(courseCode).remove(sectionNo);
          }

          course.getSectionList().remove(sectionNo);
          break;
        }
        else
          System.out.println("Section not found!");
      }
    }
    else
      System.out.println("Course not found!");
  }

  public void updateSectionInCourse(String courseCode, int sectionNo, String time24, String weekDate, int room, int capacity)
  {
    Course course = Main.courseMap.get(courseCode);
    if(course != null)
    {
      for(Section section : course.getSectionList())
      {
        if(section.getSectionNo() == (sectionNo - 1))
        {
          section.setTime24(time24);
          section.setWeekDate(weekDate);
          section.setRoom(room);
          section.setCapacity(capacity);

          break;
        }
      }
    }
    else
      System.out.println("Course not found!");
  }
}