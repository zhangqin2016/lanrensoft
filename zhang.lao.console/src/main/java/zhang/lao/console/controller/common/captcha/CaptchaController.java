package zhang.lao.console.controller.common.captcha;

import com.lz.kit.LogKit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pub.greenbamboo.captcha.ACaptcha;
import pub.greenbamboo.captcha.ImageCode;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by tech6 on 2016/9/14.
 * 验证码获取
 */

@Controller
/**
 * 获取验证码
 */
public class CaptchaController {

    @RequestMapping("/common/captcha/get/{id}")
    public  void  getCaptchaImage(@PathVariable String id, HttpServletResponse response, HttpServletRequest httpServletRequest){
            OutputStream outputStream = null;
            try {
                outputStream = response.getOutputStream();
                ACaptcha instance = new ACaptcha();
                ImageCode result = instance.getImageCode();
                httpServletRequest.getSession().setAttribute(id, result.getCode());
                ImageIO.write((RenderedImage) result.getImage(), "png", outputStream);
            } catch (IOException e) {
                LogKit.info(e.getMessage());
            } finally {
                try {
                    if (outputStream != null) {
                        outputStream.close();
                        outputStream.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
