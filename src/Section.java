import java.util.ArrayList;
import java.util.List;

class Section {
  private String facultyName;
  private String time24;
  private String weekDate;
  private int room;
  private int sectionNo;
  private int capacity;
  private int enrolled;
  private List<String> enrolledIdList;

  public Section(String facultyName, String time24, String weekDate, int room, int sectionNo, int capacity) {
    this.facultyName = facultyName;
    this.time24 = time24;
    this.weekDate = weekDate;
    this.room = room;
    this.sectionNo = sectionNo;
    this.capacity = capacity;
    this.enrolled = 0;
    this.enrolledIdList = new ArrayList<>();
  }

  public void addEnrollment(String studentId) {
    if (enrolled < capacity) {
      enrolled++;
      enrolledIdList.add(studentId);
    } else {
      System.out.println("Section is full, cannot add more enrollments");
    }
  }

  public void removeEnrollment(String studentId) {
    if (enrolledIdList.contains(studentId)) {
      enrolled--;
      enrolledIdList.remove(studentId);
    } else {
      System.out.println("Student is not enrolled in this section");
    }
  }

  public int getAvailableCapacity() {
    return capacity - enrolled;
  }
}