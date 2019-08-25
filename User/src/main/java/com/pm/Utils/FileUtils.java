package com.pm.Utils;


import java.io.FileInputStream;

public class FileUtils {
    //将文件转换成Byte数组
    public static byte[] getBytesByFile(String pathStr) {
       // FileInputStream in = new FileInputStream(pathStr);
      return null;
    }

   public void test(){
//          // Audio Attributes/音频编码属性
//                    AudioAttributes audio = new AudioAttributes();
//            /*
//             * 它设置将用于音频流转码的编解码器的名称。您必须从当前Encoder实例的getAudioEncoders（）方法返回的列表中选择一个值。否则，
//             * 您可以传递AudioAttributes.DIRECT_STREAM_COPY特殊值，该值需要源文件中原始音频流的副本。
//             */
//                    audio.setCodec("libmp3lame");
//            /*
//             * 它设置新重新编码的音频流的比特率值。如果未设置比特率值，编码器将选择默认值。该值应以每秒位数表示。例如，如果你想要128 kb /
//             * s比特率，你应该调用setBitRate（new Integer（128000））。
//             */
//                    audio.setBitRate(128000);
//            /* 它设置将在重新编码的音频流中使用的音频通道的数量（1 =单声道，2 =立体声）。如果未设置通道值，编码器将选择默认值。 */
//                    audio.setChannels(2);
//            /*
//             * 它设置新重新编码的音频流的采样率。如果未设置采样率值，编码器将选择默认值。该值应以赫兹表示。例如，如果您想要类似CD的44100
//             * Hz采样率，则应调用setSamplingRate（new Integer（44100））。
//             */
//                    audio.setSamplingRate(44100);
//            /* 可以调用此方法来改变音频流的音量。值256表示没有音量变化。因此，小于256的值是音量减小，而大于256的值将增加音频流的音量。 */
//                    audio.setVolume(new Integer(256));
//
//            // Encoding attributes/编码属性
//                    EncodingAttributes attrs = new EncodingAttributes();
//            /*
//             * 它设置将用于新编码文件的流容器的格式。给定参数表示格式名称。
//             * 编码格式名称有效且仅在它出现在正在使用的Encoder实例的getSupportedEncodingFormats（）方法返回的列表中时才受支持。
//             */
//                    attrs.setFormat("mp3");
//            /* 它设置音频编码属性。如果从未调用过新的EncodingAttributes实例，或者给定参数为null，则编码文件中不会包含任何音频流 */
//                    attrs.setAudioAttributes(audio);
//            /*
//             * 它为转码操作设置偏移量。源文件将从其开始的偏移秒开始重新编码。例如，如果您想剪切源文件的前五秒，
//             * 则应在传递给编码器的EncodingAttributes对象上调用setOffset（5）。
//             */
//                     attrs.setOffset(5F);
//                    /*
//             * 它设置转码操作的持续时间。只有源的持续时间秒才会在目标文件中重新编码。例如，如果您想从源中提取和转码30秒的一部分，
//             * 则应在传递给编码器的EncodingAttributes对象上调用setDuration（30）
//             */
//                     attrs.setDuration(30F);
//
//                    Encode/编码
//                    Encoder encoder = new Encoder();
//            encoder.encode(new MultimediaObject(source), target, attrs, listener);
   }

}
