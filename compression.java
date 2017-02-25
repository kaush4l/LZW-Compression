/*  By Kaushal kanakamedala 
 *  800936486   */


//Imported declarations
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

 
public class compression {
	
	//Declarations
	static int bit;
	static int dictSize;
	static int maxS;
	static String out = "";
	
	
	// Compress a give file by converting to a list of output symbols. 
    public static String compress(String uncompressed) {

//    public static List<Integer> compress(String uncompressed) {
        // Build the dictionary.
        dictSize = 256 ;
        
        Map<String,Integer> dictionary = new HashMap<String,Integer>();
        
        //256 ASCII characters
        for (int i = 0; i < 256; i++)
            dictionary.put("" + (char)i, i);

        //Loop for new characters
        String a = "";
        List<Integer> result = new ArrayList<Integer>();
        for (char c : uncompressed.toCharArray()) {
            String ac = a + c;
            if (dictionary.containsKey(ac))
                a = ac;
            else {
                result.add(dictionary.get(a));
                if(dictionary.size() < maxS){
                // Add new word to the dictionary.
                dictionary.put(ac, dictSize++);
                }
                a = "" + c;
            }
        }

        // Output the code for Word.
        if (!a.equals(""))
            result.add(dictionary.get(a));
        for(int i = 0; i < result.size(); i++){
        	String bcode = Integer.toBinaryString( 0x10000 | result.get(i)).substring(1);
        	out  = out + bcode;
        	System.out.println(bcode);
        }
        return out;

//        return result;
    }
   


    /**Decompress by loading file and decoding. 
     * 
     * Decompress a list of output ks to a string. */
    public static String decompress(String compressed) {
    	
    	List<Integer> sol =  new ArrayList<Integer>();
    	char code[] = compressed.toCharArray();
    	String c="";
        // Build the dictionary.
        int dictSize = 256;
        Map<Integer,String> dictionary = new HashMap<Integer,String>(); 
        for (int i = 0; i < 256; i++)
            dictionary.put(i, "" + (char)i);
        
        for(int i = 0; i < compressed.length(); i++){
        	c = c + code[i];
    		if( i % 16 == 15){
    		//decode
//    			String bcode = Integer.toDecimalString( 0x10000 | result.get(i)).substring(1);
    			int key = Integer.parseInt(c.trim(), 2 );
    			sol.add(key);
    			c="";
    		}
    	}
        
        
        //Decoding string by string.
//        String w = "" + (char)(int)compressed.remove(0);
        String w = "";
        StringBuffer result = new StringBuffer(w);
        for (int i : sol) {
            String entry;
            if (dictionary.containsKey(i))
                entry = dictionary.get(i);
            else if (i == dictSize)
                entry = w + w.charAt(0);
            else 
                throw new IllegalArgumentException("Bad compressed k: " + i);
 
            result.append(entry);
 
            if(dictionary.size() < maxS){
            // Add w+entry[0] to the dictionary.
            dictionary.put(dictSize++, w + entry.charAt(0));
            }
            w = entry;
        }
		return result.toString();
    }
    
 
    public static void main(String[] args) throws Exception {
    	
    	//Defining the length of input dictionary for manual compression
    	System.out.println("The bit of input dictionary would be :");
          	

    	
    	Scanner in = new Scanner(System.in);
    	bit = in.nextInt();
    	in.close();
        maxS = (int) Math.pow(2, bit);
    	
//    	System.out.println("The name of the input file is ");
//        Scanner name = new Scanner(System.in);
//        String fname = name.nextLine();
//        name.close();
    	
    	//Trying
    	@SuppressWarnings("resource") //To ignore all unwanted warnings.
		String content = new Scanner(new File("C:/Kaushal/more_examples/input4.txt")).useDelimiter("\\Z").next(); //Read data into character
//		String content = new Scanner(new File("C:/Kaushal/examples/"+fname+".txt")).useDelimiter("\\Z").next(); //Read data into character
    	System.out.println(content);
    	
    	
    	//Calling function and printing output                                                                         file name here 
    	String compressed = compress(content); //                                                                           |
    	System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("C:/Users/kaush/Downloads/Downloads/Output.txt")), true));
    	System.out.println(compressed);
    	
    	//Calling function and printing output                                                       File address
//    	String compressed = compress(content);                                                            |
//    	System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("C:/Users/kaush/Downloads/Downloads/Output.txt")), true));
//    	System.out.println(compressed);
    	
    	
    	//                                                                                                           Output file name
    	String decompressed = decompress(compressed);//                                                                    |
    	System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("C:/Users/kaush/Downloads/Downloads/Output1.txt")), true));
    	System.out.println(decompressed);
    	
//    	String decompressed = decompress(compressed);
//    	System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("C:/Users/kaush/Downloads/Downloads/Output1.txt")), true));
//    	System.out.println(decompressed);

    }
}