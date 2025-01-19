package cafe_project.api;

import java.util.ArrayList;

public class ArrayListApi<E> {

	ArrayList<E> arrayList;
	
	public ArrayListApi() {
		arrayList = new ArrayList<E>();
	}
	
	public boolean addValue(E value) {
		return arrayList.add(value);
	}
	
	public E removeValue(int index) {
		return arrayList.remove(index);
	}
	
	public int getSize() {
		return arrayList.size();
	}
}
