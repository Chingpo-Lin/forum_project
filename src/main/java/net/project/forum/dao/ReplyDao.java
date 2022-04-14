package net.project.forum.dao;

import net.project.forum.domain.Category;
import net.project.forum.domain.Reply;
import net.project.forum.util.DataSourceUtil;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ReplyDao {

    private QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());

    // 开启驼峰映射
    private BeanProcessor beanProcessor = new GenerousBeanProcessor();
    private RowProcessor processor = new BasicRowProcessor(beanProcessor);

    /**
     * 根据topic id 查询总回复记录
     * @param topicId
     * @return
     */
    public int countTotalReplyByTid(int topicId) {
        String sql= "select count(*) from reply where topic_id=?";
        Long count = null;
        try {
            count = (Long)queryRunner.query(sql, new ScalarHandler<>(),topicId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count.intValue();
    }

    public List<Reply> findListByTopicId(int topicId, int from, int pageSize) {

        String sql = "select * from reply where topic_id=? order by create_time asc limit ?,?";

        List<Reply> replyList = null;

        try {
            replyList = queryRunner.query(sql, new BeanListHandler<>(Reply.class, processor), topicId, from, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return replyList;
    }
}
