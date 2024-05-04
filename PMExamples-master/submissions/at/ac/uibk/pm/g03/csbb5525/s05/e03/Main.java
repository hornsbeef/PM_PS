package at.ac.uibk.pm.g03.csbb5525.s05.e03;

public class Main {
    public static void main(String[] args) {
        /*
        Stellen Sie sicher, dass nötige get- und set-Methoden sowie Konstruktoren für die einzelnen Klas-
        sen erstellt werden.
        -> Habe nicht für jede Variable einen getter / setter erstellt, weil ich damit ja die Kapselung
        umgehen würde. -> Nur für die (von mir) als sinnvoll erachteteten Variablen einen getter/setter erstellt.
         */



        Lecturer lecturerA = new Lecturer("lecturer", "A");
        Student studentA = new Student("student", "A");
        Student studentB = new Student("student", "B");
        Student studentC = new Student("student", "C");


        Course courseA = new Seminar("A-Course", 2, lecturerA);
        CourseManagementSystem managementSystem = new CourseManagementSystem();

        Course courseALecture = new Lecture("A-Course-Lecture", 2, lecturerA);


        /*
        Sorgen Sie dafür, dass jede Exception mindestens einmal geworfen wird.
        Bei Fehlern soll eine entsprechende Ausgabe auf der Konsole erfolgen.
        -> mir war nicht klar, ob ein e.printStackTrace(); auch gewünscht ist, hab es daher einmal hinzugefügt.
         */


        try{
            managementSystem.addCourse(courseA);
            managementSystem.addCourse(courseA);    //forcing AlreadyEnrolledException
        } catch (AlreadyEnrolledException |OutOfSpaceException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        separator();

        try{
            managementSystem.enrollStudentInCourse(studentA, courseA);   //forcing EnrollmentClosedException
        }catch(AlreadyEnrolledException| OutOfSpaceException | EnrollmentClosedException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        separator();
        courseA.setEnrollmentStatus(true, lecturerA);

        try{
            managementSystem.enrollStudentInCourse(studentA, courseA);
            managementSystem.enrollStudentInCourse(studentA, courseA);   //forcing AllreadyEnrolledException for Student
        }catch(AlreadyEnrolledException| OutOfSpaceException | EnrollmentClosedException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        separator();

        try{
            managementSystem.enrollStudentInCourse(studentB, courseA);
            managementSystem.enrollStudentInCourse(studentC, courseA);  //forcing OutOfSpaceException
        }catch(AlreadyEnrolledException| OutOfSpaceException | EnrollmentClosedException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        separator();

        System.out.println("Max participants: "+courseA.getMaxParticipants());
        courseA.printLecturer();
        courseA.printEnrolledStudents();




    }

    private static void separator(){
        System.out.println("-".repeat(20));
    }


}
