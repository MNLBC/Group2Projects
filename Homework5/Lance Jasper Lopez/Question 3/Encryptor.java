import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * 
 * @author lopezla
 * 
 */

// Answer for #3 in W1D5 Homework
public class Encryptor {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		Scanner console = new Scanner(System.in);
		StringBuffer buffer = new StringBuffer();

		System.out.println("Please enter text to be encrypted:");
		String input = console.nextLine().trim();

		MessageDigest messageFood = MessageDigest.getInstance("MD5");
		messageFood.update(input.getBytes());

		byte byteData[] = messageFood.digest();

		for (int i = 0; i < byteData.length; i++) {
			buffer.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		BufferedWriter writer = new BufferedWriter(new FileWriter("digested-password.txt"));
		writer.write(buffer.toString());
		writer.close();
		System.out.println("String Hash: " + buffer.toString());

		System.out.println("File created successfully");

	}

}
