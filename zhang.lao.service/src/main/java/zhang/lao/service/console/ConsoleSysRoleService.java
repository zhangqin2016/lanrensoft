package zhang.lao.service.console;


import zhang.lao.pojo.console.bootstrapQ.QTree;

/**
 * Created by tech6 on 2016/8/2.
 */
public interface ConsoleSysRoleService {
    String getSelectRoleHtmlByUserId(String id);
    QTree getRoleNavJson(String role_id, String firstNavId);
    QTree getRoleReqJson(String role_id, String group);
    void updateRoleNavByNavIdAndRoleId(String[] navs, String role_id);
    void updateRoleReqUrl(String[] navs, String role_id);
    void updateUserRole(String[] role_ids, String user_id);
    boolean containNav(String nav_id, String role_id);
    boolean containReq(String reqUrl, String role_id);
    boolean reqInWhiteList(String reqUrl);
    boolean reqHasRole(String reqUrl,String uid);
}
