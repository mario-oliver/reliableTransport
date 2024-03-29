import java.util.*;

public class UnderCoverCoder {
	public int totalNotes(String[] clips, String[] notes) {
		// fill in code here
		int count = 0; 
		Map<Character, Integer> clipsMap = mapClips(clips);
		for(String note : notes){
			Map<Character, Integer> noteMap = mapNotesString(note);
			if(countTrue(clipsMap, noteMap)){
				count++;
			}
		}
		
		
		
		return count;
	}
	
	public boolean countTrue(Map<Character, Integer> clips, Map<Character, Integer> note){
		for(Character key : note.keySet()){
			int noteCount = note.get(key);
			Integer clipsCount = clips.get(key);
			if(clipsCount == null){
				return false;
			} 
			if(key == ' '){
				if(clipsCount == 0){
					return false;
				}
			}
			else if(clipsCount < noteCount){
				return false;
			}
			
		}
		
		return true; 
	}
	
	public Map<Character, Integer> mapClips(String[] clips) {
		// fill in code here
		Map<Character, Integer> letters = new TreeMap<Character, Integer>();
		for (int i = 0; i < clips.length; i++) {
			String lowerCase = clips[i].toLowerCase();
			for (int j = 0; j < lowerCase.length(); j++) {
				Character c = lowerCase.charAt(j);
				if (letters.containsKey(c)) {
					letters.put(c, letters.get(c) + 1);
				} else {
					letters.put(c, 1);
				}
			}
		}
		return letters;
	}

	public Map<Character, Integer> mapNotesString(String note) {
		Map<Character, Integer> letters = new TreeMap<Character, Integer>();
		String lowerCase = note.toLowerCase();
		for (int j = 0; j < lowerCase.length(); j++) {
			Character c = lowerCase.charAt(j);
			if (letters.containsKey(c)) {
				letters.put(c, letters.get(c) + 1);
			} else {
				letters.put(c, 1);
			}
		}
		return letters;
	}

	/*public void main(String [] args){
		String[] clips = {"Earthquake in San Francisco","Burglary at museum in Sweden", "Poverty"};
		String[] notes = {"Give me my money back", "I am the best coder","I is TOPCODER"};
		System.out.println(totalNotes(clips, notes));
		
	}*/
}
