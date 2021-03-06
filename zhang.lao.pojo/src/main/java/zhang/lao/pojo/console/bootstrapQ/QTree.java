package zhang.lao.pojo.console.bootstrapQ;

import java.util.List;

public class QTree {
    private String id;
    private String url;// tree组件一般用于菜单，url为菜单对应的地址
    private String text;// 显示文字
    private boolean checked = false;// 是否选中
    private List<QTree> children;// 子tree
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public List<QTree> getChildren() {
		return children;
	}
	public void setChildren(List<QTree> children) {
		this.children = children;
	}

	public QTree(String id, String url, String text, boolean checked, List<QTree> children) {
		this.id = id;
		this.url = url;
		this.text = text;
		this.checked = checked;
		this.children = children;
	}

	public QTree() {
	}
}