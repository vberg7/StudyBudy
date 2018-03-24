package codespace.mehakmeet.studybudy.model;

/**
 * Created by MEHAKMEET on 19-03-2018.
 */

public class quiz_model {
    String q,m1,m2,m3,ans;

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getM1() {
        return m1;
    }

    public void setM1(String m1) {
        this.m1 = m1;
    }

    public String getM2() {
        return m2;
    }

    public void setM2(String m2) {
        this.m2 = m2;
    }

    public String getM3() {
        return m3;
    }

    public void setM3(String m3) {
        this.m3 = m3;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public quiz_model(String q, String m1, String m2, String m3, String ans) {

        this.q = q;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.ans = ans;
    }
}
