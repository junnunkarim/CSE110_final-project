import java.util.ArrayList;
import java.util.List;

class Section {
  private String time24;
  private String weekDate;
  private int room;
  private int sectionNo;
  private int capacity;
  private int enrolled;

  private String courseCode;
  private String facultyName;
  private List<String> enrolledIdList;

  public Section(String courseCode, String time24, String weekDate, int room, int sectionNo, int capacity) {
    this.courseCode = courseCode;
    this.time24 = time24;
    this.weekDate = weekDate;
    this.room = room;
    this.sectionNo = sectionNo;
    this.capacity = capacity;
    this.enrolled = 0;

    this.facultyName = "null";
    this.enrolledIdList = new ArrayList<>();
  }

  // getter and setter
  public String getTime24()
  {
    return time24;
  }

  public void setTime24(String time24)
  {
    this.time24 = time24;
  }

  public String getWeekDate()
  {
    return weekDate;
  }

  public void setWeekDate(String weekDate)
  {
    this.weekDate = weekDate;
  }

  public int getRoom()
  {
    return room;
  }

  public void setRoom(int room)
  {
    this.room = room;
  }

  public int getSectionNo()
  {
    return sectionNo;
  }

  public void setSectionNo(int sectionNo)
  {
    this.sectionNo = sectionNo;
  }

  public int getCapacity()
  {
    return capacity;
  }

  public void setCapacity(int capacity)
  {
    this.capacity = capacity;
  }

  public int getEnrolled()
  {
    return enrolled;
  }

  public void setEnrolled(int enrolled)
  {
    this.enrolled = enrolled;
  }

  public String getCourseCode()
  {
    return courseCode;
  }

  public void setCourseCode(String courseCode)
  {
    this.courseCode = courseCode;
  }

  public String getFacultyName()
  {
    return facultyName;
  }

  public void setFacultyName(String facultyName)
  {
    this.facultyName = facultyName;
  }

  public List<String> getEnrolledIdList()
  {
    return enrolledIdList;
  }

  public void setEnrolledIdList(List<String> enrolledIdList)
  {
    this.enrolledIdList = enrolledIdList;
  }
}