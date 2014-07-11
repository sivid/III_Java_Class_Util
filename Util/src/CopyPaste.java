import java.io.*;
public class CopyPaste {

	public CopyPaste() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// file input
		File inputFile = new File(args[0]);
		String str;
		StringBuilder sbRead = new StringBuilder(300);
		try{
			BufferedReader in = new BufferedReader(new FileReader(inputFile));
			while ((str = in.readLine()) != null){
				sbRead.append(str);
				sbRead.append("\n");
			}
			in.close();
		}catch(IOException e){e.printStackTrace();}
		
		// file output
		File outputFile = new File(args[1]);
		try{
			PrintWriter out = new PrintWriter(new FileWriter(outputFile));
			out.print(sbRead);
			out.close();
		}catch(IOException e){e.printStackTrace();}
		
	}

}
