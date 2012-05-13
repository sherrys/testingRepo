package dt7;

import java.util.Hashtable;
import java.util.Set;

public class Censoring {
    private boolean upperCase;
    Hashtable<String, String> subTable;
    public Censoring() {
        subTable = new Hashtable<String, String>();
        subTable.put("lie", "truth");
        subTable.put("censor", "protect");
        subTable.put("censorship", "protection");
        subTable.put("dictator", "big brother");
        subTable.put("refugee", "illegal immigrant");
        subTable.put("injustice", "strict justice");
        subTable.put("conroy","Dear Leader");
        subTable.put("intellectual", "ivory tower elite");
        subTable.put("gunns", "The Tasmanian Government");
        addToHashTable();
    }
    
    public void addToHashTable(){
        subTable.put("lied", "told the truth");
        subTable.put("censored", "protected");
        subTable.put("lies", "truths");
        subTable.put("censors", "protects");
        subTable.put("censorships", "protections");
        subTable.put("dictators", "big brothers");
        subTable.put("refugees", "illegal immigrants");
        subTable.put("intellectuals", "ivory tower elites");
        subTable.put("lying", "telling the truth");
        subTable.put("censoring", "protecting");
        
    }
    
    public String ChangeString(String original) {
        original = checkUpperCase(original);
        Set<String> keys = subTable.keySet();
        for(String key : keys){
            original = original.replaceAll("\\b" + key +"\\b", subTable.get(key));
        }
        if(upperCase){
            original = convertToUpper(original);
        }
        return original;
    }
    
    public String checkUpperCase(String original){
        if (Character.isUpperCase(original.charAt(0))){
            upperCase = true;
            original = original.replace(original.charAt(0), (char) (original.charAt(0) + 32));
            
        }else{
            upperCase = false;
        }
        return original;
    }
    
    public String convertToUpper(String modified){
        upperCase = false;
        String subString1 = modified.substring(0, 1);
        subString1=subString1.toUpperCase();
        String subString2 = modified.substring(1);
        subString1 = subString1.concat(subString2);
        return subString1;
        
    }
}
