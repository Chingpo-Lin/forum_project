package net.project.forum.service.impl;

import net.project.forum.dao.ReplyDao;
import net.project.forum.dao.TopicDao;
import net.project.forum.domain.Reply;
import net.project.forum.domain.Topic;
import net.project.forum.dto.PageDTO;
import net.project.forum.service.TopicService;

import java.util.List;

public class TopicServiceImpl implements TopicService {

    private TopicDao topicDao = new TopicDao();
    private ReplyDao replyDao = new ReplyDao();
    @Override
    public PageDTO<Topic> listTopicPageByCid(int cId, int page, int pageSize) {

        // 查询总记录
        int totalRecordNum = topicDao.countTotalTopicByCid(cId);
        int from = (page - 1) * pageSize;

        //分页查询
        List<Topic> topicList = topicDao.findListByCid(cId,from,pageSize);
        PageDTO<Topic> pageDTO = new PageDTO<>(page, pageSize, totalRecordNum);
        pageDTO.setList(topicList);
        return pageDTO;
    }

    @Override
    public Topic findById(int topicId) {
        return topicDao.findById(topicId);
    }

    @Override
    public PageDTO<Reply> findReplyPageByTopicId(int topicId, int page, int pageSize) {
        // 查询总回复
        int totalRecordNum = replyDao.countTotalReplyByTid(topicId);
        int from = (page - 1) * pageSize;

        //分页查询
        List<Reply> replyList = replyDao.findListByTopicId(topicId,from,pageSize);
        PageDTO<Reply> pageDTO = new PageDTO<>(page, pageSize, totalRecordNum);
        pageDTO.setList(replyList);
        return pageDTO;
    }
}
