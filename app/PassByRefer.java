package cafe_project.app;

public class PassByRefer {

	static int num;
	static String str;
	
	public void passingInt(int num) {
		this.num = num;
	}
	
	public void passingStr(String str) {
		this.str = str;
	}
}
