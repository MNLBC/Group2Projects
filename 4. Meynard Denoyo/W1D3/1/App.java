public class App{
	public static int finalvalue = 1;
	public static void main(String[] args){
		int factorialvalue = Integer.parseInt(args[0]);
		for(int i = 1; i <= factorialvalue; i++){
			finalvalue = finalvalue * i;
		}
		System.out.println(args[0] + "! is equals to " + finalvalue);
	}
}