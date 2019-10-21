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
    private static Random random = new Random();
    //手写验证码

    public BufferedImage getImage() throws IOException {
        //设置验证码大小
        bi = new BufferedImage(80,35,BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics2D g = (Graphics2D) bi.getGraphics();
        //设置画笔颜色
        g.setColor(new Color(255,255,255));
        //填充背景色
        g.fillRect(0,0,80,35);
        sb = new StringBuilder();
        //随机生成验证码字符
        for (int x = 0; x < 4 ; x ++){//总共4个字符循环四次
            g.setColor(this.getRandomColor());
            g.setFont(this.getRandomFont());
            String type = this.getSingleString();
            sb.append(type);
            g.drawString(type,(20*x)+1,25);
        }
        //随机生成验证码干扰线
        for (int x = 0 ;x < 10 ; x ++){
            int x1 = random.nextInt(80);
            int y1 = random.nextInt(35);
            int x2 = random.nextInt(80);
            int y2 = random.nextInt(35);
            g.setColor(this.getRandomColor());
            g.drawLine(x1,y1,x2,y2);
        }
        return bi ;
    }


    /**
     * 获取随机的颜色
     * @return 一个随机的Color类型的颜色
     */
    public Color getRandomColor(){
        int red = random.nextInt(150);
        int green = random.nextInt(150);
        int blue = random.nextInt(150);
        return new Color(red,green,blue);
    }


    /**
     * 获取一个随机的字体
     * @return 随机的Font类型的字体
     */
    public Font getRandomFont(){
        String[] fonts = new String[]{"宋体","黑体","仿宋","楷体","隶书"};
        int fontsIndex = random.nextInt(5);
        int style = random.nextInt(4);
        int size = random.nextInt(5);
        return new Font(fonts[fontsIndex],style,24+size);
    }


    /**
     * 获取随机的字符
     * @return 一个随机的字符
     */
    public String getSingleString(){
        String allCode = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        char[] codes = allCode.toCharArray();
        int index = random.nextInt(codes.length);
        return String.valueOf(codes[index]);
    }



    public void getImageOutput(OutputStream outputStream) throws IOException {
        ImageIO.write(bi,"jpg",outputStream);
    }
    public String getText(){
        return sb.toString();
    }


}
