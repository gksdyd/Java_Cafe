package cafe_project.app;

import java.util.ArrayList;

public class Menu {
	
	private static ArrayList<ArrayList<Product>> productList = new ArrayList<ArrayList<Product>>();
	private static ArrayList<Product> productName = new ArrayList<Product>();
	
	private static ArrayList<Product> coffeeList = new ArrayList<Product>();
	private static ArrayList<Product> beverageList = new ArrayList<Product>();
	private static ArrayList<Product> teaList = new ArrayList<Product>();
	private static ArrayList<Product> adeNJuiceList = new ArrayList<Product>();
	private static ArrayList<Product> frappuccinoList = new ArrayList<Product>();
	private static ArrayList<Product> blendedList = new ArrayList<Product>();
	private static ArrayList<Product> desertList = new ArrayList<Product>();
	
	private static Menu menu = new Menu();
	
	private Menu() {
		addProductList();
		addProductType();
		addCoffee();
		addBeverage();
		addTea();
		addAdeNJuice();
		addFrappuccino();
		addBlended();
		addDesert();
	}
	
	public static Menu getMenu() {
		if (menu == null) {
			menu = new Menu();
		}
		return menu;
	}
	
	private static void addProductList() {
		productList.add(coffeeList);
		productList.add(beverageList);
		productList.add(teaList);
		productList.add(adeNJuiceList);
		productList.add(frappuccinoList);
		productList.add(blendedList);
		productList.add(desertList);
	}
	
	private static void addProductType() {
		productName.add(new Product("Coffee"));
		productName.add(new Product("Beverage"));
		productName.add(new Product("Tea"));
		productName.add(new Product("Ade & Juice"));
		productName.add(new Product("Frappuccino"));
		productName.add(new Product("Blended"));
		productName.add(new Product("Desert"));
	}
	
	public ArrayList<Product> getProductList(int index) {
		return productList.get(index);
	}
	
	public int getProductListSize() {
		return productList.size();
	}
	
	public String getProductType(int index) {
		return productName.get(index).getType();
	}
	
	private static void addCoffee() {
		coffeeList.add(new Product(2800, "아메리카노"));
		coffeeList.add(new Product(4500, "카페라떼"));
		coffeeList.add(new Product(5000, "카페모카"));
		coffeeList.add(new Product(5200, "바닐라라떼"));
		coffeeList.add(new Product(5000, "카라멜마키아또"));
		coffeeList.add(new Product(5200, "연유라떼"));
		coffeeList.add(new Product(5500, "콜드브루"));
		coffeeList.add(new Product(6000, "콜드브루 라떼"));
		coffeeList.add(new Product(7000, "콜드브루 흑당라떼"));
		coffeeList.add(new Product(7000, "콜드브루 연유라떼"));
	}
	
	private static void addBeverage() {
		beverageList.add(new Product(5000, "초코라떼"));
		beverageList.add(new Product(5300, "녹차라떼"));
		beverageList.add(new Product(4000, "식혜"));
		beverageList.add(new Product(4500, "미숫가루"));
		beverageList.add(new Product(5000, "밀크티"));
		beverageList.add(new Product(6000, "블랙펄 밀크티"));
	}
	
	private static void addTea() {
		teaList.add(new Product(4000, "아이스미초"));
		teaList.add(new Product(4300, "아이스티"));
		teaList.add(new Product(5300, "아.망.추"));
		teaList.add(new Product(4500, "깔라만시티"));
		teaList.add(new Product(5000, "레몬티"));
		teaList.add(new Product(5000, "자몽티"));
		teaList.add(new Product(5000, "유자티"));
		teaList.add(new Product(3500, "우롱티"));
		teaList.add(new Product(4000, "페퍼민트티"));
		teaList.add(new Product(4000, "황금캐모마일티"));
		teaList.add(new Product(5000, "레몬얼그레이티"));
	}
	
	private static void addAdeNJuice() {
		adeNJuiceList.add(new Product(5300, "깔라만시에이드"));
		adeNJuiceList.add(new Product(5500, "레모네이드"));
		adeNJuiceList.add(new Product(5500, "유자에이드"));
		adeNJuiceList.add(new Product(5000, "체리콕콕"));
		adeNJuiceList.add(new Product(6300, "블루베리주스"));
		adeNJuiceList.add(new Product(5800, "딸기주스"));
	}
	
	private static void addFrappuccino() {
		frappuccinoList.add(new Product(5500, "딸기바나나 프라푸치노"));
		frappuccinoList.add(new Product(5500, "초코바나나 프라푸치노"));
		frappuccinoList.add(new Product(5500, "녹차 프라푸치노"));
		frappuccinoList.add(new Product(6000, "피스타치오 프라푸치노"));
		frappuccinoList.add(new Product(5300, "쿠키크런치 프라푸치노"));
		frappuccinoList.add(new Product(5300, "초코 프라푸치노"));
		frappuccinoList.add(new Product(5500, "딸기 프라푸치노"));
	}
	
	private static void addBlended() {
		blendedList.add(new Product(5800, "고구마스무디"));
		blendedList.add(new Product(6800, "블루베리요거트스무디"));
		blendedList.add(new Product(5000, "플레인요거트스무디"));
		blendedList.add(new Product(5800, "딸기요거트스무디"));
		blendedList.add(new Product(5000, "밀크쉐이크"));
		blendedList.add(new Product(5800, "바나나밀크쉐이크"));
		blendedList.add(new Product(6300, "바나나커피쉐이크"));
	}
	
	private static void addDesert() {
		desertList.add(new Product(4900, "사라다빵"));
		desertList.add(new Product(4000, "소금빵"));
		desertList.add(new Product(4300, "감자빵"));
		desertList.add(new Product(3500, "단팥빵"));
		desertList.add(new Product(4500, "초코케잌"));
		desertList.add(new Product(4500, "딸기케잌"));
		desertList.add(new Product(4500, "바닐라케잌"));
	}
	
	public String getMenuName(ArrayList<Product> E, int index) {
		return E.get(index).getName();
	}
	
	public int getMenuPrice(ArrayList<Product> E, int index) {
		return E.get(index).getPrice();
	}
	
	public int getMenuListSize(ArrayList<Product> E) {
		return E.size();
	}
}
