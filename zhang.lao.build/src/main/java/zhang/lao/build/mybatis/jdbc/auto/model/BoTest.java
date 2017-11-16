package zhang.lao.build.mybatis.jdbc.auto.model;

import java.util.Date;

public class BoTest {
    private String id;

    private String name;

    private Date birthday;

    private Integer age;

    private String imgUrl;

    private String des;

    private String sex;

    private String fileMy;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getFileMy() {
        return fileMy;
    }

    public void setFileMy(String fileMy) {
        this.fileMy = fileMy == null ? null : fileMy.trim();
    }
}