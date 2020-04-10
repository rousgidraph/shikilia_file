package filehandling;

import java.io.File;
import java.util.Scanner;

public class classFileDemonstration {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
        System.out.println("Enter directory or file name");
        analyze_path(input.nextLine());
    }


    public static void analyze_path(String path){
        File name = new File(path);
        if (name.exists()){
            System.out.printf("%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s",
                    name.getName(), " exists" ,
                    (name.isFile() ? "is a file " : "is not a file "),
                    (name.isDirectory() ? "Is directory ": "is not a directory"),
                    (name.isAbsolute() ? "is absolute path" : "is not absolute path"),
                    "last modified: ",name.lastModified(), "length: ",name.length(),"path: ",name.getPath(),
                    "absolute path: ",name.getAbsolutePath(),"parent: ",name.getParent());

            if (name.isDirectory()){
                String[] directory = name.list();
                System.out.println("\nDirectory contents:\n");

                for (String directoryname : directory)
                    System.out.println(directoryname);
            }

        }else {
            System.out.printf( "%s %s", path, "does not exist." );
        }
    }
}
