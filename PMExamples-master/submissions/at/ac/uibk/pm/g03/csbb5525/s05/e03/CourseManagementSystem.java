package at.ac.uibk.pm.g03.csbb5525.s05.e03;

import java.util.Arrays;

public class CourseManagementSystem {
    private final Course[] courses = new Course[2];   //again a Container might be better than an Array here.
    private int index = 0;


    public void addCourse(Course course) throws OutOfSpaceException, AlreadyEnrolledException {
        if (course == null) {
            throw new NullPointerException("course is null");
        }
        if (index >= courses.length) {
            throw new OutOfSpaceException("Maximum number of courses reached");
        }
        if (Arrays.asList(courses)
                  .contains(course)) {
            throw new AlreadyEnrolledException("Course already exists");
        }
        courses[index] = course;
        index++;

    }

    public void enrollStudentInCourse(Student student, Course course) throws AlreadyEnrolledException, OutOfSpaceException, EnrollmentClosedException {
        if (course == null) {
            throw new NullPointerException("course is null");
        }
        if(student == null) {
            throw new NullPointerException("student is null");
        }
        course.addStudent(student);

    }

}
