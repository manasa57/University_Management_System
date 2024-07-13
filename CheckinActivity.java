
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CheckinActivity  {
    public  String  loginActivity() throws IOException {
        LoginPage l = new LoginPage();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); //reads date and time
        LocalDateTime now = LocalDateTime.now(); // reads current date and time
        FileWriter file1 = new FileWriter("LogininActivity",true);
        PrintWriter file3 = new PrintWriter(file1); // writing the date and time in loginactivity by appending in it
        // also prints line by line
        LoginPage l1 = new LoginPage();
        file3.println(l1.Rollno +","+l1.logintime+","+l1.logouttime);
        file3.close();
        return now.toString(); //returns the localtime

    }
    public void LoginActivity() throws IOException {
        Scanner scan = new Scanner(System.in);
        LoginPage l1 = new LoginPage();
        FileReader f1 = new FileReader("LogininActivity");
        BufferedReader f2 = new BufferedReader(f1); //reading the file line by line
        String line; // storing file lin in line string
        while((line = f2.readLine())!=null){
            String[] splittedLine = line.split(",",3); //splitting the line with this symbol "," ,bby threee storing three variables in array index 0,1,2
if(line.contentEquals("")){
    continue; // if line is empty then skip that line goto another line
}
else{
    System.out.println("-----------------------------------");
    System.out.println("               "+splittedLine[0]+"         "); //Rollnum
    System.out.println(splittedLine[1] +" | "+splittedLine[2]);        // printing login and loout activity
    System.out.println("-----------------------------------");

}
        }
        f2.close();

    }
}

