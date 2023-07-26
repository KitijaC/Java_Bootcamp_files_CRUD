import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileManager {
    // creating file
    // updating file
    // deleting file
    // reading content of file

    public void createFile(String fileName) {
        File file = new File(fileName);
        try{
            if(file.createNewFile()) {
                // do something
                System.out.println("file created successfully with name " + fileName);
            } else {
                // do something else
                System.out.println("file already exist");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void updateFileContent(String fileName, String contentToAdd){
        try {
            //FileWriter fileWriter = new FileWriter(fileName); // overwrites the previous content
            // append mode allow us to add new content to existing file, without removing the previous content
            FileWriter fileWriter = new FileWriter(fileName, true); // preserve existing content
            // escape sequence allows us to add spaces, new line to the content \n - new line \t \r
            fileWriter.write(contentToAdd + "\n");
            fileWriter.close();
            System.out.println("content was added to file: " + fileName);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void getFileContent(String fileName) {
        File file = new File(fileName);
        String fileContent = "";

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                fileContent += scanner.nextLine() + "\n";
            }

            System.out.println("content of file: " + fileName);
            System.out.println(fileContent);
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteFile(String fileName){
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println(fileName + " deleted successfully");
        } else {
            System.out.println("problem deleting file");
        }
    }

    public void addContentFromArrayList(String fileName, ArrayList<SampleContent> contentList){
        String allContentAsString = contentList
                                        .stream()
                                        .map(SampleContent::toString)
                                        .collect(Collectors.joining(""));
        /* this is the same as above
        for (SampleContent sampleContent: contentList) {
            allContentAsString += sampleContent.toString();
        }*/

        this.updateFileContent(fileName, contentList.toString());
    }

}
