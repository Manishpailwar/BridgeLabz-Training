import java.util.*;

class Student {
    String name ;
    int age ;
    int rollNo ;
    char grade ;
    Student next ;

    Student(String name, int age, int rollNo, char grade){
        this.name = name ;
        this.age = age ;
        this.rollNo = rollNo ;
        this.grade = grade ;
        this.next = null ;
    }

}

public class StudentRecord {

    Student head ;
    static Scanner sc = new Scanner(System.in);

    void addAtEnd(){
        System.out.print("Enter Name : ");
        String name = sc.nextLine();
        System.out.print("Enter Age : ");
        int age = sc.nextInt();
        System.out.print("Enter Roll No : ");
        int rollNo = sc.nextInt();
        System.out.print("Enter Grade : ");
        char grade = sc.next().charAt(0);

        Student newStudent = new Student(name, age, rollNo, grade);

        if(head == null){
            head = newStudent ;
            head.next = null ;
        }
        else{
            Student temp = head ;
            while(temp.next != null){
                temp = temp.next ;
            }
            temp.next = newStudent ;
            newStudent.next = null ;
        }
    }

    void addAtBeginning(){
        System.out.print("Enter Name : ");
        String name = sc.nextLine();
        System.out.print("Enter Age : ");
        int age = sc.nextInt();
        System.out.print("Enter Roll No : ");
        int rollNo = sc.nextInt();
        System.out.print("Enter Grade : ");
        char grade = sc.next().charAt(0);

        Student firstStudent = new Student(name, age, rollNo, grade);
        firstStudent.next = head ;
        head = firstStudent ;
    }

    void searchStudent(){
        System.out.print("Enter Roll No : ");
        int rollNo = sc.nextInt();
        Student temp = head ;
        while(temp != null){
            if(temp.rollNo == rollNo){
                System.out.println(temp.name);
                System.out.println(temp.age);
                System.out.println(temp.rollNo);
                System.out.println(temp.grade);
                return ;
            }
            temp = temp.next ;
        }
        System.out.println("Student does not Exist !");
    }

    void deleteStudent(){
        System.out.print("Enter Roll No : ");
        int rollNo = sc.nextInt();
        if(head == null){
            System.out.println("List is Empty !");
            return ;
        }

        Student temp = head ;
        if(temp.rollNo == rollNo)
            head = temp.next ;
        else{
            while(temp.next != null){
                if(temp.next.rollNo == rollNo){
                    temp.next = temp.next.next ;
                    return ;
                }
                temp = temp.next ;
            }
        }
    }

    void displayAllStudents(){
        if(head == null){
            System.out.println("List is Empty !");
            return ;
        }
        System.out.println("--- All Students : ");
        System.out.println();
        Student temp = head ;
        while(temp != null){
            System.out.println("Name : "+temp.name);
            System.out.println("Age : "+temp.name);
            System.out.println("RollNo : "+temp.rollNo);
            System.out.println("Grade : "+temp.grade);
            System.out.println();
            temp = temp.next ;
        }
    }

    void updateGrade(){
        System.out.print("Enter Roll No : ");
        int rollNo = sc.nextInt();
        System.out.print("Enter New Grade : ");
        char grade = sc.next().charAt(0);
        Student temp = head ;
        while(temp != null){
            if(temp.rollNo == rollNo){
                temp.grade = grade ;
                System.out.println("--- Student Updated Successfully ! ---");
                System.out.println("Name : "+temp.name);
                System.out.println("Age : "+temp.age);
                System.out.println("RollNo : "+temp.rollNo);
                System.out.println("New Grade : "+temp.grade);
                System.out.println();
                return ;
            }
            temp = temp.next ;
        }
        System.out.println("Student does not Exist !");
    }


    public static void main(String[] args) {
        StudentRecord studentRecord = new StudentRecord();
      
        while(true){
        System.out.println();
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Update Grade");
        System.out.println("6. Exit");
        System.out.println();
        System.out.print("Enter Your Choice : ");
        int choice = sc.nextInt();
        System.out.println();

        switch (choice) {
            case 1: System.out.println("1. Add At The End ");
                System.out.println("2. Add At The Beginning");
                System.out.print("Enter Your Choice : ");
                int position = sc.nextInt();
                sc.nextLine();
                switch(position){
                    case 1: studentRecord.addAtEnd();
                        break;
                    case 2: studentRecord.addAtBeginning();
                    break;
                }
                break;

            case 2 : studentRecord.displayAllStudents();
                break;
            
            case 3 : studentRecord.searchStudent();
                break;
            
            case 4 : studentRecord.deleteStudent();
                break;
            
            case 5 : studentRecord.updateGrade();
                break;
                
            case 6 : return ;

            default: System.out.println("Invalid Choice !");
                break;
        }
        }
    }
}
