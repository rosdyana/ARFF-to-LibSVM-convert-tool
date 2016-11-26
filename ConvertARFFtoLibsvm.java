import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;


public class ConvertARFFtoLibsvm {
	public static void main(String[] arg) throws IOException
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Input Name of File which is written ");
		String FileNameWrite = scan.next();
		System.out.println("Input Name of File which is read ");
		String FileNameRead = scan.next();
		FileOutputStream fout = null;
		fout = new FileOutputStream(FileNameWrite);
		PrintWriter pw = new PrintWriter(fout);
		// read file
		FileInputStream fis = null;
		fis = new FileInputStream(FileNameRead);
		DataInputStream in = new DataInputStream(fis);
		BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
		String line = null;
		while((line = br.readLine()) != null)
		{
			String s = " ";
			if(line.contains("@"))
			{
				System.out.println(line);
				continue;
			}
			else if(line.length() == 0 )
			{
				break;
			}
			
			String line2 = line.trim();
			String[] array =line2.split(",");
			System.out.println(line2);
			for(int i = 0; i< array.length -1; i++)
			{
				s += (i+1)+":"+array[i]+ " ";
			}
				s = array[array.length -1] + s;
				pw.println(s);
		}
		
		in.close();
		pw.close();
		fout.close();
		System.out.println("*********finish");	
	}
	
}
