package filehandling;


import java.io.FileNotFoundException;
import java.io.*;
import java.nio.*;
import java.util.ArrayList;
import java.util.Scanner;


public class file_handling {


    private static void writer(){
        try {
            DataInputStream dis = new DataInputStream(System.in);

            FileOutputStream fout = new FileOutputStream("file.txt");

            BufferedOutputStream bout = new BufferedOutputStream(fout,1024);
            System.out.println("Enter text (@ at the end: ");
            char ch;

            while((ch = (char)dis.read())!='@'){
                bout.write(ch);
            }
            bout.close();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int i;

        System.out.println("Enter the stuff you want to save...");
        writer();

        System.out.println("enter a valid path to a file\npath => ");
        String path = reader.nextLine();


        //String path = "/home/gidraph/Desktop/hashCode/a_example.in";
        FileInputStream fin;

      if(path.length() <= 1){
          System.out.println("Usage: showFile filename ");
      return;
      }
      try{
          fin = new FileInputStream(path);
      }catch(FileNotFoundException er){
          System.out.println("Confirm the location of that file.");
          return;
      }

        ArrayList<Integer> input = new ArrayList<Integer>();

        int count=0;
      try{
          do{
              i = fin.read();
              if(i != -1 ){
                  System.out.print((char) i);
                  if(i != ' '){

                  }else {

                  }
                  if (i =='\n'){
                      count++;
                  }
                  }
          }while(i != -1);
          System.out.println("That document has "+count+" lines");
      }catch (IOException e){
          System.out.println("Error reading file");
      }

      try{
          fin.close();
      }catch (IOException e){
          System.out.print("Error closing file");
      }



    }



}
