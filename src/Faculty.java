import java.util.HashMap;
import java.util.List;

class Faculty
{
  private String name, department; // department format: CSE110
  HashMap<String, List<Integer>> courseList; //<courseCode, Section list of that course>

  public Faculty(String name, String department)
  {
    this.name = name;
    this.department = department;
    courseList = new HashMap<>();
  }

  // methods
  public List<Integer> getSectionNoListOfCourse(String courseCode)
  {
    return courseList.get(courseCode);
  }

  // getter and setter
  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getDepartment()
  {
    return department;
  }

  public void setDepartment(String department)
  {
    this.department = department;
  }

  public HashMap<String, List<Integer>> getCourseList()
  {
    return courseList;
  }

  public void setCourseList(HashMap<String, List<Integer>> courseList)
  {
    this.courseList = courseList;
  }
}