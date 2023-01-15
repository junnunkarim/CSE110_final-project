import java.util.ArrayList;
import java.util.List;

class Course
{
  //private String department;
  private String courseCode; // format: MAT104
  private String prerequisite;
  private double credit;
  private int sectionCount;
  //private String facultyName;
  private List<String> departmentList;
  private List<String> facultyList;
  private List<String> enrolledIdList;
  private List<Section> sectionList;

  public Course(List<String> departmentList, String courseCode, String prerequisite, double credit)
  {
    this.courseCode = courseCode;
    this.prerequisite = prerequisite;
    this.credit = credit;
    this.departmentList = departmentList;

    sectionList = new ArrayList<>();
    facultyList = new ArrayList<>();
    enrolledIdList = new ArrayList<>();

    this.sectionCount = 1;
  }


  // methods
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

  public void addSection(String time24, String weekDate, int room, int capacity)
  {
    incrementSectionCount();
    Section section = new Section(courseCode, time24, weekDate, room, getSectionCount(), capacity);
    sectionList.add(section);
  }

  public void removeSection(int sectionNo)
  {
    for(Section section : getSectionList())
    {
      if (section.getSectionNo() == sectionNo)
      {
        decrementSectionCount();

        String facultyName = section.getFacultyName();
        if(section.getFacultyName().equals(facultyName))
        {
          Main.facultyMap.get(facultyName).getCourseList().get(courseCode).remove(sectionNo);
        }

        getSectionList().remove(sectionNo);
        break;
      }
      else
        System.out.println("Section not found!");
    }
  }

  public void updateSection(int sectionNo, String time24, String weekDate, int room, int capacity)
  {
    for(Section section : getSectionList())
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

  public Section getSection(int sectionNo)
  {
    for(Section sec : getSectionList())
    {
      if(sec.getSectionNo() == sectionNo)
      {
        return sec;
      }
    }

    return null;
  }

  // getter and setter
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

  public List<String> getDepartmentList()
  {
    return departmentList;
  }

  public void setDepartmentList(List<String> departmentList)
  {
    this.departmentList = departmentList;
  }
}