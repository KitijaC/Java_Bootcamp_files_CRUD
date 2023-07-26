import javax.swing.text.AbstractDocument;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();

        fileManager.createFile("zino");
        fileManager.createFile("zino.txt");
        fileManager.createFile("zino.pdf");
        fileManager.createFile("zino.csv");
        fileManager.createFile("zino.jpg");
        fileManager.createFile("sample.zino");

        //fileManager.createFile("data/zino.txt"); // make sure you have the right folder before running this line

        String contentToAdd = "Hello, I am an important file! :)";
        fileManager.updateFileContent("sample.zino", contentToAdd);

        String FILE_NAME = "sampleFile.txt"; // file we are working with

        // create file
        fileManager.createFile(FILE_NAME);

        // update file
        fileManager.updateFileContent(FILE_NAME, "some information");

        // read content
        fileManager.getFileContent("sample.zino");
        fileManager.getFileContent(FILE_NAME);

        // delete file
        fileManager.deleteFile("zino");
        fileManager.deleteFile("sample.zino");
        fileManager.deleteFile(FILE_NAME);

        System.out.println("=== ArrayList and Files ===");

        ArrayList<SampleContent> arrayOfContent = new ArrayList<>();

        arrayOfContent.add(new SampleContent("Some stuff"));
        arrayOfContent.add(new SampleContent("Something Else"));
        arrayOfContent.add(new SampleContent("Another thing"));
        arrayOfContent.add(new SampleContent("Yayy something"));

        fileManager.createFile("arrayListFile.csv");
        fileManager.addContentFromArrayList("arrayListFile.csv", arrayOfContent);
    }
}
