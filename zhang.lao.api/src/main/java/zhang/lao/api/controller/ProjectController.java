package zhang.lao.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import zhang.lao.api.pojo.ProjectListReq;
import zhang.lao.api.pojo.ProjectListResp;
import zhang.lao.api.service.ProjectService;
import zhang.lao.extents.spring.handle.ApiData;
import zhang.lao.pojo.api.req.ApiReqData;
import zhang.lao.pojo.api.resp.ApiRespData;

import java.util.List;

/**
 * Created by Administrator on 2017/9/7.
 */

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    public ApiRespData<List<ProjectListResp>> getProject(@ApiData ApiReqData<ProjectListReq> reqApiReqData){
        return projectService.listApiRespData (reqApiReqData);
    }
}
