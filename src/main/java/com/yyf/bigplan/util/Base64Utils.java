package com.yyf.bigplan.util;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import sun.misc.BASE64Decoder;

import javax.servlet.ServletOutputStream;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author 杨宇飞 2020-01-07 2:33 上午
 * @version 1.0
 * @apiNote <p>Base64 处理工具</p>
 */
public class Base64Utils {

    /**
     * 保存base64 格式的图片于项目存储内「安卓和IOS 手机拍摄的照片格式为jpeg」
     *
     * @param baseImg base64 字符串
     * @return 保存的uri
     */
    public static String saveImg(String baseImg) {
        String type = "jpeg";
        //去除base64图片的前缀
        baseImg = baseImg.replaceFirst("data:(.+?);base64,", "");
        byte[] b;
        byte[] bs;
        OutputStream os = null;
        String fileName = "";
        String nowDate = "";
        // 格式化并获取当前日期（用来命名）
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        nowDate = format.format(new Date());
        // 把图片转换成二进制
        b = Base64.decode(baseImg.replaceAll(" ", "+"));
        // 生成路径
        // 图片路径层级分隔符
        String separator = "/";
        String uploadBaseURL = "img";
        String path = uploadBaseURL + separator + "placeImg" + separator + nowDate + separator;
        //随机生成图片的名字，同时根据类型结尾
        fileName = UUID.randomUUID().toString() + "." + type;
        File file = new File(path);
        if (!file.exists() && !file.isDirectory()) {
            boolean mkdirs = file.mkdirs();
        }
        File imageFile = new File(path + fileName);
        BASE64Decoder d = new BASE64Decoder();
        // 保存
        try {
            bs = d.decodeBuffer(Base64.encode(b));
            os = new FileOutputStream(imageFile);
            os.write(bs);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.getLocalizedMessage();
                }
            }
        }
        return path + fileName;
    }

    public static void downloadFile(String imgUrl, ServletOutputStream outputStream) throws IOException {
        byte[] bytes = getFileToByte(new File(imgUrl));
        outputStream.write(bytes);
    }


    /**
     * 文件转为二进制数组
     *
     * @param file {@link File}
     * @return 二进制数组
     */
    private static byte[] getFileToByte(File file) {
        byte[] by = new byte[(int) file.length()];
        try {
            InputStream is = new FileInputStream(file);
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            byte[] bb = new byte[2048];
            int ch;
            ch = is.read(bb);
            while (ch != -1) {
                byteStream.write(bb, 0, ch);
                ch = is.read(bb);
            }
            by = byteStream.toByteArray();
        } catch (Exception ex) {
            throw new RuntimeException("transform file into bin Array 出错", ex);
        }
        return by;
    }

}
