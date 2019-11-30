import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.text.Normalizer;
import java.util.Scanner;

public class ReadLocalFile {
    public static void main(String[] args) throws IOException {
//        System.out.println("This is file not utf-8");
//        String str1 = read("E:\\Vd.txt");
//        System.out.println(str1);
//
//        System.out.println("This is file utf-8");
//        String str2 = readUTF8("E:\\Vd.txt");
//        System.out.println(str2 + '\n');
//
//        String str3 = convertS(str2);
//        System.out.println(str3 + '\n');
//
//        System.out.println("This is file is read by line (not utf8)");
//        String str4 = readLine("E:\\Vd.txt");
//        System.out.println(str4);

//        System.out.println("This is file is read by line (utf8)");
//        String str5 = readLineUTF8("E:\\Vd.txt");
//        System.out.println(str5);

//        System.out.println("Get file Online");
//        String str6 = readOnlineResource("https://raw.githubusercontent.com/nam-long/learning-java/master/resources/ca-dao.txt");
//        System.out.println(str6 + '\n');
       // saveFile("E:\\thenew.txt", str6);

        String as = readOnlineResource("https://www.fnordware.com/superpng/pnggradHDrgba.png");


//        System.out.println("Read buffer can get utf8 and unicode");
//        String str7 = readBuffer("E:\\Vd.txt");
//        System.out.println(str7);

    }

    public static String read(String filename) throws IOException {
        String str = "";

        InputStream is = new FileInputStream(filename);
        int c;
        while((c = is.read()) != -1){
            str += (char)c;
        }
        is.close();
        return str;
    }

    public static String readUTF8(String filename) throws IOException {
        String str = "";

        Reader is = new FileReader(filename);
        int c;
        while((c = is.read()) != -1){
            str += (char)c;
        }
        is.close();
        return str;
    }

    public static String readLine(String filename) throws IOException {
        String str = "";

        InputStream is = new FileInputStream(filename);
        DataInputStream dis = new DataInputStream(is);
        String line;
        while ((line = dis.readLine()) != null) {
            str += line + '\n';
        }
        is.close();
        return str;
    }

    public static String readLineUTF8(String filename) throws IOException {
        String str = "";
        Reader reader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while((line = bufferedReader.readLine()) != null){
            str += line + '\n';
        }
        bufferedReader.close();
        return str;
    }

    public static String convertS(String filename) throws IOException {
        return java.text.Normalizer.normalize(filename, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}","");
    }


    public static int[] convert(String st){
        int [] result = new int[st.length()];
        for(int i = 0; i < st.length(); i ++){
            result[i] = st.charAt(i);
        }
        return result;
    }

    public static String readBuffer(String filename) throws IOException {
        String str = null;
        byte[] buffer = new byte[10]; //[0][1][2]
        InputStream is = new FileInputStream(filename);
        BufferedInputStream bis = new BufferedInputStream(is);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int count;
        while ((count = bis.read(buffer)) != -1){
            baos.write(buffer, 0, count);
        }
        str = new String(baos.toByteArray());
        baos.close();
        is.close();
        return str;
    }

    public static void saveFile(String filename, byte [] data) throws IOException{
        FileOutputStream outputStream = new FileOutputStream(filename);
        outputStream.write(data);
        outputStream.close();

        /*
        PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
        writer.println("The first line");
        writer.println("The second line");
        writer.close();
        https://cdn.pixabay.com/photo/2017/01/03/02/07/vine-1948358__340.png
         */
    }

    public static String readOnlineResource(String strURL) throws IOException{
        String str = "";
        URL url = new URL(strURL);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

        int responseCode = conn.getResponseCode();
        if (responseCode == HttpsURLConnection.HTTP_OK) {

            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[100];
            int count;
            while ((count = bis.read(buffer)) != -1) {
                baos.write(buffer, 0, count);
            }
            str = new String(baos.toByteArray());
            saveFile("D:\\tes.png",baos.toByteArray());
            is.close();
        }
        return str;
    }
}

