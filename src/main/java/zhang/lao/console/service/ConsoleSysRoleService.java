package zhang.lao.console.service;

import java.util.List;
import java.util.Map;

/**
 * Created by tech6 on 2016/8/2.
 */
public interface ConsoleSysRoleService {
    String getSelectRoleHtmlByUserId(Integer id);

    List<Map<String, Object>> getRoleNavHtml(Integer role_id);

    void updateRoleNavByNavIdAndRoleId(String[] navs, Integer role_id);
    void updateUserRole(String[] role_ids, Integer user_id);
    boolean containNav(Integer nav_id, Integer role_id);
}
