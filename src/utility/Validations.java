/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

/**
 *
 * @author sushant saini
 */
public class Validations {
    public static boolean isEmpty(String value){
        if(value!=null){
            return value.trim().isEmpty();
        }
        return false;
    }
     public static boolean isLetterAndSpace(String value){
        if(value!=null){
           for(int i=0;i<value.length();i++)
           {
               char ch=value.charAt(i);
               if(Character.isLetter(ch)||Character.isWhitespace(ch))
               {}
               else
               { 
                   return false;
               }
           }
           return true;
        }
        return false;
    }
    public static boolean isInteger(String value){
        try{
        if(value!=null){
            Integer.parseInt(value.trim());
            
            return true;
        }}catch(NumberFormatException ex)
        {
        }
        return false;
    }
    public static boolean isFloat(String value){
        try{
        if(value!=null){
            Float.parseFloat(value.trim());
            
            return true;
        }}catch(NumberFormatException ex)
        {
        }
        return false;
    }
    public static boolean isValidImage(String value){
        if(value!=null){
            int index = value.lastIndexOf(".");
            if(index != -1){
                String extension = value.substring(index+1);
                String extensions = "jpg,jpeg,png,bmp,gif";
                return extensions.contains(extension.toLowerCase());
            }
        }
        return false;
    }
}
