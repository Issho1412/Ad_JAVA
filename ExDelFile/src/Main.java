import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<String> listPath = new ArrayList<>();
    public static List<File> listText = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        delFileLikeContent("D:\\test", "New.txt");
    }

    public static String getContentFile(String filename) throws IOException {
        String str = "", line;
        Reader reader = new FileReader(filename);
        BufferedReader br = new BufferedReader(reader);
        while ((line = br.readLine()) != null){
            str += line + '\n';
        }
        reader.close();
        return str;
    }

    public static boolean findSameText(String file1, String file2) throws IOException{
        boolean isEqual = true;
        String txtF1 = getContentFile(file1);
        String txtF2 = getContentFile(file2);

        if(txtF1.equals(txtF2)){
            isEqual = true;
        }
        else isEqual = false;
        return isEqual;
    }

    public static void delFileLikeContent(String folderPath, String fileName) throws IOException {
        getListFiles(folderPath);
        String vlContent = "";
        String vlPath = folderPath+ "\\" +fileName;
        System.out.println(vlPath);
        for(int i = 1; i < listText.size(); i++){
           vlContent = listText.get(i).getName();
           if(vlContent.equals(fileName) || findSameText(vlPath, listText.get(i).toString())){
               System.out.println("I Have Deleted: " + listText.get(i));
              listText.get(i).delete(); //is testing
           }
        }
        System.out.println("\n\n");
    }

    public static void getListFiles(String folderPath) throws IOException {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files.length == 0) {
            listPath.add(folder.getCanonicalPath());
        }
        for (File f : files) {
            if (f.isFile()) {
                listPath.add(f.getName());
                listText.add(f);
            } else {
                getListFiles(f.getPath());
            }
        }
    }
}
