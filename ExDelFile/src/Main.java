import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<String> listPath = new ArrayList<>();
    public static List<File> listText = new ArrayList<>();
    public static List<File> listChoose = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        delFileLikeContent("D:\\test", "Ntest1.txt");
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

    public static void isFileDel(String fileChoose){
        for(int i = 0; i < listText.size(); i++){
            if(fileChoose.equals(listText.get(i).getName()))
                listChoose.add(listText.get(i));
        }

        for(int i = 0; i < listChoose.size(); i++){
            System.out.println(listChoose.get(i));
        }

    }

    public static void delFileLikeContent(String folderPath, String fileName) throws IOException {
        getListFiles(folderPath);
        isFileDel(fileName);
        String vlContent = "";

        for(int i = 0; i < listChoose.size(); i++){
            String flag = listChoose.get(0).toString();
            String vlName = listChoose.get(0).getName();
            if(i != 0){
                vlContent = listChoose.get(i).toString();
                if(fileName.equals(vlName) && findSameText(flag, vlContent)){
                    System.out.println("Have delete : " + listChoose.get(i));
                    listChoose.get(i).delete();
                }
            }
        }
    }

    public static void getListFiles(String folderPath) throws IOException {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files.length == 0) {
            listPath.add(folder.getCanonicalPath());
        }
        for (File f : files) {
            if (f.isFile()) {
                listText.add(f);
            } else {
                getListFiles(f.getPath());
            }
        }
    }
}
