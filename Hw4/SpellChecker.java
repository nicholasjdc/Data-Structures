import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;
public class SpellChecker implements SpellCheckerInterface{

	HashSet<String> wordList;

	public SpellChecker(String filename){
		wordList = new HashSet<>();
		File dictionary = new File(filename);
		
		try{
			Scanner s = new Scanner(dictionary);
			while(s.hasNextLine()){
				wordList.add(s.nextLine());
			}

		}catch(FileNotFoundException e){
			System.err.println("File does not exist");
			System.exit(-1);
		}

	}
	public List<String> getIncorrectWords(String filename){
		List<String> incorrectWords = new LinkedList<String>();
		File f = new File(filename);

		try{
			Scanner s = new Scanner(f);
			while(s.hasNextLine()){

				String[] currentLine = s.nextLine().toLowerCase().split("[^A-Za-z0-9]+");
				for(String word: currentLine){
					if(word != null && !word.equals("") && !word.equals(" ")){
						incorrectWords.add(word);
					}
				}
			}

		}catch(FileNotFoundException e){
			System.err.println("File does not exist");
			System.exit(-1);
		}
		List<String> tempIncorrectWords = new LinkedList<>(incorrectWords);

		for(String word: tempIncorrectWords){
			for(String correctWord: wordList){
				if(word.equals(correctWord)){
					incorrectWords.remove(word);
				}
			}
		}

		return incorrectWords;

	}
	public Set<String> getSuggestions(String word){

		Set<String> suggestions = new HashSet<String>();
		ArrayList<String> charList=  new ArrayList<>(Arrays.asList(word.split("")));
		ArrayList<String> tempCharList = new ArrayList<>(charList);
		String[] alphabet = new String[]{"a","b","c","d","e","f","g","h","i","g","k","l","m","n","o","p","q", "r","s","t","u","v","w","x","y","z"};

		//Check new letter at each position
		for(int i = 0; i<= charList.size(); i++){
			tempCharList = new ArrayList<>(charList);
			for(String c: alphabet){
				tempCharList = new ArrayList<>(charList);
				tempCharList.add(i,c);
				String newWord = String.join("", tempCharList);
				for(String correctWord: wordList){
					if(correctWord.equals(newWord)){
						suggestions.add(correctWord);
					}
				}
			}
		}

		//Remove one character
		for(int i = 0; i< charList.size(); i++){
			tempCharList = new ArrayList<>(charList);
			tempCharList.remove(i);
			String newWord = String.join("", tempCharList);
			for(String correctWord: wordList){
				if(correctWord.equals(newWord)){
					suggestions.add(correctWord);
				}
			}
			
		}

		//Swap adjacent characters
		for(int i = 0; i< charList.size()-1; i++){
			tempCharList = new ArrayList<>(charList);
			String previousLetter = tempCharList.get(i);
			tempCharList.set(i, tempCharList.get(i+1));
			tempCharList.set(i+1, previousLetter);
			String newWord = String.join("", tempCharList);
			for(String correctWord: wordList){
				if(correctWord.equals(newWord)){
					suggestions.add(correctWord);
				}
			}
			
		}

		return suggestions;

	}
}
