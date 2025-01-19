package cafe_project.api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileApi {

	static File dir;
	
	static FileWriter fw;
	static BufferedWriter bw;
	
	static FileReader fr;
	static BufferedReader br;
	
	private static final String PATH = "C:\\factory\\java\\JavaStudy\\src\\cafe_project\\list\\";
	
	public static final String NO_FILE = null;
	public static final String COFFEE_FILE = "Coffee.txt";
	public static final String BEVERAGE_FILE = "Beverage.txt";
	public static final String TEA_FILE = "Tea.txt";
	public static final String ADE_FILE = "Ade.txt";
	public static final String JUICE_FILE = "Juice.txt";
	public static final String FRAPPUCCINO_FILE = "Frappuccino.txt";
	public static final String BLENDED_FILE = "Blended.txt";
	public static final String DESERT_FILE = "Desert.txt";
	
	public static final int NO_RW = 0;
	public static final int WRITE = 1;
	public static final int READ = 2;
	
	public FileApi(String list, int rw) throws IOException {
		dir = new File(PATH);
		
		if (rw == WRITE) {
			fw = new FileWriter(list);
			bw = new BufferedWriter(fw);
		} else if (rw == READ) {
			fr = new FileReader(list);
			br = new BufferedReader(fr);
		}
	}
	
	public String[] getFileNames() {
		return dir.list();
	}
}
