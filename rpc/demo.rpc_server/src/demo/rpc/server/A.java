package demo.rpc.server;

public class A {
	
	public static void main(String[] args) throws Exception {
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					System.out.println("----"+System.currentTimeMillis());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		t.start();
		
		Thread.sleep(10000);
		
		t.stop();
		
	}

}
