import java.util.ArrayList;
import java.util.List;

class Course {
  private String department;
  private String courseCode;
  private String prerequisite;
  private double credit;
  private String facultyName;
  private List<Section> sections;

  public Course(String department, String courseCode, String prerequisite, double credit) {
    this.department = department;
    this.courseCode = courseCode;
    this.prerequisite = prerequisite;
    this.credit = credit;
    sections = new ArrayList<Section>();
  }

  public void addSection(Section section) {
    sections.add(section);
  }

  public void removeSection(Section section) {
    sections.remove(section);
  }

  public void updateSection(Section section) {
    //update the section in the sections list
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getCourseCode() {
    return courseCode;
  }

  public void setCourseCode(String courseCode) {
    this.courseCode = courseCode;
  }

  public String getPrerequisite() {
    return prerequisite;
  }

  public void setPrerequisite(String prerequisite) {
    this.prerequisite = prerequisite;
  }

  public double getCredit() {
    return credit;
  }

  public void setCredit(double credit) {
    this.credit = credit;
  }

  public String getFacultyName() {
    return facultyName;
  }

  public void setFacultyName(String facultyName) {
    this.facultyName = facultyName;
  }

  public List<Section> getSections() {
    return sections;
  }

  public void setSections(List<Section> sections) {
    this.sections = sections;
  }
}