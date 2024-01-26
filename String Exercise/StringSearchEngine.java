package some;

public class StringSearchEngine {
	
	public int substrFreq(String sub, String str) {
		int M = sub.length();
        int N = str.length();
        int res = 0;
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (str.charAt(i + j) != sub.charAt(j)) {
                    break;
                }
            }
            if (j == M) {
                res++;
                j = 0;
            }
        }
        return res;
	}
	
	public String highlightOccurence(String sub, String str) {
		String[] s = str.split(sub);
		String res = "";
		for(int i=0; i<s.length; i++) {
			res = res + s[i] + "'" + sub + '\'' + "";
		}
		int k = substrFreq(sub,str) - substrFreq(sub,res);
		if(k!=0) {
			for(int j=0; j<k; j++) {
				res = res + "'" + sub + '\'' + "";
			}
		}
		return res;
	}
	
	public static void main(String args[]) {
		String str = "Banana";
		String sub = "na";
		StringSearchEngine sse = new StringSearchEngine();
		System.out.println("No.of occurences of "+sub+" in "+str+" is: "+sse.substrFreq(sub, str));
		System.out.println("Occurences are: "+sse.highlightOccurence(sub, str));
	}
}
