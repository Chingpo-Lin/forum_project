package net.project.forum.controller;

import net.project.forum.domain.Reply;
import net.project.forum.domain.Topic;
import net.project.forum.dto.PageDTO;
import net.project.forum.service.TopicService;
import net.project.forum.service.impl.TopicServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "topicServlet", urlPatterns = {"/topic"})
public class TopicServlet extends BaseServlet {

    private TopicService topicService = new TopicServiceImpl();
    /**
     * 分页大小
     */
    private static final int pageSize = 2;

    // http://localhost:8080/topic?method=list&c_id=2&page=1
    public void list(HttpServletRequest req, HttpServletResponse resp) {
        int cId = Integer.parseInt(req.getParameter("c_id"));
        int page = 1;

        String currentPage = req.getParameter("page");
        if (currentPage != null && currentPage != "") {
            page = Integer.parseInt(currentPage);
        }

        PageDTO<Topic> pageDTO = topicService.listTopicPageByCid(cId, page, pageSize);
        System.out.println(pageDTO.toString());
        req.setAttribute("topicPage", pageDTO);
    }

    // http://localhost:8080/topic?method=findDetailById&topic_id=1&page=2
    public void findDetailById(HttpServletRequest req, HttpServletResponse response) {

        int topicId = Integer.parseInt(req.getParameter("topic_id"));

        int page = 1;

        String currentPage = req.getParameter("page");
        if (currentPage != null && currentPage != "") {
            page = Integer.parseInt(currentPage);
        }

        Topic topic = topicService.findById(topicId);
        PageDTO<Reply> pageDTO = topicService.findReplyPageByTopicId(topicId, page, pageSize);

        System.out.println(pageDTO.toString());
        req.setAttribute("topic", topic);
        req.setAttribute("replyPage", pageDTO);
    }
}
