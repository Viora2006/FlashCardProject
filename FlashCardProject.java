
import java.util.ArrayList;
import java.util.Scanner;

public class FlashCardProject{
static Scanner scanner = new Scanner(System.in);



public static void main(String[] args ){
    ArrayList<Quiz> MassFlashCardHolder = new ArrayList<>();
    while (true) {
    

    
System.out.println("Hello this is a flashcard creator/quizzer");
System.out.println("Type in the digit of the operation you want.");
System.out.println("1. Create Quiz");
System.out.println("2. View quiz");
System.out.println("3. Test yourself");
System.out.println("4 exit");

String Choice = scanner.nextLine();

if (Choice.equals("1")){
  Quiz mainquiz = CreateQuiz();
  MassFlashCardHolder.add(mainquiz);
  System.out.println("Your Quiz has been created!");
  


   
    

}

else if (Choice.equals("2")){

    for (Quiz q : MassFlashCardHolder){
    System.out.println(q);
    }

}

else if (Choice.equals("3")){

    System.out.println("Please enter the title of the quiz you wish to test on!");
    String UserQuizChoice = scanner.nextLine();
    boolean found = false;

    for (Quiz q : MassFlashCardHolder){
        if (q.QuizName.equalsIgnoreCase(UserQuizChoice)){
         found = true;
         System.out.println("Starting Quiz Named: " + q.QuizName);
         for (FlashCards card : q.cards){
            System.out.println("Question: " + card.QuizInfo);
            System.out.println("Your Answer: ");
            String UserAnswer = scanner.nextLine();
            if (UserAnswer.equalsIgnoreCase(card.QuizAnswer)){

                System.out.println("Correct!");
            }
            else{
                System.out.println("Wrong! The correct answer is " + card.QuizAnswer);
            }


         }

            break;
        }
        if (!found){
            System.out.println("Quiz Not Found");
            
        }
    }


}





else if (Choice.equals("4")){
    System.out.println("Goodbye!");
    break;
}

else {
    System.out.println("Invalid, try again.");
    
}
}
}


public static class FlashCards {

String QuizInfo;
String QuizAnswer;



public FlashCards(String QuizInfo, String QuizAnswer){
    this.QuizInfo = QuizInfo;
    this.QuizAnswer = QuizAnswer;
}
public String toString (){
    return "Q: " + QuizInfo + " A: " + QuizAnswer ;
}

}

public static class Quiz {  
    String QuizName;
    ArrayList<FlashCards> cards;


    public Quiz (String QuizName, ArrayList<FlashCards> cards){
        this.QuizName = QuizName;
        this.cards = cards;
    
    }


    public String toString (){
        StringBuilder sb = new StringBuilder();
        sb.append(QuizName).append(":\n");
        for (FlashCards card : cards ){
            sb.append(card).append(":\n");

        }
            return sb.toString();

    }
}

    public static Quiz CreateQuiz(){
        System.out.println("Lets begin creating your quiz!");
        ArrayList <String> RecentQuiz = new ArrayList<>();
        ArrayList <FlashCards> RecentCreatedQuiz = new ArrayList<>();
        for ( int i = 0; i < 100 ; i++){
           
        
            System.out.println("Please enter the desired Question to add or type exit to leave when your done.");
            String RecentQuestion = scanner.nextLine();
            if (RecentQuestion.equalsIgnoreCase("exit")){
                break;
            }
            else{
            

            System.out.println("Please enter the answer for the question");
            String RecentAnswer = scanner.nextLine();
            FlashCards LoopedQuiz = new FlashCards (RecentQuestion, RecentAnswer);
            RecentCreatedQuiz.add(LoopedQuiz);

           
            

            }
            
           

        }

        System.out.println("Please Enter the title of the Quiz.");
        String QuizName = scanner.nextLine();
        Quiz CreatedTitle = new Quiz (QuizName, RecentCreatedQuiz);

         return CreatedTitle;

    }

}






    











   

