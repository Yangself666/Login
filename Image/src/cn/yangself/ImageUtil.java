package cn.yangself;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class ImageUtil {
    private static StringBuilder sb = null;
    private static BufferedImage bi = null;
    //手写验证码
    /**
     * 画图过程，调用方法设置输出流直接进行输出
     * @throws IOException
     */
    public static BufferedImage getImage() throws IOException {
        Random random = new Random();
        /**
         * 获取一个随机的字体
         * @return 随机的Font类型的字体
         */
        String[] fonts = new String[]{"宋体","黑体","仿宋","楷体","隶书"};
        int fontsIndex = random.nextInt(5);
        int style = random.nextInt(4);
        int size = random.nextInt(5);
        /**
         * 获取随机的颜色
         * @return 一个随机的Color类型的颜色
         */
        int red = random.nextInt(150);
        int green = random.nextInt(150);
        int blue = random.nextInt(150);

        /**
         * 获取随机的字符
         * @return 一个随机的字符
         */
        String allCode = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        char[] codes = allCode.toCharArray();


        //设置验证码大小
        bi = new BufferedImage(100,50,BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics2D g = (Graphics2D) bi.getGraphics();
        //设置画笔颜色
        g.setColor(new Color(255,255,255));
        //填充背景色
        g.fillRect(0,0,100,50);
        sb = new StringBuilder();
        //随机生成验证码字符
        for (int x = 0; x < 4 ; x ++){//总共4个字符循环四次
            g.setColor(new Color(red,green,blue));
            g.setFont(new Font(fonts[fontsIndex],style,24+size));
            int index = random.nextInt(codes.length);
            String type = String.valueOf(codes[index]);
            sb.append(type);
            g.drawString(type,(20*x)+5,40);
        }
        //随机生成验证码干扰线
        for (int x = 0 ;x < 10 ; x ++){
            int x1 = random.nextInt(100);
            int y1 = random.nextInt(50);
            int x2 = random.nextInt(100);
            int y2 = random.nextInt(50);
            g.drawLine(x1,y1,x2,y2);
        }
        return bi ;
    }
    public static void getImageOutput(BufferedImage bufferedImage, OutputStream outputStream) throws IOException {
        ImageIO.write(bufferedImage,"jpg",outputStream);
    }
    public static  String getString(){
        return sb.toString();
    }


}
