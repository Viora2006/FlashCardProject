
import java.util.ArrayList;
import java.util.Scanner;

public class FlashCardProjectUpdated{
static Scanner scanner = new Scanner(System.in);



public static void main(String[] args ){
    ArrayList<Quiz> MassFlashCardHolder = new ArrayList<>();
    while (true) {
    

    
System.out.println("Hello this is a flashcard creator/quizzer");
System.out.println("Type in the digit of the operation you want.");
System.out.println("1. Create Quiz");
System.out.println("2. View quiz");
System.out.println("3. Test yourself");
System.out.println("4. Edit existing Quizzes");
System.out.println("5. exit");

String Choice = scanner.nextLine();

if (Choice.equals("1")){
  Quiz mainquiz = CreateQuiz(MassFlashCardHolder);
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
            //here

            
    
                 }
    if (!found){                                            
            System.out.println("Quiz Not Found");


}
}

else if (Choice.equals("4")){                   // start of Main option 4
    System.out.println("Options Shown Below: ");
    System.out.println("1. Edit Title");
    System.out.println("2. Edit Questions");
    System.out.println("3. exit");

   String UserEditChoice = scanner.nextLine();

   
   
   if (UserEditChoice.equals("1")){
     System.out.println("All existing Titles Shown Below: Select Desired Title to Edit!");
   System.out.println("");
    for (Quiz q : MassFlashCardHolder){
        System.out.println(q.QuizName);
    }


   

   while (true){
   String PickTitle = scanner.nextLine();
   boolean TitleMatches = false;

   for (Quiz q: MassFlashCardHolder){
    if (q.QuizName.equalsIgnoreCase(PickTitle)){
        System.out.println("Type in the new title please!");
        String NewEditedTitle = scanner.nextLine();
        q.QuizName = NewEditedTitle;
        TitleMatches = true;
        System.out.println("Your Title has been edited!");
        break;


    }
    
}
    
    if (PickTitle.equalsIgnoreCase("exit")){
        System.out.println("Goodbye!");
        break;
        
    }

    else if (!TitleMatches) {
         System.out.println("Title does not exist, try again or type exit to leave");
       
        
    }
    if (TitleMatches){
        break;
    }
    
    
    

   

}
   }






if (UserEditChoice.equals("2")){
    System.out.println("Which Quiz do you wish to edit?");

   System.out.println("Quizzes shown below: ");
    for (Quiz q: MassFlashCardHolder){
        System.out.println(q.QuizName);

    }

    while (true){
        boolean UserEditChoiceBoolean = false;
         String UserEditTitleQuestionChoice = scanner.nextLine();
    for (Quiz q: MassFlashCardHolder){                                                            // CHECK IF THIS ENDS, THE LOOP
        if (q.QuizName.equalsIgnoreCase(UserEditTitleQuestionChoice)){
            UserEditChoiceBoolean = true;
            for (FlashCards qq: q.cards){
                System.out.println(qq);
            }
            System.out.println("Do you wish to change a question or answer?");
            System.out.println("Type Question or Answer");
            String QuestionOrAnswer = scanner.nextLine();

            if (QuestionOrAnswer.equalsIgnoreCase("Question")) {
                System.out.println("All Questions shown below: ");
                for (FlashCards qqq: q.cards){                                                  //If User Chooses Question
                System.out.println(qqq.QuizInfo);

                }
               System.out.println("Please type in the entire question you wish to edit");
               
               

               while (true){
                boolean QuestionFound = false;
                String QuestionToEdit = scanner.nextLine();


                for (FlashCards qqq: q.cards){
                    if (qqq.QuizInfo.equalsIgnoreCase(QuestionToEdit)){
                        System.out.println("What do you want to replace it with?");
                        String ReplaceQuestion = scanner.nextLine();
                        qqq.QuizInfo = ReplaceQuestion ;
                        System.out.println("Your Question has been changed!");
                        QuestionFound = true;

                    }

                    
                  }

                  if (!QuestionFound) {
                    System.out.println("Question not found, try again please or type exit to leave.");
                  }

                  if (QuestionFound){
                    break;
                  }

                  if (QuestionToEdit.equalsIgnoreCase("exit")){
                   System.out.println("Goodbye!");
                    break;

                  }
            }
            
        
        
        }

        if (QuestionOrAnswer.equalsIgnoreCase("Answer")){

                                                                                                // if user Chooses Answer
            
                System.out.println("All Answers shown below: ");
                for (FlashCards qqq: q.cards){                                                  //If User Chooses Question
                System.out.println(qqq.QuizAnswer);

                }

                System.out.println("Please type the answer you wish to change!");
                while (true){
              String AnswerToChange = scanner.nextLine();
              boolean AnswerIsFound = false;

              for (FlashCards qqq: q.cards){
                if (qqq.QuizAnswer.equalsIgnoreCase(AnswerToChange)){
                    System.out.println("Type in what you wish to replace it with.");
                   String BrandNewAnswer = scanner.nextLine();
                   qqq.QuizAnswer = BrandNewAnswer ;
                   System.out.println("Your answer has been replaced.");
                   AnswerIsFound = true;
                   break;
                }
              }
               
            if (AnswerIsFound){
                break;
            }
            else if (AnswerToChange.equalsIgnoreCase("exit")){
                break;
            }
            
            else {
                System.out.println("Answer is not found, please try again or type exit.");
            }
            
            }
            

                
                
               
               
                
            
            }
            
            
            

        }

    
        



            
        }
            
        if (!UserEditChoiceBoolean) {
            System.out.println("Invalid, try again.");
            
        }

        
       
    
    else {
        break;
    
    
}
    }
    
    




if (UserEditChoice.equals("3")){
   break;

}



}

    }





 else if (Choice.equals("5")){
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
            sb.append(card).append("\n");

        }
            return sb.toString();

    }
}

    public static Quiz CreateQuiz(ArrayList<Quiz> MassFlashCardHolder){
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
        
        String QuizName;
        while (true){
            String PreQuizName = scanner.nextLine();
        boolean Notexists = true ;
         for (Quiz quiz : MassFlashCardHolder){
           if(quiz.QuizName.equalsIgnoreCase(PreQuizName)){
                System.out.println("Name exists already, please try another.");
                Notexists = false;
                break;
           }
         }
            if (Notexists){
                QuizName = PreQuizName;
                break;

            }
        
        }

         
        Quiz CreatedTitle = new Quiz (QuizName, RecentCreatedQuiz);

         return CreatedTitle;

    }

}


















   

