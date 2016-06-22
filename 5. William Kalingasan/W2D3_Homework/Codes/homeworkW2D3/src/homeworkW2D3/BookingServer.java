package homeworkW2D3;

import java.net.*;
import java.io.*;

public class BookingServer implements Runnable {
   int totalTickets = 500;
   int numberOfTickets = 0;
  public static void main(String args[]) {
    BookingServer bs = new BookingServer();
    Thread t = new Thread(bs);
    t.start();
  }
@Override
public void run() {
   // TODO Auto-generated method stub
   ServerSocket s = null;

   // Register your service on port 5432
   try {
     s = new ServerSocket(5432);
   } catch (IOException e) {
     // ignore
   }

  // Run the listen/accept loop forever
   while (true) {
     try {
       // Wait here and listen for a connection
       Socket s1 = s.accept();
       
       InputStream is = s1.getInputStream();
       DataInputStream dis = new DataInputStream(is);

       // Read the input and print it to the screen
       numberOfTickets = Integer.parseInt(dis.readUTF());
       if(numberOfTickets > totalTickets){
          OutputStream s1out = s1.getOutputStream();
          DataOutputStream dos = new DataOutputStream(s1out);
          dos.writeUTF("Cannot book more than remaining tickets");
          dos.flush();
          dos.close();
          s1.close();
       }
       else{
          totalTickets = totalTickets - numberOfTickets;
          OutputStream s1out = s1.getOutputStream();
          DataOutputStream dos = new DataOutputStream(s1out);
          dos.writeUTF("Tickets booked! Remaining tickets: " + totalTickets);
          dos.flush();
          dos.close();
          s1.close();
       }
       is.close();
       dis.close();
       
       
     } catch (IOException e) {
       // ignore
     }
   }
}
}