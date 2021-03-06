package pub.greenbamboo.captcha;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 *
 * <pre>
 * 作者：cuidianlong
 * 项目：SpringWind-CaptchaSystem
 * 类说明：生成英文区分大小写6位数验证码
 * 日期：2016年5月20日
 * 备注：
 * </pre>
 */
public class GCaptcha extends AbstractCaptcha {

    public final static String CODEER_NAME = "GCaptcha";
    private Map<String, String> captchaCodeSource = new HashMap<>();
    private String[] codeSequence = null;//用于生产的母字符数组
    private Font font = new Font("Fixedsys", Font.CENTER_BASELINE, 18);//验证码字体

    public GCaptcha() {
        captchaCodeSource.put("眉", "眉来眼去");
        captchaCodeSource.put("笑", "笑傲江湖");
        captchaCodeSource.put("哎", "哎呀我去");
        captchaCodeSource.put("风", "风生水起");
        captchaCodeSource.put("亡", "亡羊补牢");
        captchaCodeSource.put("不", "不劳而获");
        //遍历map中的key，并保存到codeSequence中。注意：成语第一个汉字容易重复，可以用int类型自增
        Set<String> keys = captchaCodeSource.keySet();
        Iterator<String> it = keys.iterator();
        codeSequence = new String[keys.size()];
        int j = 0;
        while (it.hasNext()) {
            codeSequence[j++] = it.next();
        }
    }

    /**
     * 返回用于构成验证码的字符
     *
     * @return
     */
    @Override
    public String generateCaptchaString() {
        StringBuilder sb = new StringBuilder();
        String code = codeSequence[random.nextInt(codeSequence.length)];
        sb.append(captchaCodeSource.get(code));
        return sb.toString();
    }

    /**
     * 返回验证码图片
     *
     * @return
     */
    @Override
    public Image generateCaptchaImage(String code) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics g = bi.getGraphics();
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
            g.translate(random.nextInt(3), random.nextInt(3));
            g.setColor(ColorUtil.randomColor());
            g.drawString(String.valueOf(code.charAt(i)), 13 * i, 16);
        }
    }


    @Override
    public boolean checkCaptcha(String code, String clientCode) {
        if (code == null || clientCode == null || code.isEmpty() || clientCode.isEmpty() || code.length() != 4) {
            return false;
        }
        return code.equals(clientCode);
    }
}
