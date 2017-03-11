package zhang.lao.pojo.console.bootgrid;

import java.util.List;

/**
 * Created by tech6 on 2016/6/15.
 */
public class BootGridModel {
   private int current;
   private int rowCount;
    private List<?>rows;
    private long total;

    public long getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public List<?> getRows() {
        return rows;
    }

    public BootGridModel(int current, int rowCount, List<?> rows, long total) {
        this.current = current;
        this.rowCount = rowCount;
        this.rows = rows;
        this.total = total;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public BootGridModel() {
    }
}
