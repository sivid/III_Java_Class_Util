import java.io.*;
public class ListDir {
	public ListDir() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 0){
			System.out.println("input a directory thx");
			System.exit(0);
		}
		File file = new File(args[0]);
		if (!file.isDirectory()){
			System.out.println("Not a directory");
			System.exit(0);
		}
		File file1[] = file.listFiles();
		StringBuilder sb = new StringBuilder(300);
		String[] contents = file.list();
		for (int i = 0; i < contents.length; i++){
			sb.append(file1[i].isFile() ? "File: " :  "Directory: ");
			sb.append(contents[i]);
			sb.append("\n");
		}
		System.out.println(sb);
		
		// another way
		StringBuilder sb1 = new StringBuilder(300);
		File[] contents1 = file.listFiles();
		for (File f : contents1){
			sb1.append(f);
			sb1.append(f.isFile() ? "" : "\\");
			sb1.append("\n");
		}
		System.out.println(sb1);
		
		// and another way
		StringBuilder sb2 = new StringBuilder(300);
		File file2[] = file.listFiles();
		for (int i = 0; i < file2.length; i++){
			sb2.append(file2[i].isFile() ? "File: " : "Directory: ");
			sb2.append(file2[i]);
			sb2.append("\n");
		}
		System.out.println(sb2);
		
	}

}
