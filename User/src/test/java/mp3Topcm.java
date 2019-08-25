import org.apache.commons.io.IOUtils;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.*;

public class mp3Topcm {
    public static void mp3Convertpcm(String mp3filepath,String pcmfilepath) throws Exception{
        InputStream mp3Stream = new FileInputStream(mp3filepath);
        InputStream bufferedIn = new BufferedInputStream(mp3Stream);
        AudioInputStream mp3audioStream = AudioSystem.getAudioInputStream(bufferedIn);
        //将AudioInputStream MP3文件 转换为PCM
        AudioFormat baseFormat = mp3audioStream.getFormat();
        AudioFormat targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16,
                baseFormat.getChannels(), baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);

        AudioInputStream pcmaudioStream = AudioSystem.getAudioInputStream(targetFormat,mp3audioStream);
        byte[] pcmBytes = IOUtils.toByteArray(pcmaudioStream);
        FileOutputStream out = new FileOutputStream(pcmfilepath);
        out.write(pcmBytes);
        out.flush();
        out.close();
        pcmaudioStream.close();
        mp3audioStream.close();
    }
}
