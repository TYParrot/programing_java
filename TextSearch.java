
public class TextSearch {
	/*문자열이 주어졋을 때, 찾고 싶은 문자가 위치한 자리를 찾는다.
	 * @param char c-찾고 싶은 문자
	 * @param String s-주어진 문자열 */
	public int findChar(char c, String s) {
		boolean found = false;
		int index = 0;
		while(!found&&index<s.length()) {
			if(s.charAt(index)==c)
				found=true;
			else 
				index=index+1;
		}
		if(!found)
			index=-1;
		return index;
	}
	public static void main(String[] args) {
		TextSearch text_search =new TextSearch();
		System.out.println(text_search.findChar('p', "happy birthday!"));

	}

}
