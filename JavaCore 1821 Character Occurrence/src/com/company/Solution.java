package com.company;

/*
1821 Character Occurrence

The program starts with one parameter - the file name,
which contains english text.
Calculate the frequency of occurrence of each character.
Sort the result in ascending ASCII code (read on the internet).
Example:
',' = 44, 's' = 115, 't' = 116.
Print the sorted result to the console:
[character1] frequency1
[character2] frequency2
Close streams.
Output Example:
, 19
- 7
f 361

Requirements:
1. You do not need to read anything from the console.
2. Create a stream for reading from the file, which comes as the first parameter to main.
3. In the file, you need to calculate the frequency of occurrence of each character and display the result.
4. The output displayed in the console should be sorted by ascending ASCII code.
5. The stream for reading from the file must be closed.
 */

import java.io.*;
import java.util.Map;
import java.util.TreeMap;



public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<Byte, Integer> frequencyMap = new TreeMap<Byte, Integer>();
        FileInputStream f = new FileInputStream(args[0]);
        while(f.available()>0) {
            byte[] buf = new byte[f.available()];
            f.read(buf);
            for(int i=0; i<buf.length; i++) {
                if(frequencyMap.containsKey(buf[i]))
                    frequencyMap.put(buf[i], frequencyMap.get(buf[i])+1);
                else
                    frequencyMap.put(buf[i], 1);
            }
        }
        f.close();
        for (Map.Entry pair:frequencyMap.entrySet()) {
            System.out.println((char)(byte)pair.getKey()+" "+pair.getValue());
        }
    }
}





