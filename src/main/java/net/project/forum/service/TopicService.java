package net.project.forum.service;

import net.project.forum.domain.Reply;
import net.project.forum.domain.Topic;
import net.project.forum.dto.PageDTO;

public interface TopicService {

    PageDTO<Topic> listTopicPageByCid(int cId, int page, int pageSize);

    Topic findById(int topicId);

    PageDTO<Reply> findReplyPageByTopicId(int topicId, int page, int pageSize);
}
