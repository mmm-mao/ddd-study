package jp.co.biglobe.isp.domain.course;


import jp.co.biglobe.isp.domain.member.BiglobeId;

public interface CourseRepository {

    public void 登録する(Course course);

    public void 変更予約する(Course course);

    public Course biglobeIdで検索する_存在しなかったらエラー(BiglobeId biglobeId);

}
