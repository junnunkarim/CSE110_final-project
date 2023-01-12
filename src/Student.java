import java.util.ArrayList;
import java.util.*;
public class Student {
    private String name, id, department, semesterEnrolled, currentSemester, password;
    private double totalCredit,cgpa,termGpa;
    private int maxCourseLimit;
    private boolean probationStatus;
    private ArrayList<String> currentCourseList, failedCourseList, completedCourseList;

    public Student(String name, String id, String department, String semesterEnrolled, String password) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.semesterEnrolled = semesterEnrolled;
        this.password = password;
        currentSemester = semesterEnrolled;
        totalCredit = cgpa = termGpa = 0.0;
        maxCourseLimit = 5;
        probationStatus = false;
    }

    void addCourse(){
        if(probationStatus){
            System.out.println("Suggested Course List");
            for(int i = 0;i<failedCourseList.size();i++){
                System.out.println((i+1)+": " + failedCourseList.get(i));
            }
            Scanner input = new Scanner(System.in);

            /*
            int selection,i = 1;
            do{
                System.out.println("Please enter the course number to add course");
                System.out.println("     1. Add Course");
                System.out.println("     2. return");
                selection = input.nextInt();
                if((i == maxCourseLimit) || selection == 2) break;
                else{

                }

            }while(true); */

        }

        else{

        }
    }



    //Getter & Setter

    public boolean isProbationStatus() {
        return probationStatus;
    }

    public void setProbationStatus(boolean probationStatus) {
        this.probationStatus = probationStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSemesterEnrolled() {
        return semesterEnrolled;
    }

    public void setSemesterEnrolled(String semesterEnrolled) {
        this.semesterEnrolled = semesterEnrolled;
    }

    public String getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(String currentSemester) {
        this.currentSemester = currentSemester;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(double totalCredit) {
        this.totalCredit = totalCredit;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public double getTermGpa() {
        return termGpa;
    }

    public void setTermGpa(double termGpa) {
        this.termGpa = termGpa;
    }

    public int getMaxCourseLimit() {
        return maxCourseLimit;
    }

    public void setMaxCourseLimit(int maxCourseLimit) {
        this.maxCourseLimit = maxCourseLimit;
    }

    public ArrayList<String> getCurrentCourseList() {
        return currentCourseList;
    }

    public void setCurrentCourseList(ArrayList<String> currentCourseList) {
        this.currentCourseList = currentCourseList;
    }

    public ArrayList<String> getFailedCourseList() {
        return failedCourseList;
    }

    public void setFailedCourseList(ArrayList<String> failedCourseList) {
        this.failedCourseList = failedCourseList;
    }

    public ArrayList<String> getCompletedCourseList() {
        return completedCourseList;
    }

    public void setCompletedCourseList(ArrayList<String> completedCourseList) {
        this.completedCourseList = completedCourseList;
    }
}
