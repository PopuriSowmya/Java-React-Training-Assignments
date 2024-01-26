package some;

public class StringBuilder {
	public String append(String s1, String s2) {
		return s1+s2;
	}
	
	public String insertPosition(String s1, String s2, int pos) {
		String res = "";
		for(int i=0;i<pos;i++) {
			res += s1.charAt(i);
		}
		for(int i=0;i<s2.length();i++) {
			res+=s2.charAt(i);
		}
		for(int i=pos;i<s1.length();i++) {
			res+=s1.charAt(i);
		}
		return res;
	}
	
	public String delete(String s1,String s2) {
		String res = "";
		int beg = s1.indexOf(s2);
		int end = beg+s2.length()-1;
		for(int i=0;i<s1.length();i++) {
			if(i>=beg && i<=end) {
				continue;
			}
			else{
				res += s1.charAt(i);
			}
		}
		
		return res;
	}
	
	public static void main(String args[]) {
		StringBuilder s1 = new StringBuilder();
		System.out.println("Appending string result: "+s1.append("hello", "world"));
		System.out.println("Inserting at position result: "+s1.insertPosition("Hello", "jj", 2));
		System.out.println("Deleting portion result: "+s1.delete("HelloWorld","orl"));
	}
}
