import java.util.ArrayList;
import java.util.List;

class Course
{
  private String department;
  private String courseCode;
  private String prerequisite;
  private double credit;
  //private String facultyName;
  private List<Section> sectionList;
  private List<String> facultyList;
  private List<String> enrolledIdList;

  private int sectionCount;

  public Course(String department, String courseCode, String prerequisite, double credit)
  {
    this.department = department;
    this.courseCode = courseCode;
    this.prerequisite = prerequisite;
    this.credit = credit;

    sectionList = new ArrayList<>();
    facultyList = new ArrayList<>();
    enrolledIdList = new ArrayList<>();

    this.sectionCount = 1;
  }

  /*
  public void addSection(Section section) {
    sections.add(section);
  }

  public void removeSection(Section section) {
    sections.remove(section);
  }

  public void updateSection(Section section) {
    //update the section in the sections list
  }
   */

  public void incrementSectionCount()
  {
    sectionCount++;
  }
  public void decrementSectionCount()
  {
    if(sectionCount <= 0)
      sectionCount = 0;
    else
      sectionCount--;
  }


  // getter and setter
  public String getDepartment()
  {
    return department;
  }

  public void setDepartment(String department)
  {
    this.department = department;
  }

  public String getCourseCode()
  {
    return courseCode;
  }

  public void setCourseCode(String courseCode)
  {
    this.courseCode = courseCode;
  }

  public String getPrerequisite()
  {
    return prerequisite;
  }

  public void setPrerequisite(String prerequisite)
  {
    this.prerequisite = prerequisite;
  }

  public double getCredit()
  {
    return credit;
  }

  public void setCredit(double credit)
  {
    this.credit = credit;
  }

  public List<Section> getSectionList()
  {
    return sectionList;
  }

  public void setSectionList(List<Section> sectionList)
  {
    this.sectionList = sectionList;
  }

  public List<String> getFacultyList()
  {
    return facultyList;
  }

  public void setFacultyList(List<String> facultyList)
  {
    this.facultyList = facultyList;
  }

  public List<String> getEnrolledIdList()
  {
    return enrolledIdList;
  }

  public void setEnrolledIdList(List<String> enrolledIdList)
  {
    this.enrolledIdList = enrolledIdList;
  }

  public int getSectionCount()
  {
    return sectionCount;
  }

  public void setSectionCount(int sectionCount)
  {
    this.sectionCount = sectionCount;
  }
}