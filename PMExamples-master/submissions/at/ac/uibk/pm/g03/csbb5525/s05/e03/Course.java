package at.ac.uibk.pm.g03.csbb5525.s05.e03;

import java.util.Arrays;
import java.util.Objects;

public class Course {
    /*
    Hier für mich unklar, ob ich Course als abstrakte Klasse gestalten hätte sollen, oder
    ob auch Objekte von Course erstellbar sein sollen.
     */



    private String name;
    private int maxParticipants;    //could be just a getter with enrolledStudents.length
    private final Student[] enrolledStudents;
    //maybe a Container(without duplicates) would have been better here, but instructions ask for Array.
    private int index = 0;
    private boolean enrollmentOpen = false;
    private Lecturer lecturer;

    public Course(String name, int maxParticipants, Lecturer lecturer) {
        this.name = name;
        this.maxParticipants = maxParticipants;
        enrolledStudents = new Student[maxParticipants];
        this.lecturer = lecturer;
    }

    public void addStudent(Student student) throws OutOfSpaceException, AlreadyEnrolledException, EnrollmentClosedException {
        if (student == null) {
            throw new NullPointerException("student is null");
        }
        if(enrollmentOpen == false) {
            throw new EnrollmentClosedException("Currently the enrollment-window is not open");
        }
        if (index >= enrolledStudents.length) {
            throw new OutOfSpaceException("Maximum number of participants reached");
        }
        if (Arrays.asList(enrolledStudents)
                  .contains(student)) {
            throw new AlreadyEnrolledException("You are already part of this course");
        }
        enrolledStudents[index] = student;
        index++;
    }

    public void setEnrollmentStatus(boolean enrollmentOpen, Lecturer lecturer) {
        if(this.lecturer.equals(lecturer)) {
            this.enrollmentOpen = enrollmentOpen;
        }
        else{
            System.out.println("You do not have permission to change enrollment status");
        }

    }

    /*
     Lehrveranstaltungsleiter:innen sollen die vorhandenen Lehrveranstaltungen bearbeiten können.
     Daher einige getter und setter die meiner Ansicht nach Sinn ergeben.
     */

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void printEnrolledStudents() {
        for (Student student : enrolledStudents){
            System.out.println(student.toString());
        }
    }


    public void printLecturer() {
        System.out.println(lecturer.toString());
    }
    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return maxParticipants == course.maxParticipants && Objects.equals(name, course.name) && Objects.equals(lecturer, course.lecturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, maxParticipants, lecturer);
    }
}
