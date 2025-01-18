package myself.exer5;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Mode mode = Mode.getMode();
		
		mode.selectMode();
		
		while(mode.getCurrMode() != mode.END) {			
			if (mode.getCurrMode() == mode.CUSTOMER) {
				while (!mode.closed) {
					mode.selectCustomMode();
					
					if (mode.getCurrCustomMode() == mode.ORDER) {
						mode.procOrder();
						mode.payMode();
						mode.isOrderOut();
						mode.isClosed();
					} else if (mode.getCurrCustomMode() == mode.WAITING_CHK) {
						int retWaitNum = mode.waitingChkMode();
						if (retWaitNum > 0) {
							System.out.println(retWaitNum + "번입니다.");
						} else {
							System.out.println("주문을 하지 않으셨습니다!");
						}
					}
				}
			} else if (mode.getCurrMode() == mode.ADMIN) {
				
			}
		}
	}

}
