// all credit: http://gleichmann.wordpress.com/2008/01/13/building-your-own-literals-in-java-lists-and-arrays/
// read license of use there

package literal;

import java.util.Arrays;
import java.util.List;

public class collection {

	public static <T> List<T> List(T...elems){
		return Arrays.asList( elems );
	}
}