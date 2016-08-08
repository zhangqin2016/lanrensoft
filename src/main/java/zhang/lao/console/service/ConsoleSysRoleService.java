package zhang.lao.console.service;

import zhang.lao.console.model.bootstrapQ.QTree;

/**
 * Created by tech6 on 2016/8/2.
 */
public interface ConsoleSysRoleService {
    String getSelectRoleHtmlByUserId(Long id);
    QTree getRoleNavJson(Long role_id,Long firstNavId);
    void updateRoleNavByNavIdAndRoleId(String[] navs, Long role_id);
    void updateUserRole(String[] role_ids, Long user_id);
    boolean containNav(Long nav_id, Long role_id);
}
