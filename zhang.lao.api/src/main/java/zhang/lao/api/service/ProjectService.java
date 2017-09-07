package zhang.lao.api.service;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhang.lao.api.pojo.ProjectListReq;
import zhang.lao.api.pojo.ProjectListResp;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProject;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProjectExample;
import zhang.lao.dao.base.BoProjectDao;
import zhang.lao.pojo.api.req.ApiReqData;
import zhang.lao.pojo.api.resp.ApiRespData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/7.
 */

@Service
public class ProjectService {

    @Autowired
    private BoProjectDao boProjectDao;

    public ApiRespData<List<ProjectListResp>> listApiRespData(ApiReqData<ProjectListReq> apiReqData){
        List<ProjectListResp> listResps = new ArrayList<>();
        ProjectListReq req = apiReqData.getBody();
        PageHelper.startPage(req.getPageNumber(),req.getPageSize());
        BoProjectExample boProjectExample = new BoProjectExample();
        boProjectExample.createCriteria().andStateEqualTo(1);
        boProjectExample.setOrderByClause("sort asc");
        List<BoProject> boProjects = boProjectDao.selectByExample(boProjectExample);
        for (BoProject boProject : boProjects) {
            ProjectListResp projectListResp = new ProjectListResp();
            projectListResp.setImage(boProject.getImageCover());
            projectListResp.setProjectId(boProject.getId());
            projectListResp.setType(boProject.getType());
            listResps.add(projectListResp);
        }
        return ApiRespData.buildSucc(listResps);
    }
}
