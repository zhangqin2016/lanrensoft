package zhang.lao.pojo.console.resp;

import java.util.List;

/**
 * Created by tech6 on 2016/7/27.
 */
public class BootStrapGridResp {
    private long total;
    private List<?> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public BootStrapGridResp(long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }
}
