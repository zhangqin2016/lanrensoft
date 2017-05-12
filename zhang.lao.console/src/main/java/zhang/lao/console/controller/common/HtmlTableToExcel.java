package zhang.lao.console.controller.common;

import zhang.lao.build.kit.LogKit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by zhangqin on 2017/3/30.
 */
@Controller
public class HtmlTableToExcel {

    @RequestMapping("/console/export/excel")
    public void exportExcel(String table, HttpServletResponse response){
       String  fileName = System.currentTimeMillis()+".xls";
            response.reset();
            response.setHeader("Content-Disposition", String.format("attachment; filename=%s", fileName));
            response.setHeader("Content-Type","application/msexcel");
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.addCookie(new Cookie("fileDownload", "true"));
            //out.write(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF}); // 生成带bom的utf8文件
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            out.write(table.getBytes());
            out.flush();
        } catch (IOException e) {
            LogKit.error(e.getMessage(),e);
        }finally {
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    LogKit.error(e.getMessage(),e);
                }
            }
        }

    }
}
