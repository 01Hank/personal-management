import com.alibaba.fastjson.JSON;
import com.baidu.aip.util.Base64Util;
import com.pm.Pojo.db.BaiduMusic;
import com.pm.Utils.Recognition;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;

public class test {

    public static  void main(String[] args){
        String mp3Path = "D:\\music\\test.mp3";
        String pcmPath = "D:\\music\\test.pcm";



        BaiduMusic music = new BaiduMusic();
        String s = JSON.toJSONString(music);

        Recognition recognition = new Recognition();
        String baiduToken = recognition.getBaiduToken();

        //获取文件的二进制
        try {
            recognition.mp3Convertpcm(mp3Path,pcmPath);
            //mp3Topcm.mp3Convertpcm(mp3Path,pcmPath);
            byte[] data = FileUtils.readFileToByteArray(new File(pcmPath)); //readFileByBytes仅为获取二进制数据示例
            String speech = Base64Util.encode(data);

            String result = recognition.getBaiduMusic(baiduToken, speech, data.length);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    static  byte[]  test1(String mp3path) throws IOException{
        byte[] bytes = FileUtils.readFileToByteArray(new File(mp3path));
        return bytes;
    }

}
