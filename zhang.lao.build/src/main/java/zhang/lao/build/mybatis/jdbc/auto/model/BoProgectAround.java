package zhang.lao.build.mybatis.jdbc.auto.model;

public class BoProgectAround {
    private String id;

    private String projectId;

    private String name;

    private String infoImage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getInfoImage() {
        return infoImage;
    }

    public void setInfoImage(String infoImage) {
        this.infoImage = infoImage == null ? null : infoImage.trim();
    }
}