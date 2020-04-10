package filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class tell_me_whats_in_that_file {
    private List<String > look_for_me;
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.printf("%s","Bring em on");
        String path = reader.next();
        analize_file(path);
    }

    private static void analize_file(String path){
        File file = new File(path);
        if (!file.isFile()){
            System.out.println("Well that not a file now is it");
            return;
        }else if (!file.canRead()){
            System.out.println("Try giving me something that i can actually read");
            return;
        }

        FileInputStream fin;
        List<String> words = new LinkedList<String>();
        int r;
        try{
            fin = new FileInputStream(path);
            StringBuilder sb = new StringBuilder();
            do {
              r = fin.read();
              if ((r == '\n') ||(r == ' ') ){
                  words.add(sb.toString());
                  sb.delete(0,sb.length());
              }else{
                  sb.append((char) r);
              }

            }while (r != -1);

            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Integer> map = stringIntegerMap();
        for(String curr : words){
            String word = curr.toLowerCase();
            if (map.containsKey(word)){
                int count = map.get(word);
                map.put(word,count+1);
            }

        }
        displayList(words);
        displayMap(map);
    }
    public static void displayList(List<String> list ){
        System.out.println("\n\n List Output\n");
        for(String curr : list){
            System.out.println(curr);
        }
    }

    private static Map<String, Integer> stringIntegerMap(){
        System.out.println("Enter the words you want to look for with spaces");
        Scanner reader = new Scanner(System.in);
        String words = reader.nextLine();
        Map<String , Integer> map = new HashMap<String, Integer>();
        String[] WORDS_ARRAY = words.split(" ");
        for(String curr : WORDS_ARRAY){
            map.put(curr,0);
        }
        return map;
    }

    private static void displayMap(Map<String,Integer> map){
        Set<String > keys = map.keySet();
        TreeSet<String> sortedkeys = new TreeSet<String>(keys);
        for(String curr : sortedkeys){
            System.out.printf("%s\t\t%d\n",curr,map.get(curr));
        }
        System.out.printf("\n\nThe map size is %s\t\tThe map is empty %b",map.size(),map.isEmpty());
    }

}
