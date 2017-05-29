/*  By Kaushal kanakamedala 
 *  800936486   */


//Imported declarations
//LZW compression
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Compress {
	public static void main(String[] args) throws IOException{
		ArrayList<Integer> encoded = encode.comp("abbbab", 10);
		System.out.println(encoded);
	}
}

class encode{
	public static ArrayList<String> comp(String original, int bit){
		
		ArrayList<String> encode = new ArrayList<String>();
		HashMap<String, Integer> dict = new HashMap<String, Integer>();
		int maxSize = (int) Math.pow(2, bit);
		for (int i = 0; i < 256;  i++){
			dict.put((char)i+ "", i);
		}
		String code = "";
		String STRING = "";
		for(char c : original.toCharArray()){
			code = String.valueOf(c);
			if (dict.containsKey(STRING + code)){
				STRING = STRING + code;
			} else {
				encode.add(Integer.toBinaryString(0x10000 | dict.get(STRING)));
				if (dict.size() < maxSize){
					dict.put(STRING + code, Collections.max(dict.values()) + 1);
					STRING = code;
				}
			}
		}
		encode.add(Integer.toBinaryString(0x10000 | dict.get(STRING)));
		return encode;
	}
}

