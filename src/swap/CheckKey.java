package swap;

import java.util.ArrayList;
import java.util.List;

public class CheckKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	    for(int key =1; key <= 0xFFF; key++ ){   
		    int key = 0x0003FF; 
            List<Integer> list = new ArrayList<Integer>();
            list.add((key & 0xFF0000)>>16 );
            list.add((key & 0x00FF00)>>8);
            list.add(key & 0x0000FF);
            System.out.println(list.get(0));
            System.out.println(list.get(1));
            System.out.println(list.get(2));
            
//	    }
	}

}
