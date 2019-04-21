package educationalelectronicgaming;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.*;
import java.io.FileWriter;

public class DataBaseManager {

    private BufferedWriter write;
    private BufferedReader read;
    private Scanner in;

    //Add Teacher
    public void AddTeacher(Teacher t) throws IOException {
        boolean check;
        check = CheckTeacher(t.Name);//if teacher is exist
        if (check == true) {
            System.out.println("Teacher Exist");
        } else {
            try (FileWriter teaFile = new FileWriter("Teachers\\" + t.Name +".txt", true)) {
                write = new BufferedWriter(teaFile);
                write.append(t.Name);
                write.newLine();
                write.append(t.Password);
                write.newLine();
                write.append("" + t.Age);
                write.newLine();
                write.append(t.Gender);
                write.newLine();
                write.append(t.Address);
                write.newLine();
                write.append(t.DateOfBirth);
                write.newLine();
                write.append(t.Email);
                write.append(t.Occupation);
                write.newLine();
                write.append(t.Mobile);
                write.newLine();
                write.append(t.Telephone);
                write.newLine();
                write.append("" + t.Games);
                write.newLine();
                write.close();
            } catch (Exception e) {
                System.out.println("you have on error. ");
            }
        }
    }

    //Add Student
    public void AddStudent(Student s) throws IOException {
        boolean check;
        check = CheckStudent(s.Name);//if teacher is exist
        if (check == true) {
            System.out.println("Student Exist");
        } else {
            try (FileWriter stuFile = new FileWriter("Students\\" + s.Name+".txt", true)) {
                write = new BufferedWriter(stuFile);
                write.append(s.Name);
                write.newLine();
                write.append(s.Password);
                write.newLine();
                write.append("" + s.Age);
                write.newLine();
                write.append(s.Gender);
                write.newLine();
                write.append(s.Address);
                write.newLine();
                write.append(s.DateOfBirth);
                write.newLine();
                write.append(s.Email);
                write.append(s.Occupation);
                write.newLine();
                write.append(s.Mobile);
                write.newLine();
                write.append(s.Telephone);
                write.newLine();
                write.append("" + s.Achievement);
                write.newLine();
                write.close();
            } catch (Exception e) {
                System.out.println("you have on error. ");
            }
        }
    }

    //Add Game
    public void AddGame(Game g) throws IOException {
        boolean check;
        check = CheckGame(g.Name);//if game is exist
        if (check == true) {
            System.out.println("Game Exist");
        } else {
            try (FileWriter gameFile = new FileWriter("Games\\" + g.Name+".txt", true)) {
                write = new BufferedWriter(gameFile);
                write.append(g.Name);
                write.newLine();
                write.append(g.Type);
                write.newLine();
                write.append("" +g.NumberOfQuestions);
                write.newLine();
                write.append(g.Rate);
                write.newLine();
                write.append("" + g.Score);
                write.newLine();
                write.append("" + g.QuestionsArray);
                write.newLine();
                write.close();
            } catch (Exception e) {
                System.out.println("you have on error. ");
            }
        }
    }

    public boolean CheckGame(String s) throws IOException {
        File file = new File("Games\\" + s+".txt");
        if (!file.exists()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean CheckStudent(String s) throws IOException {
        File file = new File("Students\\" + s+".txt");
        if (!file.exists()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean CheckTeacher(String s) throws IOException {
        File file = new File("Teachers\\" + s+".txt");
        if (!file.exists()) {
            return false;
        } else {
            return true;
        }
    }

    public void RetriveGame(Game g) throws IOException {
        int counter = 0;
        boolean checkGame = CheckGame(g.Name);
        if (checkGame == false) {
            System.out.println("Game Not Exist");
        } else {
            try (FileReader gameFile = new FileReader("Games\\" + g.Name+".txt")) {
                int i = 0;
                read = new BufferedReader(gameFile);
                g.Name = read.readLine();
                g.Type = read.readLine();
                g.NumberOfQuestions = read.read();
                g.Rate = read.readLine();
                g.Score = read.read();
                //Read Questions
                while (read.ready()) {
                    g.QuestionsArray[i].Question = read.readLine();
                    i++;
                }
                read.close();
            } catch (Exception e) {
                System.out.println("you have on error. ");
            }
            
            //Show Game InterFace Function Here////////////////////////
        }
    }

    public void EditGame(Game g) throws IOException {
        boolean check;
        check = CheckGame(g.Name);//if game is exist
        if (check == true) {
            System.out.println("Game Exist");
        } else {
            try (FileReader gameFile = new FileReader("Games\\" + g.Name+".txt")) {
                int i = 0;
                read = new BufferedReader(gameFile);
                g.Name = read.readLine();
                g.Type = read.readLine();
                g.NumberOfQuestions = read.read();
                g.Rate = read.readLine();
                g.Score = read.read();
                while (read.ready()) {
                    g.QuestionsArray[i].Question = read.readLine();
                    i++;
                }
                read.close();
            } catch (Exception e) {
                System.out.println("you have on error. ");
            }
            ///////////////////////Edit Interface Function Here//////////////////////

            //Write Edited Game In File Without Append
            try (FileWriter gameFile = new FileWriter("Games\\" + g.Name+".txt")) {
                write = new BufferedWriter(gameFile);
                write.write(g.Name);
                write.newLine();
                write.write(g.Type);
                write.newLine();
                write.write("" + g.NumberOfQuestions);
                write.newLine();
                write.write(g.Rate);
                write.newLine();
                write.write("" + g.Score);
                write.newLine();
                write.write("" + g.QuestionsArray);
                write.newLine();
                write.close();
            } catch (Exception e) {
                System.out.println("you have on error. ");
            }
        }

    }

    boolean retriveTeacher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String[] RetriveGameList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
