package zhang.lao.console.service;

import zhang.lao.console.model.bootstrapQ.QTree;

/**
 * Created by tech6 on 2016/8/2.
 */
public interface ConsoleSysRoleService {
    String getSelectRoleHtmlByUserId(Integer id);
    QTree getRoleNavJson(Integer role_id,int firstNavId);
    void updateRoleNavByNavIdAndRoleId(String[] navs, Integer role_id);
    void updateUserRole(String[] role_ids, Integer user_id);
    boolean containNav(Integer nav_id, Integer role_id);
}
