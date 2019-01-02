package zhang.lao.build.mybatis.jdbc.auto.model;

public class BoTestUser {
    private String id;

    private String name;

    private Integer age;

    private String userHeadImg;

    private String userFile;

    private Integer userSex;

    private String userSchoolGrade;

    private String userDes;

    private String userInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUserHeadImg() {
        return userHeadImg;
    }

    public void setUserHeadImg(String userHeadImg) {
        this.userHeadImg = userHeadImg == null ? null : userHeadImg.trim();
    }

    public String getUserFile() {
        return userFile;
    }

    public void setUserFile(String userFile) {
        this.userFile = userFile == null ? null : userFile.trim();
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserSchoolGrade() {
        return userSchoolGrade;
    }

    public void setUserSchoolGrade(String userSchoolGrade) {
        this.userSchoolGrade = userSchoolGrade == null ? null : userSchoolGrade.trim();
    }

    public String getUserDes() {
        return userDes;
    }

    public void setUserDes(String userDes) {
        this.userDes = userDes == null ? null : userDes.trim();
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo == null ? null : userInfo.trim();
    }
}