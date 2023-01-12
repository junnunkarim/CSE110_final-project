import java.util.ArrayList;
import java.util.Scanner;

public class Course
{
  private String department, courseCode, prerequisite;
  private double credit;
  private ArrayList<Section> sectionList = new ArrayList<>();

  public Course(String department, String courseCode, String prerequisite, double credit)
  {
    this.department = department;
    this.courseCode = courseCode;
    this.prerequisite = prerequisite;
    this.credit = credit;
  }

  // methods
  void addSection()
  {
    String facultyName, time24, weekDate;
    int room, sectionNo, capacity;

    Scanner input = new Scanner(System.in);

    System.out.print("Faculty Name: ");
    facultyName = input.nextLine();
    System.out.print("Time-table (format- 11:30-13:00): ");
    time24 = input.nextLine();
    System.out.print("Week Date (format- TR): ");
    weekDate = input.nextLine();
    System.out.print("Room NO: ");
    room = input.nextInt();
    System.out.print("Section NO: ");
    sectionNo = input.nextInt();
    System.out.print("Max seat capacity: ");
    capacity = input.nextInt();
    input.nextLine();

    Section section = new Section(facultyName, time24, weekDate, room, sectionNo, capacity);

    sectionList.add(section);
  }

  void removeSection(int section)
  {
    for(int i = 0; i < sectionList.size(); i++)
    {
      if(sectionList.get(i).getSectionNo() == section)
      {
        sectionList.remove(i);
        break;
      }
    }
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

  public ArrayList<Section> getSectionList()
  {
    return sectionList;
  }

  public void setSectionList(ArrayList<Section> sectionList)
  {
    this.sectionList = sectionList;
  }
}
