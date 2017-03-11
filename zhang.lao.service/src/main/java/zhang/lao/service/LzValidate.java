package zhang.lao.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.Validator;

/**
 * Created by zhangqin on 2017/3/11.
 */
@Service
public class LzValidate {

    @Resource
    private Validator validator;
}
