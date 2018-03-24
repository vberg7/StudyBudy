package codespace.mehakmeet.studybudy.model;

/**
 * Created by MEHAKMEET on 19-03-2018.
 */

public class ls_model {
    private String skill,title,detail;
    private int icon;

    public ls_model(String title, String detail, int icon,String skill) {
        this.title = title;
        this.detail = detail;
        this.icon = icon;
        this.skill=skill;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
