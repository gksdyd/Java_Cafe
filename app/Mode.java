package cafe_project.app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Mode {
	
	public final byte INIT = 0;
	public final byte ORDER = 1;
	public final byte WAITING_CHK = 2;
	
	private static Mode mode = new Mode();
	
	private Mode() {}
	
	public static Mode getMode() {
		if (mode == null) {
			mode = new Mode();
		}
		return mode;
	}
	
	public final byte CUSTOMER = 1;
	public final byte ADMIN = 2;
	public final byte END = 3;
	
	private byte currMode = 0;
	
	public void selectMode() {
		Scanner scan = new Scanner(System.in);
		
		while (currMode != CUSTOMER && currMode != ADMIN && currMode != END) {
			try {
				System.out.print("1. 고객용 2. 관리자 3. 종료");
				currMode = scan.nextByte();
				if (currMode != CUSTOMER && currMode != ADMIN && currMode != END) {
					System.out.println("입력이 잘못됐습니다!");
				}
			} catch (InputMismatchException e) {
				scan = new Scanner(System.in);
				System.out.println("다시 입력해주세요!");
			}
		}
	}
	
	byte customMode = 0;
	public void selectCustomMode() {
		Scanner scan = new Scanner(System.in);

		while (customMode != ORDER && customMode != WAITING_CHK) {
			try {
				System.out.print("1. 주문 2. 대기 확인");
				customMode = scan.nextByte();
				if (customMode != ORDER && customMode != WAITING_CHK) {
					System.out.println("입력이 잘못됐습니다!");
				}
			} catch (InputMismatchException e) {
				scan = new Scanner(System.in);
				System.out.println("다시 입력해주세요!");
			}
		}
	}
	
	public byte getCurrCustomMode() {
		return customMode;
	}
	
	public void procOrder() {
		final byte CHOICE_CATEGORY = 0;
		final byte CHOICE_MENU = 1;
		final byte INPUT_NUM = 2;
		final byte CONTINUE_ORDER = 3;
		final byte END_CHOICE = 4;
		
		byte proc = 0;
		ArrayList<Byte>[] selMenu = new ArrayList[2];
		selMenu[0] = new ArrayList<Byte>();
		selMenu[1] = new ArrayList<Byte>();
		byte tempMenu;
		byte selCategoryIndex = 0;
		
		Cafe cafe = Cafe.getCafe();
		
		Scanner scan = new Scanner(System.in);
		
		customMode = INIT;
		while (proc != END_CHOICE) {
			switch (proc) {
				case CHOICE_CATEGORY:
					try {
						System.out.println("카테고리 선택");
						for (int i = 0; i < cafe.getProductCnt(); i++) {
							System.out.printf("%d. %s ", i + 1, cafe.getProductType(i));
						}
						System.out.println();
						selCategoryIndex = scan.nextByte();
						if (selCategoryIndex <= 0 || selCategoryIndex > cafe.getProductCnt()) {
							System.out.println("카테고리 입력이 잘못됐습니다!");
							break;
						}
						proc = CHOICE_MENU;
						break;
					} catch (InputMismatchException e) {
						scan = new Scanner(System.in);
						System.out.println("다시 입력해주세요!");
						break;
					}
				case CHOICE_MENU:
					try {
						System.out.println("메뉴 선택");
						for (int i = 0; i < cafe.getMenuCnt(selCategoryIndex - 1); i++) {
							System.out.printf("%d. %s ", i + 1, cafe.getMenu(selCategoryIndex - 1, i));
						}
						System.out.println();
						tempMenu = scan.nextByte();
						if (tempMenu <= 0 || tempMenu > cafe.getMenuCnt(selCategoryIndex - 1)) {
							System.out.println("메뉴 입력이 잘못됐습니다!");
							break;
						} else {
							selMenu[0].add(tempMenu);
						}
						proc = INPUT_NUM;
						break;
					} catch (InputMismatchException e) {
						scan = new Scanner(System.in);
						System.out.println("다시 입력해주세요!");
						break;
					}
					
				case INPUT_NUM:
					try {
						System.out.print("수량을 입력하세요: ");
						tempMenu = scan.nextByte();
						if (tempMenu <= 0) {
							System.out.println("수량 입력이 잘못됐습니다!");
							break;
						} else {
							selMenu[1].add(tempMenu);
						}
						proc = CONTINUE_ORDER;
						break;
					} catch (InputMismatchException e) {
						scan = new Scanner(System.in);
						System.out.println("다시 입력해주세요!");
						break;
					}
					
				case CONTINUE_ORDER:
					try {
						System.out.print("주문을 계속 진행하시겠나요? Yes or No");
						String continueOrder = scan.next();
						continueOrder = continueOrder.toUpperCase();
						if (continueOrder.equals("YES")) {
							proc = CHOICE_CATEGORY;
						} else if (continueOrder.equals("NO")) {
							proc = END_CHOICE;
						} else {
							System.out.println("잘못된 입력입니다!");
						}
						break;
					} catch (InputMismatchException e) {
						scan = new Scanner(System.in);
						System.out.println("다시 입력해주세요!");
						break;
					}
			}
		}
		cafe.sumTotalPrice(selMenu, selCategoryIndex - 1);
	}
	
	public boolean closed = false;
	public void isClosed() {
		String isClosed;
		
		Scanner scan = new Scanner(System.in);
		
		if (!customer.isExistCustom()) {
			while (true) {
				try {
					System.out.print("마감할까요? Yes or No");
					isClosed = scan.next();
					
					isClosed = isClosed.toUpperCase();
					if (isClosed.equals("YES")) {
						closed = true;
						currMode = END;
						return;
					} else if (isClosed.equals("NO")) {
						closed = false;
						return;
					} else {
						System.out.println("잘못된 입력입니다!");
					}
				} catch (InputMismatchException e) {
					scan = new Scanner(System.in);
					System.out.println("잘못된 입력입니다!");
				}
			}
		}
	}
	
	public void isOrderOut() {
		byte orderOut = 0;
		
		if (customer.isExistCustom()) {
			PassByRefer pass = new PassByRefer();
			orderOut = (byte)(Math.random() * 2);
			
			if (orderOut == 1) {
				customer.getCustomInfo();
				System.out.printf("대기 번호 %d, ", pass.num);
				System.out.printf("전화 번호 %s ", pass.str);
				System.out.println("주문한 음식 나왔습니다.");
			}
		}
	}
	
	public byte getCurrMode() {
		return currMode;
	}
	
	Customer customer = Customer.getCustomer();
	public void payMode() {
		customer.customResister();
		customer.payMoney();
	}
	
	public int waitingChkMode() {
		customMode = INIT;
		return customer.getNumId();
	}
}
