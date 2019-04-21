/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package educationalelectronicgaming;

import java.io.IOException;
import java.util.Scanner;

public class EducationalElectronicGaming {

    public static void main(String[] args) throws IOException {
        /*WebsiteUI g = new WebsiteUI();
        g.setVisible(true);*/
        DataBaseManager db = new DataBaseManager();
        Scanner in = new Scanner(System.in);
        System.out.println("<<--Electronic Educational Gaming-->>");
        System.out.println("1) Login.");
        System.out.println("2) Register.");
        System.out.println("Enter your choice : ");
        int choice = in.nextInt();
        int choice2;
        int choice3;
        switch (choice) {
            case 1:
                System.out.println("1) Student.");
                System.out.println("2) Teacher");
                System.out.println("Enter your choice : ");
                choice2 = in.nextInt();
                switch (choice2) {
                    case 1:
                        Student s = new Student();
                        System.out.println("Username : ");
                        s.Name = in.next();
                        System.out.println("Password : ");
                        s.Password = in.next();
                        //I need you to make a function that confirms if this student exists or not also to check his password if so :D
                        //Do the same with the teacher !!!
                        break;
                    case 2:
                        Teacher t = new Teacher();
                        System.out.println("Username : ");
                        t.Name = in.next();
                        System.out.println("Password : ");
                        t.Password = in.next();
                        //Make a function that retrives the teacher tht has this username as a boolean
                        if (db.retriveTeacher() == true) {
                            System.out.println("1) Add a Game.   2) Play a Game.");
                            System.out.println("Enter your choice : ");
                            int TList = in.nextInt();
                            switch (TList) {
                                case 1:
                                    System.out.println("1) MCQ.  2) T or F");
                                    System.out.println("Enter your choice : ");
                                    int GList = in.nextInt();
                                    switch (GList) {
                                        case 1:
                                            MCQ mcq = new MCQ();
                                            System.out.println("Enter the game name : ");
                                            mcq.Name = in.nextLine();
                                            mcq.Name = in.nextLine();
                                            System.out.println("Enter the number of Questions : ");
                                            mcq.NumberOfQuestions = in.nextInt();
                                            Question[] q = new Question[mcq.NumberOfQuestions];
                                            for (int i = 0; i < mcq.NumberOfQuestions; i++) {
                                                Question qu = new Question();
                                                System.out.println("Enter the question name : ");
                                                qu.Question = in.nextLine();
                                                qu.Question = in.nextLine();
                                                for (int p = 0; p < 4; p++) {
                                                    System.out.println("Enter the " + (p + 1) + " choice");
                                                    qu.Choices[p] = in.nextLine();
                                                    qu.Choices[p] = in.nextLine();
                                                }
                                                System.out.println("Enter which choice is the correct answer : ");
                                                int QC = in.nextInt();
                                                qu.CorrectAnswer = qu.Choices[QC - 1];
                                            }
                                            System.out.println("Done creating the game !!!");
                                            break;
                                        case 2:
                                            TrueOrFalse tf = new TrueOrFalse();
                                            System.out.println("Enter the game name : ");
                                            tf.Name = in.nextLine();
                                            tf.Name = in.nextLine();
                                            System.out.println("Enter the number of Questions : ");
                                            tf.NumberOfQuestions = in.nextInt();
                                            Question[] qs;
                                            qs = new Question[tf.NumberOfQuestions];
                                            for(int p=0;p<tf.NumberOfQuestions;p++)
                                            {
                                                Question qu = new Question();
                                                System.out.println("Enter the question name : ");
                                                qs[p].Question = in.nextLine();
                                                qs[p].Question = in.nextLine();
                                                System.out.println("Enter the correct answer (Either 'T' or 'F' : ");
                                                qs[p].CorrectAnswer = in.next();
                                            }
                                            System.out.println("Done creating the game !!!");
                                            break;
                                    }
                                case 2:
                                    // Here shoud be a list of the games created by him or created by other teachers ... each game defined by the teacher who did it :D
                                    // make function that takes all the games available names so i can just list them
                                    String [] Gameslist;
                                    Gameslist = db.RetriveGameList();
                                    for(int i=0; i<Gameslist.length ; i++)
                                    {
                                        System.out.println((i+1)+") "+Gameslist[i]);
                                    }
                                    System.out.println("Enter the game`s number : ");
                                    int cho = in.nextInt();
                                    Game g = new Game();
                                    g.Name = Gameslist[cho-1];
                                    db.RetriveGame(g);
                            }
                        }
                        break;
                }
                break;
            case 2:
                OUTER:
                while (true) {
                    System.out.println("1)Register As Student  2)Register As Teacher");
                    choice3 = in.nextInt();
                    switch (choice3) {
                        case 1:
                            Student s = new Student();
                            System.out.println("Enter the following Data !!--->>>>");
                            System.out.println("Note : The labels marked with (*) are REQUIRED");
                            System.out.println("");
                            System.out.println("*Username : ");
                            s.Name = in.next();
                            System.out.println("*Password : ");
                            s.Password = in.next();
                            System.out.println("*Email : ");
                            s.Email = in.next();
                            System.out.println("Phone : ");
                            s.Telephone = in.next();
                            System.out.println("Mobile : ");
                            s.Mobile = in.next();
                            System.out.println("Age : ");
                            s.Age = in.nextInt();
                            System.out.println("Date of Birth (DD/MM/YYYY): ");
                            s.DateOfBirth = in.next();
                            System.out.println("Gender : ");
                            s.Gender = in.next();
                            System.out.println("Adress : ");
                            s.Address = in.nextLine();
                            s.Address = in.nextLine();
                            s.Occupation = "Student";
                            db.AddStudent(s);
                            break OUTER;
                        case 2:
                            Teacher t = new Teacher();
                            System.out.println("Enter the following Data !!--->>>>");
                            System.out.println("Note : The labels marked with (*) are REQUIRED");
                            System.out.println("");
                            System.out.println("*Username : ");
                            t.Name = in.next();
                            System.out.println("*Password : ");
                            t.Password = in.next();
                            System.out.println("*Email : ");
                            t.Email = in.next();
                            System.out.println("Phone : ");
                            t.Telephone = in.next();
                            System.out.println("Mobile : ");
                            t.Mobile = in.next();
                            System.out.println("Age : ");
                            t.Age = in.nextInt();
                            System.out.println("Date of Birth (DD/MM/YYYY): ");
                            t.DateOfBirth = in.next();
                            System.out.println("Gender : ");
                            t.Gender = in.next();
                            System.out.println("Adress : ");
                            t.Address = in.nextLine();
                            t.Address = in.nextLine();
                            t.Occupation = "Teacher";
                            db.AddTeacher(t);
                            break OUTER;
                        default:
                            System.out.println("Wrong Entry please enter the choice correctly !!!");
                            break;
                    }
                }
                break;
        }
    }

}
