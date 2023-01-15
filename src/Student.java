import java.util.*;

class Student {
  private String name;
  private String id;
  private String department;
  private String semesterEnrolled;
  private String currentSemester;
  private String password;
  private double totalCredit;
  private double cgpa;
  private double termGpa; // use a HashMap maybe?
  private int maxCourseLimit;
  private int totalSemesterCompleted;
  //private boolean probationStatus;
  private List<String> currentCourseList; // courseCode
  //private List<Course> completedCourseList;
  private HashMap<String, Double> courseGradeList; // <courseCode, CGPA>
  private HashMap<String, Boolean> courseEligibilityList;  // <courseCode, true of false> check what courses can the student take
  //private HashMap<String, Boolean> courseWithdrawStatus; // <courseCode, true or false>
  //private HashMap<String, Boolean> courseFailedStatus; // <courseCode, true or false>

  public Student(String name, String id, String department, String semesterEnrolled, String password) {
    this.name = name;
    this.id = id;
    this.department = department;
    this.semesterEnrolled = semesterEnrolled;
    this.currentSemester = semesterEnrolled;
    this.password = password;

    this.totalCredit = 0.0;
    this.cgpa = 0.0;
    this.termGpa = 0.0;
    this.maxCourseLimit = 5;
    this.totalSemesterCompleted = 0;
    //this.probationStatus = false;

    currentCourseList = new ArrayList<>();
    courseGradeList = new HashMap<>();
    courseEligibilityList = new HashMap<>();
    //courseWithdrawStatus = new HashMap<>();
    //courseFailedStatus = new HashMap<>();
  }

  // methods
  public void updateCourseEligibilityList()
  {
    courseEligibilityList.clear();

    for(Map.Entry<String, Course> courseList : Main.courseMap.entrySet())
    {
      Course course = courseList.getValue();

      if(course.getDepartmentList().contains(this.department))
      {
        if(courseGradeList.containsKey(course.getCourseCode()))
          courseEligibilityList.put(course.getCourseCode(), false);
        else
        {
          if(course.getPrerequisite().equals("null"))
            courseEligibilityList.put(course.getCourseCode(), true);
          else
          {
            if(courseGradeList.containsKey(course.getPrerequisite()))
              courseEligibilityList.put(course.getCourseCode(), true);
            else
              courseEligibilityList.put(course.getCourseCode(), false);
          }
        }
      }
      else
        courseEligibilityList.put(course.getCourseCode(), false);
    }
  }

  public void listEligibleCourse()
  {
    System.out.println("Course Code\tSection\tWeek-Date\tTime-Table\tRoom\tCapacity");
    for(Map.Entry<String, Boolean> eligibilityList : courseEligibilityList.entrySet())
    {
      String key = eligibilityList.getKey();
      boolean value = eligibilityList.getValue();

      for (Section section : Main.courseMap.get(key).getSectionList())
      {
        System.out.println(key + "\t" + section.getSectionNo() + "\t" + section.getWeekDate() + "\t" + section.getTime24() + "\t" + section.getRoom() + "\t" + section.getEnrolled() + "/" + section.getCapacity());
      }
    }
  }

  public void addCourse()
  {
    while(currentCourseList.size() <= maxCourseLimit)
    {
      listEligibleCourse();

      System.out.print("\n\n" + "Enter name of course you want to add(enter quit to exit): ");

      Scanner input = new Scanner(System.in);
      String courseCode = input.nextLine();

      if(courseCode.equalsIgnoreCase("quit"))
        break;

      enrollCourse(courseCode);
    }
  }

  public void enrollCourse(String courseCode)
  {
    if(courseEligibilityList.get(courseCode))
    {
      if(currentCourseList.size() <= maxCourseLimit)
      {
        currentCourseList.add(courseCode);
      }
      else
        System.out.println("You can't add more than " + maxCourseLimit + " courses!");
    }
  }

  public void dropCourse(String courseCode)
  {
    if(currentCourseList.contains(courseCode))
    {
      currentCourseList.remove(courseCode);
    }
    else
    {
      System.out.println("You are not enrolled in this course.");
    }
  }

  /*
  public void withdrawCourse(String courseCode)
  {
    if(currentCourseList.contains(courseCode))
    {
      currentCourseList.remove(courseCode);
      courseWithdrawStatus.put(courseCode, true);
    }
    else
    {
      System.out.println("You are not enrolled in this course.");
    }
  }
  */

  public void calculateCgpa()
  {

  }

  public void showPayCheck() {
    // code to calculate and display student's fee
  }

