import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class Initialize
{
  boolean databaseAvailable;

  public void storeDatabase()
  {
    String directory = "database/";


    File dir = new File(directory);

    if( (dir.exists()) && (dir.isDirectory()))
      deleteDirectory(dir);

    dir.mkdirs();

    storeCourses();
    storeFaculty();
    storeStudents();
  }

  public void storeCourses()
  {
    for(Map.Entry<String, Course> course : Main.courseMap.entrySet())
    {
      String courseCode = course.getKey();
      Course courseObj = course.getValue();

      String courseDirectory = "database/courseInfo/" + courseCode + "/";
      File courseDir = new File(courseDirectory);

      String fileName = courseCode + ".txt";
      File file = new File(courseDirectory + fileName);

      try
      {
        courseDir.mkdirs();
        file.createNewFile();
        PrintWriter input = new PrintWriter(file);

        input.print(courseObj.getCourseCode() + ",");
        input.print(courseObj.getPrerequisite() + ",");
        input.print(courseObj.getCredit() + ",");
        input.print(courseObj.getSectionCount() + ",");
        input.println();

        for(String department : courseObj.getDepartmentList())
          input.print(department + ",");
        input.println();

        for(String faculty : courseObj.getFacultyList())
          input.print(faculty + ",");
        input.println();

        for(String enrolledId : courseObj.getEnrolledIdList())
          input.print(enrolledId + ",");
        input.println();

        for(int i = 0; i < courseObj.getSectionList().size(); i++)
          storeSection(courseObj.getSectionList().get(i), courseDirectory);

        input.close();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
    }
  }

  public void storeSection(Section section, String courseDirectory)
  {
    String fileNameSection = "Section" + section.getSectionNo() + ".txt";
    File fileSection = new File(courseDirectory + fileNameSection);

    try
    {
      fileSection.createNewFile();
      PrintWriter inputSection = new PrintWriter(fileSection);

      inputSection.print(section.getTime24() + ",");
      inputSection.print(section.getWeekDate() + ",");
      inputSection.print(section.getRoom() + ",");
      inputSection.print(section.getSectionNo() + ",");
      inputSection.print(section.getCapacity() + ",");
      inputSection.print(section.getEnrolled() + ",");
      inputSection.print(section.getCourseCode() + ",");
      inputSection.print(section.getFacultyName() + ",");
      inputSection.println();

      for(String enrolledId : section.getEnrolledIdList())
        inputSection.print(enrolledId + ",");
      inputSection.println();

      inputSection.close();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  public void storeFaculty()
  {
    int i = 1;

    for(Map.Entry<String, Faculty> faculty : Main.facultyMap.entrySet())
    {
      String facultyKey = faculty.getKey();
      Faculty facultyValue = faculty.getValue();

      String facultyDirectory = "database/facultyInfo/";
      File facultyDir = new File(facultyDirectory);

      String fileName = "faculty_" + i + ".txt";
      File file = new File(facultyDirectory + fileName);

      try
      {
        facultyDir.mkdirs();
        file.createNewFile();
        PrintWriter input = new PrintWriter(file);

        input.print(facultyValue.getName() + ",");
        input.print(facultyValue.getDepartment() + ",");
        input.println();

        for(Map.Entry<String, List<Integer>> courseList : facultyValue.getCourseList().entrySet())
        {
          String courseCode = courseList.getKey();
          List<Integer> sectionList = courseList.getValue();

          input.print(courseCode + ",");
          for(Integer sectionNo : sectionList)
          {
            input.print(sectionNo + ",");
          }
          input.println();
        }

        input.close();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }

      i++;
    }
  }

  public void storeStudents()
  {
    for(Map.Entry<String, Student> student : Main.studentMap.entrySet())
    {
      String studentKey = student.getKey();
      Student studentValue = student.getValue();

      String studentDirectory = "database/studentInfo/";
      File studentDir = new File(studentDirectory);

      String fileName = studentValue.getId() + ".txt";
      File file = new File(studentDirectory + fileName);

      try
      {
        studentDir.mkdirs();
        file.createNewFile();
        PrintWriter input = new PrintWriter(file);

        input.print(studentValue.getName() + ",");
        input.print(studentValue.getId() + ",");
        input.print(studentValue.getDepartment() + ",");
        input.print(studentValue.getSemesterEnrolled() + ",");
        input.print(studentValue.getCurrentSemester() + ",");
        input.print(studentValue.getPassword() + ",");
        input.print(studentValue.getTotalCredit() + ",");
        input.print(studentValue.getCgpa() + ",");
        input.print(studentValue.getTermGpa() + ",");
        input.print(studentValue.getMaxCourseLimit() + ",");
        input.print(studentValue.getTotalSemesterCompleted() + ",");
        input.println();

        for(String currentCourse : studentValue.getCurrentCourseList())
          input.print(currentCourse + ",");
        input.println();

        for(Map.Entry<String, Double> courseGradeList : studentValue.getCourseGradeList().entrySet())
        {
          String courseCode = courseGradeList.getKey();
          Double cgpa = courseGradeList.getValue();

          input.print(courseCode + ",");
          input.print(cgpa + ",");
          input.println();
        }

        input.close();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
    }
  }

  public void loadDatabase()
  {
    String directory = "database/";

    File dir = new File(directory);

    if( (dir.exists()) && (dir.isDirectory()))
    {
      loadCourses();
      loadFaculty();
      loadStudents();
    }
    else
      databaseAvailable = false;
  }

  public void loadCourses()
  {
    String courseDirectory = "database/courseInfo/";
    File courseDir = new File(courseDirectory);
    HashMap<String, Course> courseMap = new HashMap<>();

    if(courseDir.exists() && courseDir.isDirectory())
    {
      File[] directoryList = courseDir.listFiles();

      for(File dir : directoryList)
      {
        String courseCodeDirectory = dir.getName() + "/";
        File courseCodeDir = new File(courseCodeDirectory);

        if (courseCodeDir.exists() && courseCodeDir.isDirectory())
        {
          File[] fileList = courseCodeDir.listFiles();

          Course course;
          String courseCode = ""; // format: MAT104
          String prerequisite = "";
          double credit = 0.0;
          int sectionCount = 0;
          List<String> departmentList = new ArrayList<>();
          List<String> facultyList = new ArrayList<>();
          List<String> enrolledIdList = new ArrayList<>();
          List<Section> sectionList = new ArrayList<>();

          String str;
          String[] slice;

          for(File file : fileList)
          {
            if(file.getName().contains("Section"))
            {
              sectionList.add(loadSections(file));
            }
            else
            {
              try
              {
                Scanner input = new Scanner(file);

                str = input.nextLine();
                slice = str.split("[,]+");
                courseCode = slice[0];
                prerequisite = slice[1];
                credit = Double.parseDouble(slice[2]);
                sectionCount = Integer.parseInt(slice[3]);

                if (input.hasNextLine())
                {
                  str = input.nextLine();
                  slice = str.split("[,]+");

                  Collections.addAll(departmentList, slice);
                }
                if (input.hasNextLine())
                {
                  str = input.nextLine();
                  slice = str.split("[,]+");

                  Collections.addAll(facultyList, slice);
                }
                if (input.hasNextLine())
                {
                  str = input.nextLine();
                  slice = str.split("[,]+");

                  Collections.addAll(enrolledIdList, slice);
                }
              } catch (Exception e)
              {
                e.printStackTrace();
              }
            }
          }

          course = new Course(departmentList, courseCode, prerequisite, credit);
          course.setSectionCount(sectionCount);
          courseMap.put(courseCode, course);
        }
      }
      Main.courseMap.putAll(courseMap);
    }
  }

  public Section loadSections(File file)
  {
    Section section;
    String time24 = "";
    String weekDate = "";
    int room = 0;
    int sectionNo = 0;
    int capacity = 0;
    int enrolled = 0;
    String courseCode = "";
    String facultyName = "";
    List<String> enrolledIdList = new ArrayList<>();

    String str = "";
    String[] slice;

    try
    {
      Scanner input = new Scanner(file);

      str = input.nextLine();
      slice = str.split("[,]+");
      time24 = slice[0];
      weekDate = slice[1];
      room = Integer.parseInt(slice[2]);
      sectionNo = Integer.parseInt(slice[3]);
      capacity = Integer.parseInt(slice[4]);
      enrolled = Integer.parseInt(slice[5]);
      courseCode = slice[6];
      facultyName = slice[7];

      if (input.hasNextLine())
      {
        str = input.nextLine();
        slice = str.split("[,]+");

        Collections.addAll(enrolledIdList, slice);
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

    section = new Section(courseCode, time24, weekDate, room, sectionNo, capacity);
    section.setEnrolledIdList(enrolledIdList);

    return section;
  }

  public void loadFaculty()
  {
    String facultyDirectory = "database/facultyInfo/";
    File facultyDir = new File(facultyDirectory);
    HashMap<String, Faculty> facultyMap = new HashMap<>();

    if(facultyDir.exists() && facultyDir.isDirectory())
    {
      File[] fileList = facultyDir.listFiles();

      for(File file : fileList)
      {
        Faculty faculty;
        String name = "";
        String department = "";
        HashMap<String, List<Integer>> courseList = new HashMap<>();

        String str = "";
        String[] slice;

        try
        {
          Scanner input = new Scanner(file);

          if(input.hasNextLine())
          {
            str = input.nextLine();
            slice = str.split("[,]+");

            name = slice[0];
            department = slice[1];
          }

          if (input.hasNextLine())
          {
            str = input.nextLine();
            slice = str.split("[,]+");
            String courseCode = slice[0];
            List<Integer> sectionList = new ArrayList<>();

            for(int i = 1; i < slice.length; i++)
            {
              sectionList.add(Integer.parseInt(slice[i]));
            }

            courseList.put(courseCode, sectionList);
          }
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }

        faculty = new Faculty(name, department);
        faculty.setCourseList(courseList);

        facultyMap.put(name, faculty);
      }
    }
    Main.facultyMap.putAll(facultyMap);
  }

  public void loadStudents()
  {
    String studentDirectory = "database/studentInfo/";
    File studentDir = new File(studentDirectory);
    HashMap<String, Student> studentMap = new HashMap<>();

    if(studentDir.exists() && studentDir.isDirectory())
    {
      File[] fileList = studentDir.listFiles();

      for(File file : fileList)
      {
        Student student;
        String name = "";
        String id = "";
        String department = "";
        String semesterEnrolled = "";
        String currentSemester = "";
        String password = "";
        double totalCredit = 0.0;
        double cgpa = 0.0;
        double termGpa = 0.0;
        int maxCourseLimit = 0;
        int totalSemesterCompleted = 0;
        List<String> currentCourseList = new ArrayList<>(); // courseCode
        HashMap<String, Double> courseGradeList = new HashMap<>(); // <courseCode, CGPA>
        HashMap<String, Boolean> courseEligibilityList = new HashMap<>();

        String str = "";
        String[] slice;

        try
        {
          Scanner input = new Scanner(file);

          if(input.hasNextLine())
          {
            str = input.nextLine();
            slice = str.split("[,]+");

            name = slice[0];
            id = slice[2];
            department = slice[3];
            semesterEnrolled = slice[4];
            currentSemester = slice[5];
            password = slice[6];
            totalCredit = Double.parseDouble(slice[7]);
            cgpa = Double.parseDouble(slice[8]);
            termGpa = Double.parseDouble(slice[9]);
            maxCourseLimit = Integer.parseInt(slice[10]);
            totalSemesterCompleted = Integer.parseInt(slice[11]);
          }
          if (input.hasNextLine())
          {
            str = input.nextLine();
            slice = str.split("[,]+");

            Collections.addAll(currentCourseList, slice);
          }

          if (input.hasNextLine())
          {
            str = input.nextLine();
            slice = str.split("[,]+");

            String courseCode = slice[0];
            Double cgpa_temp = Double.parseDouble(slice[1]);

            courseGradeList.put(courseCode, cgpa_temp);
          }
          if (input.hasNextLine())
          {
            str = input.nextLine();
            slice = str.split("[,]+");

            String courseCode = slice[0];
            boolean eligible = Boolean.parseBoolean(slice[1]);

            courseEligibilityList.put(courseCode, eligible);
          }
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }

        student = new Student(name, id, department, semesterEnrolled, password);
        student.setCourseGradeList(courseGradeList);
        student.setCourseEligibilityList(courseEligibilityList);
        student.setCurrentSemester(currentSemester);
        student.setTotalCredit(totalCredit);
        student.setCgpa(cgpa);
        student.setTermGpa(termGpa);
        student.setMaxCourseLimit((maxCourseLimit));
        student.setTotalSemesterCompleted(totalSemesterCompleted);

        studentMap.put(student.getId(), student);
      }
    }
    Main.studentMap.putAll(studentMap);
  }

  public void deleteDirectory(File directory)
  {
    File[] files = directory.listFiles();
    if (files != null)
    {
      for (File f : files)
      {
        if (f.isDirectory())
        {
          deleteDirectory(f);
        }
        else
        {
          f.delete();
        }
      }
    }
    directory.delete();
  }
}