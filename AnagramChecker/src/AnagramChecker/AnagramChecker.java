package AnagramChecker;

import java.util.*;
import java.io.*;

public class AnagramChecker {
	public static void main(String[] args){
		AnagramChecker test = new AnagramChecker();
		List<String> words = test.readText();
		
		System.out.print(test.returnAnagrams("pears", words));
		System.out.print("\n");
		System.out.print(test.returnAnagrams("alters", words));
		System.out.print("\n");
		System.out.print(test.returnAnagrams("slate", words));
		System.out.print("\n");
		System.out.print(test.returnAnagrams("pots", words));
		System.out.print("\n");
		System.out.print(test.returnAnagrams("ears", words));
		System.out.print("\n");
		
	}
	
	public List<String> returnAnagrams(String word, List<String> words){
		List<String> anagrams = new ArrayList<String>();
		int lengthWord = word.length();
		List<String> reducedList = new ArrayList<String>();
		
		for (int i=0; i  <  words.size(); i++){
			if (words.get(i).length() == lengthWord){
				reducedList.add(words.get(i));
			}
		}
		
		List<Character> wordAsChars = new ArrayList<>();
		for (char ch: word.toCharArray()){
			wordAsChars.add(ch);
		}
		
		for (int i=0; i < reducedList.size(); i++){
			List<Character> testAsChars = new ArrayList<>();
			for (char ch: reducedList.get(i).toCharArray()){
				testAsChars.add(ch);
			}
			boolean isAnagram =  true;
			
			for(char ch: wordAsChars){
				if (testAsChars.contains(ch)){
					testAsChars.remove(new Character(ch));
				}
				else{
					isAnagram = false;
				}
				
			
			}
			if (isAnagram){
				anagrams.add(reducedList.get(i));
			}
		}
		
		
		
		
		
		
		
		
		return anagrams;
	}
	
	public List<String> readText(){
		
		try{
			File file = new File("english.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			StringBuffer sb = new StringBuffer();
			String line;
			while((line = br.readLine())!= null){
				sb.append(line);
				sb.append("\n");
			}
			fr.close();
			String sb_as_str = sb.toString();
			String str[] = sb_as_str.split("\n");
			List<String> str_list = new ArrayList<String>();
			str_list = Arrays.asList(str);
			return str_list;
			
		}
		catch(IOException e){
			e.printStackTrace();
			return null;
		}
		
	}
}
