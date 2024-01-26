package some;
import java.util.*;
public class EmailValidation {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		boolean res = false;
		if(str.contains("@")) {
			if(str.substring(str.length()-4).equals(".com")) {
				if(str.indexOf(".com")-str.indexOf("@")>1) {
					res = true;
				}
			}
		}
		if(res==false) {
			System.out.println("Invalid Email");
		} else {
			System.out.println("Valid Email");
		}
	}
}
