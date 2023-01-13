class Faculty {
  private String name;
  private List<Course> assignedCourses;

  public Faculty(String name) {
    this.name = name;
    this.assignedCourses = new ArrayList<Course>();
  }

  public void assignCourse(Course course) {
    this.assignedCourses.add(course);
  }

  public void removeAssignment(Course course) {
    this.assignedCourses.remove(course);
  }

  public String getName() {
    return this.name;
  }

  public List<Course> getAssignedCourses() {
    return this.assignedCourses;
  }
}