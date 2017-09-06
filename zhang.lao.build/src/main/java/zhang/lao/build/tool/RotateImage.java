package zhang.lao.build.tool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2017/3/10.
 */
public class RotateImage {
    /**
     * 旋转图片为指定角度
     *
     * @param bufferedimage
     *            目标图像
     * @param degree
     *            旋转角度
     * @return
     */
    public static BufferedImage rotateImage(final BufferedImage bufferedimage,
                                            final int degree) {
        int w = bufferedimage.getWidth();
        int h = bufferedimage.getHeight();
        int type = bufferedimage.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = new BufferedImage(w, h, type))
                .createGraphics()).setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.rotate(Math.toRadians(degree), w / 2, h / 2);
        graphics2d.drawImage(bufferedimage, 0, 0, null);
        graphics2d.dispose();
        return img;
    }


    public static void main(String[] args) {
        try {
            int grade=200;
            BufferedImage image = ImageIO.read(new FileInputStream("D://machine_stop.png"));
            BufferedImage image2 =  RotateImage.rotateImage(image,grade);
            ImageIO.write(image2,"png",new File("D://machine_stop_"+grade+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}