class Admin {
    private String password;
    private CourseManager courseManager = new CourseManager();
    private CourseEnrollment courseEnrollment = new CourseEnrollment();

    public Admin(String password) {
        this.password = password;
    }

    public void addCourse() {
        courseManager.addCourse();
    }

    public void removeCourse(String courseCode) {
        courseManager.removeCourse(courseCode);
    }

    public void updateCourse(String courseCode) {
        courseManager.updateCourse(courseCode);
    }

    public void addStudent() {
        courseEnrollment.addStudent();
    }

    public void removeStudent(String studentId) {
        courseEnrollment.removeStudent(studentId);
    }

    public void updateStudent(String studentId) {
        courseEnrollment.updateStudent(studentId);
    }

    public void addFaculty() {
        courseManager.addFaculty();
    }

    public void removeFaculty(String facultyName) {
        courseManager.removeFaculty(facultyName);
    }

    public void updateFaculty(String facultyName) {
        courseManager.updateFaculty(facultyName);
    }

    public void assignFacultyToCourse(String courseCode, String facultyName) {
        courseManager.assignFacultyToCourse(courseCode, facultyName);
    }

    public void unassignFacultyFromCourse(String courseCode, String facultyName) {
        courseManager.unassignFacultyFromCourse(courseCode, facultyName);
    }
}