package cafe_project.app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer {

	private static int count = 0;
	
	private static ArrayList<Integer> waitingNumArray = new ArrayList<Integer>();
	private static ArrayList<String> customPhoneNumArray = new ArrayList<String>();

	Cafe cafe = Cafe.getCafe();

	private static Customer customer = new Customer();
	
	private Customer() {}
	
	public static Customer getCustomer() {
		if (customer == null) {
			customer = new Customer();
		}
		return customer;
	}
	
	public void customResister() {
		Scanner scan = new Scanner(System.in);
		
		try {
			while (true) {
				boolean isNumeric = true;
				System.out.print("전화번호 뒷자리 4개 입력하세요");
				String phoneNum = scan.next();
				
				if (phoneNum.length() == 4) {
					for (int i = 0; i < phoneNum.length(); i++) {
						if (phoneNum.charAt(i) < '0' || phoneNum.charAt(i) > '9') {
							isNumeric = false;
							break;
						}
					}
				} else {
					isNumeric = false;
				}
				
				if (!isNumeric) {
					System.out.println("전화번호는 4자리 숫자입니다!");
					continue;
				}
				
				count++;
				waitingNumArray.add(count);
				customPhoneNumArray.add(phoneNum);
				return;
			}
		} catch (InputMismatchException e) {
			scan = new Scanner(System.in);
			System.out.println("잘못된 입력입니다!");
		}
	}

	public void payMoney() {
		int changeMoney = cafe.changeMoney(cafe.getTotalPrice());

		if (changeMoney == -1) {
			System.out.println("설거지하고 가세요");
		} else {
			System.out.printf("거스름 돈은 %d입니다.\n", changeMoney);
		}
	}

	public int getNumId() {
		Scanner scan = new Scanner(System.in);
		
		try {
			while (true) {
				boolean isNumeric = true;
				System.out.print("전화번호 뒷자리 4개 입력하세요");
				String phoneNum = scan.next();
				if (phoneNum.length() == 4) {
					for (int i = 0; i < phoneNum.length(); i++) {
						if (phoneNum.charAt(i) < '0' || phoneNum.charAt(i) > '9') {
							isNumeric = false;
							break;
						}
					}
				} else {
					isNumeric = false;
				}
				
				if (!isNumeric) {
					System.out.println("전화번호는 4자리 숫자입니다!");
					continue;
				}
				if (customPhoneNumArray.contains(phoneNum)) {
					return waitingNumArray.get(customPhoneNumArray.indexOf(phoneNum));
				}
				return -1;
			}
		} catch (InputMismatchException e) {
			scan = new Scanner(System.in);
			System.out.println("잘못된 입력입니다!");
		}
		return -1;
	}
	
	public void getCustomInfo() {
		PassByRefer pass = new PassByRefer();
		pass.passingInt(waitingNumArray.remove(0));
		pass.passingStr(customPhoneNumArray.remove(0));
	}
	
	public boolean isExistCustom() {
		if (waitingNumArray.size() == 0) {
			return false;
		}
		return true;
	}
}
