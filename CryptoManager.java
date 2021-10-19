/*
 * Class: CMSC203 CRN: 22507
 * Assignment 3 
 * Instructor: Farnaz Eivaz
 * 
 * Description: This program converts a string into cipher text using either the Caeser Cipher
 * or the Bellaso Cipher and also decrpts it using the same Cipher. 
    
 * Due: 10/10/2021
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   
   Programmer Abraham Lamidi
*/

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		
		//Takes in the string finds it length and compares each character in that string to make 
		//sure it is with limits of the upper and lower bounds
		int size = plainText.length();
		for (int i = 0; i < size; i++) {
			if (plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		
		//Encrypts a string using the Caeser Cipher by using a integer key and returns the 
		//encrypted string  
		String encrypted = "";
		key = key % RANGE;
		
		int size = plainText.length();
		for (int i = 0; i < size; i++) {
			int a = (int)plainText.charAt(i) + key;
			while(a > UPPER_BOUND) {
				a-=RANGE;
			}
			encrypted+=(char)a;
		}
		return encrypted;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		
		//Encrypts a string using the Bellaso Cipher by using the ASCII values and returns the 
		//encrypted string

		String encrypted = "";
		int size = plainText.length();
		
		for (int i = 0; i < size; i++) {
			int j = i % bellasoStr.length();
			int a = plainText.charAt(i) + bellasoStr.charAt(j);
			
			while (a > UPPER_BOUND) {
				a-=RANGE;
			}
			encrypted+=(char)a;
		}
		return encrypted;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		
		//Decrypts a string using the Caeser Cipher replacing the offset characters with the 
		//original text using the key and returns the original string.
		String decrypted = "";
		key%=RANGE;
		int size = encryptedText.length();
		
		for (int i = 0; i < size; i++) {
			int a = (char)(encryptedText.charAt(i) - key);
			while (a < LOWER_BOUND) {
				a+=RANGE;
			}
			decrypted+=(char)a;
		}
		return decrypted;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		
		
		//Decrypts a string using the Bellado Cipher replacing the offset characters with the 
		//original text using the ASCII values and returns the original string.
		String decrypted = "";
		int size = encryptedText.length();
		
		for (int i = 0; i < size; i++) {
			int j = i % bellasoStr.length();
			int a = encryptedText.charAt(i) - bellasoStr.charAt(j);
			
			while (a < LOWER_BOUND) {
				a+=RANGE;
			}
			decrypted+=(char)a;
		}
		return decrypted;
	}
}

//Abraham Lamidi wrote this code.
