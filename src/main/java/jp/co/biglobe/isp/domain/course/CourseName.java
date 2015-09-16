package jp.co.biglobe.isp.domain.course;


public enum CourseName {
    ベーシック,
    ニコニコ;

    public boolean ニコニココースか(){
        return this.equals(CourseName.ニコニコ);
    }

    public boolean is同じコース(CourseName courseName){
        return this.equals(courseName);
    }
}
