import java.util.ArrayList;

public class Section {
    private String facultyName, time24, weekDate;
    private int room, sectionNo, capacity, enrolled;
    private ArrayList<String> enrolledIdList = new ArrayList<>();

    public Section(String facultyName, String time24, String weekDate, int room, int sectionNo, int capacity) {
        enrolled = 0;
        this.facultyName = facultyName;
        this.time24 = time24;
        this.weekDate = weekDate;
        this.room = room;
        this.sectionNo = sectionNo;
        this.capacity = capacity;
    }

    // method
    void addId(String ID)
    {
        enrolledIdList.add(ID);
    }

    // getter and setter
    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getTime24() {
        return time24;
    }

    public void setTime24(String time24) {
        this.time24 = time24;
    }

    public String getWeekDate() {
        return weekDate;
    }

    public void setWeekDate(String weekDate) {
        this.weekDate = weekDate;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getSectionNo() {
        return sectionNo;
    }

    public void setSectionNo(int sectionNo) {
        this.sectionNo = sectionNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(int enrolled) {
        this.enrolled = enrolled;
    }

    public ArrayList<String> getEnrolledIdList() {
        return enrolledIdList;
    }

    public void setEnrolledIdList(ArrayList<String> enrolledIdList) {
        this.enrolledIdList = enrolledIdList;
    }
}
