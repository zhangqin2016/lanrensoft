package zhang.lao.console.controller.common.captcha;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pub.greenbamboo.captcha.*;
import zhang.lao.console.controller.common.HtmlTableToExcel;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by 张钦 on 2016/9/14.
 * 验证码获取
 */

@Controller
/**
 * 获取验证码
 */
public class CaptchaController {
    private static  final Logger logger = LoggerFactory.getLogger(CaptchaController.class);
    @RequestMapping("/common/captcha/get/{id}")
    public  void  getCaptchaImage(@PathVariable String id, HttpServletResponse response, HttpServletRequest httpServletRequest){
            OutputStream outputStream = null;
            try {
                outputStream = response.getOutputStream();
                Captcha instance = new JCaptcha();
                ImageCode result = instance.getImageCode();
                httpServletRequest.getSession().setAttribute(id, result.getCode());
                ImageIO.write((RenderedImage) result.getImage(), "png", outputStream);
                outputStream.flush();
            } catch (IOException e) {
                logger.info(e.getMessage());
            } finally {
                try {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
