package zhang.lao.api.pojo.req;/**
 * Created by zhangqin on 2017/10/19.
 */

import org.hibernate.validator.constraints.NotBlank;
import zhang.lao.pojo.api.req.ApiReqBody;

/**
 * @author
 * @create 2017-10-19 15:32
 **/
public class TestReq extends ApiReqBody {

    @NotBlank
    private String test1;

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }
}
