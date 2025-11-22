package artifact;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Nonrepeated {

	public static void main(String[] args) {
		
		String str="aaaa bbbb cccc dddd";
		String strq[]=str.split(" ");
		Set<Character> ch=new LinkedHashSet<Character>();
		for(int i=0;i<strq.length;i++) {
			for(int j=0;j<strq[i].length();j++) {
				
				ch.add(strq[i].charAt(j));
			}
		}
		
	java.util.Iterator<Character> it =ch.iterator();
	String output="";
	while(it.hasNext())
	{
		output=output+it.next();
	}
	System.out.println(output);
	}

}
