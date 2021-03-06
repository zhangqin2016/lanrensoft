package pub.greenbamboo.captcha;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * 验证码创建者实体类A。该类是一个加干扰线白底随机颜色字符的通用验证码实体类。
 *
 * @author bing <503718696@qq.com>
 * @date 2016-5-15 21:08:41
 * @version v0.1
 */
public class ACaptcha extends AbstractCaptcha {

    public final static String CODEER_NAME = "ACaptcha";
    private String randString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";//用于生产的母字符串
    private Font font = new Font("Fixedsys", Font.CENTER_BASELINE, 18);//验证码字体

    @Override
    public String generateCaptchaString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < codeLength; i++) {
            sb.append(randString.charAt(random.nextInt(randString.length())));
        }
        return sb.toString();
    }

    @Override
    public Image generateCaptchaImage(String code) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics g = bi.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        g.setColor(ColorUtil.randomColor());
        //绘制随机字符
        drawCodeString(g, code);
        g.dispose();
        return bi;
    }

    /**
     * 绘制字符串。
     *
     * @param g
     * @param code 随机字符串
     * @param i
     * @return
     */
    private void drawCodeString(Graphics g, String code) {
        g.setFont(font);
        for (int i = 0; i < codeLength; i++) {
            g.translate(random.nextInt(10), random.nextInt(4));
            g.setColor(ColorUtil.randomColor());
            g.drawString(String.valueOf(code.charAt(i)), 13 * i, 16);
        }
    }

}
