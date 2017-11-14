package swap;

import java.util.ArrayList;
import java.util.List;

public class Swap {

	public static void main(String[] args) {
// key 555821	
//            int[] enCryted = {197, 175, 176, 77, 78, 253, 165, 88, 44, 84, 16, 214, 79, 208, 134, 184, 5, 87, 66, 16, 28, 233, 39, 54, 53, 4, 198, 231, 167, 29, 196, 232};
// key 0x3FF
//	        int[] enCryted = {246, 164, 53, 230, 66, 14, 180, 232, 155, 136, 137, 228, 186, 132, 108, 40, 97, 24, 165, 152, 164, 57, 71, 92, 114, 27, 244, 99, 179, 34, 70, 119};
// key 262156
		int[] enCryted = {34, 3, 188, 80, 145, 46, 40, 154, 43, 240, 231, 214, 84, 211, 242, 23, 181, 196, 255, 150, 92, 56, 24, 163, 15, 220, 181, 98, 192, 112, 142, 3};
		int[] deCryted;
            System.out.println("System start");
    for(int key =0; key <= 0xFFFFFF; key++ ){        
            List<Integer> list = new ArrayList<Integer>();
            list.add((key & 0xFF0000)>>16 );
            list.add((key & 0x00FF00)>>8);
            list.add(key & 0x0000FF);

            // Task 1 - reinitialize the ary 
	        int[] ary = new int[256];
	        int i;
            for(i=0; i< 256; i++) {
    		  ary[i] = i; 
            }
            // Task 2 - swap based on the key
            int j=0;

            for(int t=0; t<256;t++) {
            	j = (j + ary[t] + list.get(t%3))%256;
            	int temp = ary[j];
            	ary[j] = ary[t];
            	ary[t] = temp;
    	//System.out.println("move from " + Integer.toHexString(ary[t]) + " to "+ Integer.toHexString(ary[j]) + "the index is "+ t);
            }
            // Task 3 - XOR
   
            deCryted = new int[32];
            i = 0;
            j = 0;
            int k;
            for( k=0; k< 32; k++){
                i = (i+1) % 256;
                j = (j + ary[i]) % 256;
                int tem = ary[i];
                 ary[i] = ary[j];
                 ary[j] = tem;
                int f = ary[(ary[i]+ary[j])%256];
                System.out.println("we get " + f);
                int result = (f ^ enCryted[k]);
                if( (result >= 97 && result <= 122) | (result == 32) ){
                    deCryted[k] = result;
                }
                else break;

            }
            if(k == 32) {
        		for(int cha = 0; cha < 32; cha++) {
    			System.out.print((char)deCryted[cha]+ " ");
    		    }
        		System.out.println("the key is" + key);
        		break;
            }
			System.out.println("one loop");
        }
	}


}
