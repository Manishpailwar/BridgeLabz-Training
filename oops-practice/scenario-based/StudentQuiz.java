import java.util.*;
public class StudentQuiz {

    public static int calculateScore(String[] studentScore, String[] correctScore){
        int score = 0 ;
        for(int i=0;i<10;i++){
            if(studentScore[i].equalsIgnoreCase(correctScore[i]))
                score++;
        }
        return score ;
    }

    public static void feedBack(String[] studentAnswers, String[] correctAnswers){
        for(int i=0;i<10;i++){
            if(studentAnswers[i].equalsIgnoreCase(correctAnswers[i])){
                System.out.println("Question "+(i+1)+" : Correct !");
                System.out.println();
            }
            else{
                System.out.println("Question "+(i+1)+" : Incorrect ! ");
                System.out.println("Correct Option is : "+correctAnswers[i]);
                System.out.println();
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Welcome to Student Quiz Grader !");
        String[] questions = new String[]{"1. What is the keyword used to define a class in Java?","2. Which method is the entry point of a Java program?","3. What symbol is used to end a statement in Java?","4. Which data type is used to store whole numbers in Java?","5. What keyword is used to create an object in Java?","6. Which operator is used to compare two values for equality?","7. What is the size of an int data type in Java (in bytes)?","8. Which keyword is used to inherit a class in Java?","9.What is the default value of a boolean variable in Java?","10. Which loop is guaranteed to execute at least once?"};
        String[] options = new String[]{"A) define\n" + "B) class\n" + "C) structure\n" + "D) object","A) start()\n" +"B) run()\n" +"C) main()\n" + "D) init()","A) :\n" +"B) .\n" + "C) ;\n" +"D) ,","A) float\n" +"B) double\n" +"C) int\n" +"D) char","A) create\n" +"B) object\n" +"C) new\n" +"D) make","A) =\n" +"B) !=\n" +"C) equals\n" +"D) ==","A) 2 bytes\n" +"B) 4 bytes\n" +"C) 8 bytes\n" +"D) Depends on system","A) implement\n" +"B) inherit\n" +"C) extends\n" +"D) super","A) true\n" +"B) false\n" +"C) 0\n" +"D) null","A) for\n" +"B) while\n" +"C) foreach\n" +"D) do-while"};
        String[] correctAnswers = new String[]{"B","C","C","C","C","D","B","C","B","D"};
        String[] studentAnswers = new String[10];
        for(int i=0;i<10;i++){
            System.out.println(questions[i]);
            System.out.println(options[i]);
            studentAnswers[i] = sc.next();
        }
        int score = calculateScore(studentAnswers,correctAnswers);

        feedBack(studentAnswers,correctAnswers);

        System.out.println("Your Score is : "+score);
        System.out.println("Percentage is : "+(score*100/10));
        if(score < 5)
            System.out.println("You're Fail !");
        else 
            System.out.println("You're Pass !");

        sc.close();
    }
}
