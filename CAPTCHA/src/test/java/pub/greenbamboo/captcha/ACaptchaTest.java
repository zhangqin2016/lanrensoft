package pub.greenbamboo.captcha;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.junit.Test;

/**
 * 测试通过,详细见测试报告：
 * GreenBamboo-CAPTCHA\CAPTCHA\src\test\java\pub\greenbamboo\captcha\testReport\ACaptchaTest_pass_report.docx
 *
 * @author bing <503718696@qq.com>
 */
public class ACaptchaTest {

    public ACaptchaTest() {
    }

    @Test
    public void testGetCaptcha() {
        try {
            System.out.println("getCaptcha");
            ACaptcha instance = new ACaptcha();
                ImageCode result = instance.getImageCode();
                ImageIO.write((RenderedImage) result.getImage(), "png", new File("e:\\Server\\" + result.getCode() + ".png"));

        } catch (IOException ex) {
            Logger.getLogger(ACaptchaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
