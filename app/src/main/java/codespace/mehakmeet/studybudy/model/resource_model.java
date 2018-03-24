package codespace.mehakmeet.studybudy.model;

/**
 * Created by MEHAKMEET on 19-03-2018.
 */

public class resource_model {
    String title;
    String desc;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public resource_model(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }
}
