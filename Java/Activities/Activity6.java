package activities;

public class Activity6 {

	public static void main(String[] args) throws Exception {

		Plane plane = new Plane(10);
		plane.onboard("Sunny");
		plane.onboard("Bonny");
		plane.onboard("Roni");
		
		System.out.println("Plane took off at: " + plane.takeOff());
		System.out.println("People on the plane: " + plane.getPassengers());
		
		Thread.sleep(5000);
		plane.land();
		
		System.out.println("Plane landed at: " + plane.getLastTimeLanded());
        System.out.println("People on the plane after landing: " + plane.getPassengers());
		
	}

}
