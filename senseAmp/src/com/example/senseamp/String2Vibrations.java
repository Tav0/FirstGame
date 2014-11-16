package com.example.senseamp;

import java.util.ArrayList;
import java.util.Arrays;

public class String2Vibrations {

    public Long time = 200L;
    public Long dit = time; //short vibration
    public Long dah = 3*time; //long vibration
    public Long pspa = 2*time; //letter space
    public Long wspa = 6*time; //word space

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param input
     * @return word
     */
    public long[] getVibrations(String input) {
        String spacedStr = spacedString(input);

        ArrayList<Long> vibrations =  new ArrayList<Long>();
        int i;
        char character;


        for (i = 0; i < spacedStr.length(); i++) {
            //System.out.println(spacedStr.charAt(i)); //to print on to screen.

            character = Character.toUpperCase(spacedStr.charAt(i));


            if (character == ' ')
                vibrations.addAll(Arrays.asList(wspa, 0L));
            else if (character == 'A')
                vibrations.addAll(Arrays.asList(pspa, dit, pspa, dah));
            else if (character == 'B')
                vibrations.addAll(Arrays.asList(pspa,dah,pspa,dit,pspa,dit,pspa,dit));
            else if (character == 'C')
                vibrations.addAll(Arrays.asList(pspa,dah,pspa,dit,pspa,dah,pspa,dit));
            else if (character == 'D')
                vibrations.addAll(Arrays.asList(pspa,dah,pspa,dit,pspa,dit));
            else if (character == 'E')
                vibrations.addAll(Arrays.asList(pspa,dit));
            else if (character == 'F')
                vibrations.addAll(Arrays.asList(pspa,dit,pspa,dit,pspa,dah,pspa,dit));
            else if (character == 'G')
                vibrations.addAll(Arrays.asList(pspa,dah,pspa,dah,pspa,dit));
            else if (character == 'H')
                vibrations.addAll(Arrays.asList(pspa,dit,pspa,dit,pspa,dit,pspa,dit));
            else if (character == 'I')
                vibrations.addAll(Arrays.asList(pspa,dit,pspa,dit));
            else if (character == 'J')
                vibrations.addAll(Arrays.asList(pspa,dit,pspa,dah,pspa,dah,pspa,dah));
            else if (character == 'K')
                vibrations.addAll(Arrays.asList(pspa,dah,pspa,dit,pspa,dah));
            else if (character == 'L')
                vibrations.addAll(Arrays.asList(pspa,dit,pspa,dah,pspa,dit,pspa,dit));
            else if (character == 'M')
                vibrations.addAll(Arrays.asList(pspa,dah,pspa,dah));
            else if (character == 'N')
                vibrations.addAll(Arrays.asList(pspa,dah,pspa,dit));
            else if (character == 'O')
                vibrations.addAll(Arrays.asList(pspa,dah,pspa,dah,pspa,dah));
            else if (character == 'P')
                vibrations.addAll(Arrays.asList(pspa,dit,pspa,dah,pspa,dah,pspa,dit));
            else if (character == 'Q')
                vibrations.addAll(Arrays.asList(pspa,dah,pspa,dah,pspa,dit,pspa,dah));
            else if (character == 'R')
                vibrations.addAll(Arrays.asList(pspa,dit,pspa,dah,pspa,dit));
            else if (character == 'S')
                vibrations.addAll(Arrays.asList(pspa,dit,pspa,dit,pspa,dit));
            else if (character == 'T')
                vibrations.addAll(Arrays.asList(pspa,dah));
            else if (character == 'U')
                vibrations.addAll(Arrays.asList(pspa,dit,pspa,dit,pspa,dah));
            else if (character == 'V')
                vibrations.addAll(Arrays.asList(pspa,dit,pspa,dit,pspa,dit,pspa,dah));
            else if (character == 'W')
                vibrations.addAll(Arrays.asList(pspa,dit,pspa,dah,pspa,dah));
            else if (character == 'X')
                vibrations.addAll(Arrays.asList(pspa,dah,pspa,dit,pspa,dit,pspa,dah));
            else if (character == 'Y')
                vibrations.addAll(Arrays.asList(pspa,dah,pspa,dit,pspa,dah,pspa,dah));
            else if (character == 'Z')
                vibrations.addAll(Arrays.asList(pspa,dah,pspa,dah,pspa,dit,pspa,dit));
            else if (character == '1')
                vibrations.addAll(Arrays.asList(pspa,dit,pspa,dah,pspa,dah,pspa,dah,pspa,dah));
            else if (character == '2')
                vibrations.addAll(Arrays.asList(pspa,dit,pspa,dit,pspa,dah,pspa,dah,pspa,dah));
            else if (character == '3')
                vibrations.addAll(Arrays.asList(pspa,dit,pspa,dit,pspa,dit,pspa,dah,pspa,dah));
            else if (character == '4')
                vibrations.addAll(Arrays.asList(pspa,dit,pspa,dit,pspa,dit,pspa,dit,pspa,dah));
            else if (character == '5')
                vibrations.addAll(Arrays.asList(pspa,dit,pspa,dit,pspa,dit,pspa,dit,pspa,dit));
            else if (character == '6')
                vibrations.addAll(Arrays.asList(pspa,dah,pspa,dit,pspa,dit,pspa,dit,pspa,dit));
            else if (character == '7')
                vibrations.addAll(Arrays.asList(pspa,dah,pspa,dah,pspa,dit,pspa,dit,pspa,dit));
            else if (character == '8')
                vibrations.addAll(Arrays.asList(pspa,dah,pspa,dah,pspa,dah,pspa,dit,pspa,dit));
            else if (character == '9')
                vibrations.addAll(Arrays.asList(pspa,dah,pspa,dah,pspa,dah,pspa,dah,pspa,dit));
            else if (character == '0')
                vibrations.addAll(Arrays.asList(pspa,dah,pspa,dah,pspa,dah,pspa,dah,pspa,dah));
        }

        long[] result = new long[vibrations.size()];
        for(i = 0; i<vibrations.size(); i++){
            result[i] = vibrations.get(i);
        }

        return result;
    }

    // ----------------------------------------------------------
     /**
     * parse the string and add spaces in between letters
     * and have double space in a space in between words.
     * @param word
     * @return newWord
     */
    public String spacedString(String word) {

        /**
         * parse the string and add spaces in between letters
         * and have double space in a space in between words.
         */
            char[] chars = word.toCharArray();
            String newString = "";
            for(int i = 0; i < chars.length; i++) {
                if (i == (chars.length-1)) {
                    newString += chars[i];
                }
                else{
                    if (chars[i] != ' ') {
                    newString+=chars[i];
                    newString += " ";
                    }
                    else {
                        newString+=chars[i];
                    }
                }
            }
        return newString;
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param word
     * @return word size
     */
    public int sizestring(String word) {
        char[] sizearray = new char[(word.length())*2];
        return sizearray.length;
    }

}