import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

class Main
{
  private CourseManager courseManager;
  private CourseEnrollment courseEnrollment;

  // HashMap to store courses, where the key is the courseCode and the value is the course object
  static HashMap<String, Course> courseMap = new HashMap<>();
  // HashMap to store faculty, where the key is the faculty name and the value is the faculty object
  static HashMap<String, Faculty> facultyMap = new HashMap<>();

  public static void main(String[] args)
  {
    Main main = new Main();
    main.initialize();
    main.run();
  }

  public void initialize()
  {
    courseManager = new CourseManager();
    courseEnrollment = new CourseEnrollment();

    loadData();
  }

  public void run()
  {
    /*
    Scanner input = new Scanner(System.in);
    boolean running = true;

    while (running) {
      System.out.println("1. Load data from file");
      System.out.println("2. Save data to file");
      System.out.println("3. Add course");
      System.out.println("4. Remove course");
      System.out.println("5. Update course");
      System.out.println("6. Add student");
      System.out.println("7. Remove student");
      System.out.println("8. Update student");
      System.out.println("9. Exit");

      int choice = input.nextInt();

      switch (choice) {
        case 1:
          loadData();
          break;
        case 2:
          saveData();
          break;
        case 3:
          addCourse();
          break;
        case 4:
          removeCourse();
          break;
        case 5:
          updateCourse();
          break;
        case 6:
          addStudent();
          break;
        case 7:
          removeStudent();
          break;
        case 8:
          updateStudent();
          break;
        case 9:
          running = false;
          break;
        default:
          System.out.println("Invalid choice");
      }
    }

    input.close();
     */
  }

  public void loadData()
  {
    try
    {
      FileInputStream fis = new FileInputStream("courses.dat");
      ObjectInputStream ois = new ObjectInputStream(fis);

      courseManager = (CourseManager) ois.readObject();

      fis = new FileInputStream("enrollments.dat");
      ois = new ObjectInputStream(fis);

      courseEnrollment = (CourseEnrollment) ois.readObject();

      ois.close();
      fis.close();

      System.out.println("Data loaded successfully");
    }
    catch (Exception e)
    {
      System.out.println("Error loading data: " + e.getMessage());
    }
  }

  public void saveData()
  {
    try
    {
      FileOutputStream fos = new FileOutputStream("courses.dat");
      ObjectOutputStream oos = new ObjectOutputStream(fos);

      oos.writeObject(courseManager);

      fos = new FileOutputStream("enrollments.dat");
      oos = new ObjectOutputStream(fos);

      oos.writeObject(courseEnrollment);

      oos.close();
      fos.close();

      System.out.println("Data saved successfully");
    }
    catch (Exception e)
    {
      System.out.println("Error saving data: " + e.getMessage());
    }
  }
}