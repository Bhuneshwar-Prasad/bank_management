package bank_management;

public class Loadings {
	
	public static void mainLoading(int dotCount) throws InterruptedException {
		// This method is responsible for showcasing loading animation
	    System.out.print("Loading");
	    for (int i = 0; i < dotCount; i++) {
	        Thread.sleep(1000);
	        System.out.print(".");
	    }
	    System.out.println(); // Move to the next line after loading is complete
	}

}
