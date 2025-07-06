
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FlashCardProjectUpdated{
static Scanner scanner = new Scanner(System.in);



public static void main(String[] args ){
    ArrayList<Quiz> MassFlashCardHolder = new ArrayList<>();
    createUsersTable();
    testDatabaseConnection();

  int userId = -1;
  
System.out.println("1. Register"); 
  System.out.println("2. Login");     
  System.out.println("3. Exit");
  String AccountChoice = scanner.nextLine();


  if (AccountChoice.equals("1")){
    RegisterAccount();
  }
  else if (AccountChoice.equals("2")){
     userId = loginUser();
    if (userId == -1) return; 
  } 

  else {
    return;
  }
  
  MassFlashCardHolder = loadUserQuizzes(userId);
  
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
  saveQuizToDatabase(mainquiz, userId);
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

        else if (QuestionOrAnswer.equalsIgnoreCase("Answer")){        //most recent change

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

            else {
                System.out.println("Invalid");
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






   public static boolean testDatabaseConnection() {
    String url = "jdbc:sqlite:C:/Users/tyler/Downloads/QuizAppAttempt/quizAppAttempt.db";
    try (Connection conn = DriverManager.getConnection(url)) {
        if (conn != null) {
            System.out.println("Successfully connected to SQLite database!");
            return true;
        }
    } catch (SQLException e) {
        System.out.println("Connection failed!");
        e.printStackTrace();
    }
    return false;
}

public static void createUsersTable() {
    String url = "jdbc:sqlite:C:/Users/tyler/Downloads/QuizAppAttempt/quizAppAttempt.db";

    // SQL statement as a Java String
    String createUsersTable = "CREATE TABLE IF NOT EXISTS users ("
               + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
               + "username TEXT NOT NULL UNIQUE,"
               + "password TEXT NOT NULL"
               + ");";

    
    String createQuizzesTable = "CREATE TABLE IF NOT EXISTS quizzes ("
                                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                                + "user_id INTEGER NOT NULL,"
                                + "title TEXT NOT NULL,"
                                + "FOREIGN KEY(user_id) REFERENCES users(id)"
                                + ");";
    String createFlashcardsTable = "CREATE TABLE IF NOT EXISTS flashcards ("
                                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                                + "quiz_id INTEGER NOT NULL,"
                                +"question TEXT NOT NULL,"
                                + "answer TEXT NOT NULL,"
                                +"FOREIGN KEY(quiz_id) REFERENCES quizzes(id)"
                                +");";
    
    try (Connection conn = DriverManager.getConnection(url);
         Statement stmt = conn.createStatement()) {
        
        stmt.execute(createUsersTable);
        stmt.execute(createQuizzesTable);
        stmt.execute(createFlashcardsTable);
        System.out.println("ALL tables created or already exist.");
        
    } catch (SQLException e) {
        System.out.println("Error creating users table");
        e.printStackTrace();
    }
}

public static void RegisterAccount(){
    String url = "jdbc:sqlite:C:/Users/tyler/Downloads/QuizAppAttempt/quizAppAttempt.db";
    System.out.println("Please enter your username.");

    String Username = scanner.nextLine();

    System.out.println("Please enter your password");

    String Password = scanner.nextLine();

    String sql = "INSERT INTO users(username, password) VALUES(?, ?)";

    try (Connection conn = DriverManager.getConnection(url);
        java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, Username);
            pstmt.setString(2, Password);

            pstmt.executeUpdate();
            System.out.println("Account Created successfully");
        }
        catch (SQLException e) {
            if (e.getMessage().contains("UNIQUE")) {

                System.out.println("That username has been taken already.");
            }

            else {
                System.out.println("Error creating account");
                e.printStackTrace();
            }
        }
}

public static int loginUser(){

    String url = "jdbc:sqlite:C:/Users/tyler/Downloads/QuizAppAttempt/quizAppAttempt.db";
    System.out.println("Enter your username:");
    String Username = scanner.nextLine();

    System.out.println("Enter your password:");
    String Password = scanner.nextLine();

    String sql = "SELECT * FROM users WHERE Username = ? AND Password = ?";
    try (Connection conn = DriverManager.getConnection(url);
    java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)){
        pstmt.setString(1, Username);
        pstmt.setString(2, Password);

        java.sql.ResultSet rs = pstmt.executeQuery();

        if (rs.next()){
            int userId = rs.getInt("id");
            System.out.println("Login Successful");
           
            return userId;

        }

        else {
            System.out.println("Incorrect Login");
            return -1;
        }

    }

    catch (SQLException e){
        System.out.println("Error loggin in");
        e.printStackTrace();
        return -1;
    }


    }
    

public static void saveQuizToDatabase(Quiz quiz, int userId) {

    String url = "jdbc:sqlite:C:/Users/tyler/Downloads/QuizAppAttempt/quizAppAttempt.db";
    String insertQuizSQL = "INSERT INTO quizzes(user_id, title) VALUES(?, ?)";

    try (Connection conn = DriverManager.getConnection(url);
    java.sql.PreparedStatement pstmt = conn.prepareStatement(insertQuizSQL, Statement.RETURN_GENERATED_KEYS)) {
        pstmt.setInt(1, userId);
        pstmt.setString(2, quiz.QuizName);
        pstmt.executeUpdate();

        java.sql.ResultSet generatedKeys = pstmt.getGeneratedKeys();

        if (generatedKeys.next()) {
            int quizId = generatedKeys.getInt(1);

            String insertCardSQL = "INSERT INTO flashcards(quiz_id, question, answer) VALUES (?, ?, ?)";

            for (FlashCards card: quiz.cards) {

                try(java.sql.PreparedStatement cardStmt = conn.prepareStatement(insertCardSQL)){

                    cardStmt.setInt(1, quizId);
                    cardStmt.setString(2, card.QuizInfo);
                    cardStmt.setString(3, card.QuizAnswer);
                    cardStmt.executeUpdate();

                }
            }

            System.out.println("Quiz and Flashcards saved to database.");

        
        }
    }
        catch(SQLException e) {
            System.out.println("Error saving quiz.");
            e.printStackTrace();
        }


    




}

public static ArrayList<Quiz> loadUserQuizzes(int userId){
String url = "jdbc:sqlite:C:/Users/tyler/Downloads/QuizAppAttempt/quizAppAttempt.db";
ArrayList<Quiz> quizzes = new ArrayList<>();

String getQuizzesSQL = "SELECT * FROM QUIZZES WHERE user_id = ?";

try (Connection conn = DriverManager.getConnection(url);
    java.sql.PreparedStatement quizstmt = conn.prepareStatement(getQuizzesSQL)){
        quizstmt.setInt(1, userId);
        java.sql.ResultSet quizRs = quizstmt.executeQuery();

        while (quizRs.next()){
            int quizId = quizRs.getInt("id");
            String title = quizRs.getString("title");
            
            ArrayList<FlashCards> flashcards = new ArrayList<>();

            String getFlashcardsSQL = "SELECT * FROM flashcards WHERE quiz_id = ? ";

            try (java.sql.PreparedStatement flashcardStmt = conn.prepareStatement(getFlashcardsSQL)){
                flashcardStmt.setInt(1, quizId);
                java.sql.ResultSet flashcardRs = flashcardStmt.executeQuery();

                while (flashcardRs.next()) {
                    String question = flashcardRs.getString("question");
                    String answer = flashcardRs.getString("answer");
                    flashcards.add(new FlashCards(question, answer));
                }


            }

            quizzes.add(new Quiz(title, flashcards));

        }


    }
    catch(SQLException e) {
        System.out.println("Error loading quizzes");
        e.printStackTrace();
    }



return quizzes;


}












    
}






























   

