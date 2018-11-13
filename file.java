package f;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class file {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
JFileChooser chooser = new JFileChooser();
Scanner in = null;
if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
	File selectedFile = chooser.getSelectedFile();
	in = new Scanner(selectedFile);
	int lin =1;
	final int maxl = 10;
	while( in.hasNextLine() && lin <= maxl) {
		String l = in.nextLine();
		System.out.println(lin + ":"+ l);
		lin++;
	}
	if(in.hasNextLine()) {
		System.out.println(".....");
	}
}
	}

}
