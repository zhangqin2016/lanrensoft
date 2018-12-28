package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import zhang.lao.dao.base.SysFileDao;
import zhang.lao.build.mybatis.jdbc.auto.model.SysFile;
import zhang.lao.build.mybatis.jdbc.auto.model.SysFileExample;
import zhang.lao.build.tool.LzStringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import zhang.lao.build.mybatis.jdbc.auto.tool.ControllerQueryTool;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;
import zhang.lao.pojo.console.resp.HttpResultUtil;
import zhang.lao.pojo.console.resp.HttpResult;
import javax.annotation.Resource;
import java.util.List;
import zhang.lao.build.tool.UUIDTool;
/**
* 
* @author 
* @create 
**/
 @Service
public class SysFileService{
	@Resource
	private SysFileDao sysFileDao;

	public String add(){
		return "console/sysFile/sysFile_form";
	}

	public String edit(ModelMap modelMap,java.lang.String id){
			modelMap.put("sysFile", sysFileDao.selectByPrimaryKey(id));
		return "console/sysFile/sysFile_form";
	}

	public String list(){
		return "console/sysFile/sysFile_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		SysFileExample sysFileExample = new SysFileExample();
        ControllerQueryTool.setSysFileCriteria(bootGridReq.getQuery(),sysFileExample.createCriteria());
		List<SysFile> sysFileList = sysFileDao.selectByExample(sysFileExample);
		return new BootStrapGridResp(page.getTotal(),sysFileList);
	}

	public HttpResult save(String formObjectJson){
		SysFile sysFile= JSON.parseObject(formObjectJson,SysFile.class);
			java.lang.String id=sysFile.getFileId();
		if (id!=null) {
			sysFileDao.updateByPrimaryKeySelective(sysFile);
		}else{
			sysFile.setFileId(UUIDTool.getUUID());
			sysFileDao.insertSelective(sysFile);
		}
		return HttpResultUtil.buildSuccess();

	}

	@Transactional
	public HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		sysFileDao.deleteByPrimaryKey(java.lang.String.valueOf(id));
		}
		return HttpResultUtil.buildSuccess();
	}
}
