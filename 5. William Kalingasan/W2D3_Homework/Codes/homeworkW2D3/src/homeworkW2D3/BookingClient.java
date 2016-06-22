package homeworkW2D3;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class BookingClient implements Runnable {
  public static void main(String args[]) {
     BookingClient bc = new BookingClient();
     Thread t = new Thread(bc);
     t.start();
     
  }
  
  private static boolean validateTickets(String tickets){
     try{
        int temp = Integer.parseInt(tickets);
        return true;
     }
     catch(Exception e){
        return false;
     }
  }

@Override
public void run() {
   // TODO Auto-generated method stub
   Scanner input = new Scanner(System.in);
   int numberOfTickets = 0;
   try {
    Socket s1 = new Socket("127.0.0.1", 5432);

       boolean valid = false;
       while(!valid){
          System.out.print("How many tickets to book: ");
          String tickets = input.next();
          if(validateTickets(tickets)){
             numberOfTickets = Integer.parseInt(tickets);
             valid = true;
             //System.out.println("Valid number of tickets");
          }
          else{
             System.out.println("Invalid input of tickets");
             valid = false;
          }
       }
       
       OutputStream s1out = s1.getOutputStream();
       DataOutputStream dos = new DataOutputStream(s1out);

       // Send tickets to book to server
       s1out.flush();
       dos.flush();
       dos.writeUTF(String.valueOf(numberOfTickets));
       
       InputStream is = s1.getInputStream();
       DataInputStream dis = new DataInputStream(is);

       System.out.println(dis.readUTF());
       System.out.println("Thank you!");

       dis.close();
       is.close();
       
    s1.close();
  }
  catch (ConnectException connExc) {
    System.err.println("Could not connect to the server.");
  }
  catch (IOException e) {
    // ignore
  }
}

}