  public void showProfile() {
    System.out.println("Name: " + name);
    System.out.println("ID: " + id);
    System.out.println("Department: " + department);
    System.out.println("Semester Enrolled: " + semesterEnrolled);
    System.out.println("Current Semester: " + currentSemester);
    System.out.println("Total Credit: " + totalCredit);
    System.out.println("CGPA: " + cgpa);
    System.out.println("Term GPA: " + termGpa);
    System.out.println("Max Course Limit: " + maxCourseLimit);
    //System.out.println("Probation Status: " + probationStatus);
    System.out.println("Current Courses: " + currentCourseList);
    System.out.println("Completed Courses (with grades): " + courseGradeList);
  }


  public void newSemesterUpdate(String currentSemester, HashMap<String, Double> courseGrade)
  {
    for(Map.Entry<String, Double> grade : courseGrade.entrySet())
    {
      String courseCode = grade.getKey();
      Double cgpa = grade.getValue();

      if(!currentCourseList.contains(courseCode))
      {
        System.out.println("Course not found! Please try again!");
        return;
      }
    }

    this.currentSemester = currentSemester;
    this.totalSemesterCompleted++;

    for(String courseCode : currentCourseList)
    {
      totalCredit += Main.courseMap.get(courseCode).getCredit();
    }

    addCourseGrade((courseGrade));

  }

  public void addCourseGrade(HashMap<String, Double> courseGrade)
  {
    double cgpaSum = 0;
    double creditSum = 0;

    for(Map.Entry<String, Double> grade : courseGrade.entrySet())
    {
      String courseCode = grade.getKey();
      Double cgpa = grade.getValue();

      if(currentCourseList.contains(courseCode))
      {
        if(cgpa <= 0.0)
          courseFailedStatus.put(courseCode, true);
        else
          courseGradeList.put(courseCode, cgpa);
      }

      cgpaSum += (cgpa * Main.courseMap.get(courseCode).getCredit());
      creditSum += Main.courseMap.get(courseCode).getCredit();
    }

    termGpa = cgpaSum / creditSum;
    cgpa = (cgpa + termGpa) / totalSemesterCompleted;
  }


  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getDepartment()
  {
    return department;
  }

  public void setDepartment(String department)
  {
    this.department = department;
  }

  public String getSemesterEnrolled()
  {
    return semesterEnrolled;
  }

  public void setSemesterEnrolled(String semesterEnrolled)
  {
    this.semesterEnrolled = semesterEnrolled;
  }

  public String getCurrentSemester()
  {
    return currentSemester;
  }

  public void setCurrentSemester(String currentSemester)
  {
    this.currentSemester = currentSemester;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public double getTotalCredit()
  {
    return totalCredit;
  }

  public void setTotalCredit(double totalCredit)
  {
    this.totalCredit = totalCredit;
  }

  public double getCgpa()
  {
    return cgpa;
  }

  public void setCgpa(double cgpa)
  {
    this.cgpa = cgpa;
  }

  public double getTermGpa()
  {
    return termGpa;
  }

  public void setTermGpa(double termGpa)
  {
    this.termGpa = termGpa;
  }

  public int getMaxCourseLimit()
  {
    return maxCourseLimit;
  }

  public void setMaxCourseLimit(int maxCourseLimit)
  {
    this.maxCourseLimit = maxCourseLimit;
  }

  public int getTotalSemesterCompleted()
  {
    return totalSemesterCompleted;
  }

  public void setTotalSemesterCompleted(int totalSemesterCompleted)
  {
    this.totalSemesterCompleted = totalSemesterCompleted;
  }

  /*
  public boolean isProbationStatus()
  {
    return probationStatus;
  }

  public void setProbationStatus(boolean probationStatus)
  {
    this.probationStatus = probationStatus;
  }
  */

  public List<String> getCurrentCourseList()
  {
    return currentCourseList;
  }

  public void setCurrentCourseList(List<String> currentCourseList)
  {
    this.currentCourseList = currentCourseList;
  }

  public HashMap<String, Double> getCourseGradeList()
  {
    return courseGradeList;
  }

  public void setCourseGradeList(HashMap<String, Double> courseGradeList)
  {
    this.courseGradeList = courseGradeList;
  }

  public HashMap<String, Boolean> getCourseEligibilityList()
  {
    return courseEligibilityList;
  }

  public void setCourseEligibilityList(HashMap<String, Boolean> courseEligibilityList)
  {
    this.courseEligibilityList = courseEligibilityList;
  }

  /*
  public HashMap<String, Boolean> getCourseWithdrawStatus()
  {
    return courseWithdrawStatus;
  }

  public void setCourseWithdrawStatus(HashMap<String, Boolean> courseWithdrawStatus)
  {
    this.courseWithdrawStatus = courseWithdrawStatus;
  }

  public HashMap<String, Boolean> getCourseFailedStatus()
  {
    return courseFailedStatus;
  }

  public void setCourseFailedStatus(HashMap<String, Boolean> courseFailedStatus)
  {
    this.courseFailedStatus = courseFailedStatus;
  }
  */
}