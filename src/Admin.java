class Admin {
    private String password;

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

    public void assignFaculty(String courseCode, String facultyName) {
        courseManager.assignFaculty(courseCode, facultyName);
    }

    public void removeFacultyAssignment(String courseCode, String facultyName) {
        courseManager.removeFacultyAssignment(courseCode, facultyName);
    }
}