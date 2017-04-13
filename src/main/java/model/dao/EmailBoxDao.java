package model.dao;

import model.entity.other.EmailBox;

import java.util.List;

/**
 * Created by LJ on 2017/4/11.
 */
public interface EmailBoxDao {
    //通过收件者id查询消息ydp
    List<EmailBox> selectByInId(int id);
    //通过收件者id查询消息总条数ydp
    Integer selectCountByInId(int id);
    //添加一条消息ydp
    boolean addMail(EmailBox emailBox);
    //通过id删除一条消息
    boolean delMailById(int id);
}
