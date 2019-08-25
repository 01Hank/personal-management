package com.pm.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pm.Pojo.db.BaiduMusic;
import com.pm.Pojo.db.BaiduResults;
import com.pm.Pojo.db.BaiduToken;
import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 语音识别工具
 */
public class Recognition {

    private RestTemplate restTemplate;

    public Recognition() {
        restTemplate = new RestTemplate();

    }

    /**
     * mp3转换pcm
     */
    public  void mp3Convertpcm(String mp3filepath, String pcmfilepath) throws Exception{
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
    private AudioInputStream getPcmAudioInputStream(String mp3filepath) {
        File mp3 = new File(mp3filepath);
        AudioInputStream audioInputStream = null;
        AudioFormat targetFormat = null;
        try {
            AudioInputStream in = null;

            //读取音频文件的类
            MpegAudioFileReader mp = new MpegAudioFileReader();
            in = mp.getAudioInputStream(mp3);
            AudioFormat baseFormat = in.getFormat();

            //设定输出格式为pcm格式的音频文件
            targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16,
                    baseFormat.getChannels(), baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);

            //输出到音频
            audioInputStream = AudioSystem.getAudioInputStream(targetFormat, in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return audioInputStream;
    }

    /**
     * 获取百度token
     */
    public String  getBaiduToken(){
        //https://openapi.baidu.com/oauth/2.0/token
        String url = "https://openapi.baidu.com/oauth/2.0/token?grant_type=client_credentials&client_id=7cGWBMXjLKxA3vsv5mrSpvEZ&client_secret=E5lxkMEZKhKOjiAKA4aAe9zhPo1W1mgu";
        String tokens = restTemplate.getForObject(url,String.class);
        BaiduToken baiduToken = JSON.parseObject(tokens, BaiduToken.class);
        return baiduToken.getAccess_token();
    }

    /**
     * 调用百度语音识别接口
     */
    public String getBaiduMusic(String token,String speech,int len){
        BaiduMusic music = new BaiduMusic();
        music.setSpeech(speech);
        music.setToken(token);
        music.setLen(len);
        music.setCuid("A0-A4-C5-6F-95-4B");

        String url = "http://vop.baidu.com/server_api";
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        //JSONObject jsonObj = JSON.parseObject(music);
        String s = JSON.toJSONString(music);

          HttpEntity<String> formEntity = new HttpEntity<String>(s, headers);

          try {
              String result = restTemplate.postForObject(url, formEntity, String.class);
              BaiduResults results = JSON.parseObject(result, BaiduResults.class);
              //System.out.println(results.getErr_no());
              if(results.getErr_no()==0){
                  return results.getResult()[0];
              }
              return "语音不清晰";
          }catch (Exception e){
              return "请求异常";
          }

    }
}
