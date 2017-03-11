package zhang.lao.service.console;


import zhang.lao.pojo.console.bootstrapQ.QTree;

/**
 * Created by tech6 on 2016/8/2.
 */
public interface ConsoleSysRoleService {
    String getSelectRoleHtmlByUserId(Integer id);
    QTree getRoleNavJson(Integer role_id, Integer firstNavId);
    QTree getRoleReqJson(Integer role_id, String url);
    void updateRoleNavByNavIdAndRoleId(String[] navs, Integer role_id);
    void updateRoleReqUrl(String[] navs, Integer role_id);
    void updateUserRole(String[] role_ids, Integer user_id);
    boolean containNav(Integer nav_id, Integer role_id);
    boolean containReq(String reqUrl, Integer role_id);
}
