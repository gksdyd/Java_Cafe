package cafe_project.app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cafe {

//	private int menuCnt = 0;
//	private int[] count;
//	private int totalImport;
	
	private static Cafe cafe = new Cafe();
	
	private Cafe() {}
	
	public static Cafe getCafe() {
		if (cafe == null) {
			cafe = new Cafe();
		}
		return cafe;
	}
	
	public int getProductCnt() {
		Menu menu = Menu.getMenu();
		return menu.getProductListSize();
	}
	
	public String getProductType(int index) {
		Menu menu = Menu.getMenu();
		return menu.getProductType(index);
	}
	
	public ArrayList<Product> getProduct(int index) {
		Menu menu = Menu.getMenu();
		return menu.getProductList(index);
	}
	
	public String getMenu(int index1, int index2) {
		Menu menu = Menu.getMenu();
		return menu.getMenuName(getProduct(index1) ,index2);
	}
	
	public int getMenuCnt(int index) {
		Menu menu = Menu.getMenu();
		return menu.getMenuListSize(getProduct(index));
	}
	
	
	
	
	private int totalPrice;
	
	public void sumTotalPrice(ArrayList<Byte>[] selMenu, int index) {
		Menu menu = Menu.getMenu();
		for (int i = 0; i < selMenu[0].size(); i++) {
			this.totalPrice += (selMenu[1].remove(i) * menu.getMenuPrice(getProduct(index), selMenu[0].remove(i) - 1));
		}
	}
	
	public int getTotalPrice() {
		System.out.printf("총 가격은 %d입니다!\n", this.totalPrice);
		return this.totalPrice;
	}
	
	public int changeMoney(int totalPrice) {
		int money;
		int change = 0;
		
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			try {
				System.out.print("지불할 가격을 입력해주세요!");
				money = scan.nextInt();
				if (money < 0) {
					System.out.println("다시 입력해주세요!");
					continue;
				}
				if (totalPrice > money) {
					System.out.println("돈이 부족합니다.");
					change = -1;
				} else {
					change = money - totalPrice;
				}
				this.totalPrice = 0;
				return change;
			} catch (InputMismatchException e) {
				scan = new Scanner(System.in);
				System.out.println("다시 입력해주세요!");
				continue;
			}
		}
	}
	
	
	
	
	
//	public int getMenuMoney(String menu) {
//		for (int i = 0; i < menuCnt; i++) {
//			if (this.menu[i].equals(menu)) {
//				return this.price[i];
//			}
//		}
//		return -1;
//	}
//	
//	public int totalMoney() {
//		return totalImport;
//	}
//	
//	public int getMenuSaleCnt(String menu) {
//		for (int i = 0; i < menuCnt; i++) {
//			if (this.menu[i].equals(menu)) {
//				return count[i];
//			}
//		}
//		return -1;
//	}
//	
//	public int getTotalSaleCnt() {
//		int totalCnt = 0;
//		for (int i = 0; i < menuCnt; i++) {
//			totalCnt += count[i];
//		}
//		return totalCnt;
//	}
//	
//	public int getMenuPrice(String menu) {
//		for (int i = 0; i < menuCnt; i++) {
//			if (this.menu[i].equals(menu)) {
//				return price[i];
//			}
//		}
//		return -1;
//	}
}
