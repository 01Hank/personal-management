import com.baidu.aip.speech.AipSpeech;
import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;
import org.json.JSONObject;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.io.IOException;

public class musicTest {
    public static final String APP_ID = "6538545";
    public static final String API_KEY = "6XSaPA2KGPYsrKBIPt2gH2Yu";
    public static final String SECRET_KEY = "MYFIv2sEqIwQ1mClhbtoPvMnlPjT7PEc";

    public void test(){

    }

    public static  void main(String[] args){
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
        String path = "D:\\music\\test.mp3";
        String path2 = "D:\\music\\test.pcm";
        //convertMP32Pcm(path, path2);
        try {
            changePmcToMp3(path,path2);
            JSONObject asrRes = client.asr(path2, "pcm", 16000, null);
            System.out.println(asrRes);
            System.out.println(asrRes.get("result"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void changePmcToMp3(String mp3filepath, String pcmfilepath) throws Exception {

     String webroot = "E:\\ffmpeg-20190824-1cfba7f-win64-static\\bin";

     Runtime run = null;

   try {

     run = Runtime.getRuntime();

     long start=System.currentTimeMillis();

    System.out.println(new File(webroot).getAbsolutePath());

     //执行ffmpeg.exe,前面是ffmpeg.exe的地址，中间是需要转换的文件地址，后面是转换后的文件地址。-i是转换方式，意思是可编码解码，mp3编码方式采用的是libmp3lame

     //wav转pcm

     //Process p=run.exec(new File(webroot).getAbsolutePath()+"/ffmpeg -y -i "+sourcePath+" -acodec pcm_s16le -f s16le -ac 1 -ar 16000 "+targetPath);

    //mp3转pcm

       //ffmpeg -y  -i test.mp3  -acodec pcm_s16le -f s16le -ac 1 -ar 16000 test.pcm
     Process p=run.exec(new File(webroot).getAbsolutePath()+"/ffmpeg -y -i "+mp3filepath+" -acodec pcm_s16le -f s16le -ac 1 -ar 16000 "+pcmfilepath);

     //释放进程

     p.getOutputStream().close();

     p.getInputStream().close();

     p.getErrorStream().close();

     p.waitFor();

    long end=System.currentTimeMillis();

     System.out.println(mp3filepath+" convert success, costs:"+(end-start)+"ms");

    } catch (Exception e) {

     e.printStackTrace();

     }finally{

     //run调用lame解码器最后释放内存

     run.freeMemory();

     }

    }

}
