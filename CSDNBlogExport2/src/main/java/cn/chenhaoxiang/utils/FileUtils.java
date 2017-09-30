package cn.chenhaoxiang.utils;


import org.apache.log4j.Logger;

import java.io.*;

/**
 * 文件工具类
 * Created by 陈浩翔 on 2017/7/27 0027.
 */
public class FileUtils {

    private static Logger logger = Logger.getLogger(FileUtils.class);
    public static String basePath = new File("").getAbsolutePath()+"\\blog";//项目根路径

    /**
     * 将字符写入到文件
     * @param sourceString  字符
     * @param fileName  文件名
     * @param encode  编码
     * @throws UnsupportedEncodingException
     */
    public static void saveStringToFile(String sourceString,String fileName,String encode) throws UnsupportedEncodingException {
        byte[] sourceByte = sourceString.getBytes(encode);
        if(null != sourceByte){
            try {
                File file = new File(fileName);     //文件路径（路径+文件名）
                if (!file.exists()) {   //文件不存在则创建文件，先创建目录
                    File dir = new File(file.getParent());
                    dir.mkdirs();
                    file.createNewFile();
                }
                FileOutputStream outStream = new FileOutputStream(file);    //文件输出流用于将数据写入文件
                outStream.write(sourceByte);
                outStream.close();  //关闭文件输出流
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
    }


    /**
     * 读取文件字节流
     * @param filename
     * @return
     * @throws IOException
     */
    public static byte[] toByteArray(String filename) throws IOException {
        File f = new File(filename);
        if (!f.exists()) {
            logger.error(new FileNotFoundException(filename).getMessage());
            throw new FileNotFoundException(filename);
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(f));
            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw e;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
            bos.close();
        }
    }
}
