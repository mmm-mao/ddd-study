package jp.co.biglobe.isp.domain.course;


public enum CourseName {
    ベーシック,
    ニコニコ;

    public boolean ニコニココースか(){
        return this.equals(CourseName.ニコニコ);
    }
}
