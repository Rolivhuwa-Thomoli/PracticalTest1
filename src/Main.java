import java.util.Scanner;
class Student {
    private String name;
    private String surname;
    private int studentNumber;
    Student(){}
    Student(String name, String surname, int studentNumber){
        this.name = name;
        this.surname = surname;
        this.studentNumber = studentNumber;
    }//end constructor
    public String getName(){
        return this.name;
    }
    public String getSurname(){
        return this.surname;
    }
    public int getStudentNumber(){
        return this.studentNumber;
    }

}


public class Main {
    public static String selectElective(int num){
        return switch(num){
            case 1-> "1. Chemistry";
            case 2-> "2. Geology";
            case 3-> "3. Geography";
            case 4-> "4. Geographic Information System";
            default -> "Error: unexpected input";
        };
    }
    public static String selectMajor(int num){
        return switch(num){
            case 1-> "1. Computer Science";
            case 2-> "2. Mathematics";
            case 3-> "3. Statistics";
            case 4-> "4. Physics";
            default -> "Error: unexpected input";
        };
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str1;
        String str2;
        boolean continueSwitch = true, continueSwitch2 = true;
        int num ,majorCourse1, majorCourse2, electiveCourse;
        double ave;
        System.out.println("Enter student name: ");
        str1 = sc.next();
        System.out.println("Enter student surname: ");
        str2 = sc.next();
        System.out.println("Enter student number: ");
        num = sc.nextInt();

        Student obj1 = new Student(str1,str2,num);
        System.out.println("Enter student Final High School Average: ");
        ave = sc.nextDouble();
        if(ave < 60.0)
        {System.out.println("Not eligible to register");
            continueSwitch2 = false;}
        do {
            continueSwitch =true;
            if (continueSwitch && continueSwitch2) {
                System.out.println("Choose a Major by entering a number :");
                for (int i = 1; i <= 4; i++)
                    System.out.println(selectMajor(i));
            }
            majorCourse1 = sc.nextInt();

            if (majorCourse1 < 1 || majorCourse1 > 4) {
                System.out.println(selectMajor(majorCourse1));
                continueSwitch = false;
            }
        }while(continueSwitch2==true && continueSwitch==false);

        do {
            continueSwitch = true;
            if (continueSwitch && continueSwitch2) {
                System.out.println("Choose a second Major by entering a number :");
                for (int i = 1; i <= 4; i++) {
                    if (i == majorCourse1)
                        continue;
                    System.out.println(selectMajor(i));
                }
            }
            majorCourse2 = sc.nextInt();
            if (majorCourse2 < 1 || majorCourse2 > 4) {
                System.out.println(selectMajor(majorCourse2));
                continueSwitch = false;
            }
        }while(continueSwitch2==true && continueSwitch==false);


        if(continueSwitch) {
            System.out.println("Choose one elective course by entering a number :");
            for (int i = 1; i <= 4; i++)
                System.out.println(selectElective(i));
        }

            electiveCourse = sc.nextInt();
        if(electiveCourse< 1 || electiveCourse >4) {
            System.out.println(selectMajor(majorCourse2));
            continueSwitch = false;
        }
        if(continueSwitch){//print proof of Registation
            System.out.printf("%n%s%n%s%s%n%s%s%n%s%d%n%s%n%s%s%s%n%s%s%n","PROOF OF REGISRATION",
                              "STUDENT NAME : ",obj1.getName(),
                              "STUDENT SURNAME: ", obj1.getSurname(),
                              "STUDENT NUMBER: ", obj1.getStudentNumber(),
                              "Courses Registered",
                              "Majors : ",selectMajor(majorCourse1),selectMajor(majorCourse2),
                              "Electives: ",selectElective(electiveCourse));

        }







    }
}
