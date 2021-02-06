package kybmig.ssm.service;


import kybmig.ssm.Utility;
import kybmig.ssm.mapper.TopicCommentMapper;
import kybmig.ssm.mapper.TopicMapper;
import kybmig.ssm.model.TopicCommentModel;
import kybmig.ssm.model.TopicModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    private TopicMapper topicMapper;
    private TopicCommentMapper commentMapper;

    public TopicService(TopicMapper topicMapper, TopicCommentMapper commentMapper) {
        this.topicMapper = topicMapper;
        this.commentMapper = commentMapper;
    }

    public List<TopicModel> findSomeTopicByUserId(Integer userId, Integer limit) {
        List<TopicModel> r = topicMapper.findSomeTopicByUserId(userId, limit);
        return r;
    }

    public TopicModel add(Integer userId, String title, String content, Integer boardId) {
        TopicModel m = new TopicModel();
        m.setUserId(userId);
        m.setTitle(title);
        m.setContent(content);
        m.setBoardId(boardId);
        Long unixTime = Utility.getUnixTime();
        m.setCreatedTime(unixTime);
        m.setUpdatedTime(unixTime);
        topicMapper.insertTopic(m);
        return m;
    }

    public void update(Integer id, String title, String content) {
        TopicModel m = new TopicModel();
        m.setId(id);
        m.setTitle(title);
        m.setContent(content);
        Long unixTime = Utility.getUnixTime();
        m.setUpdatedTime(unixTime);
        topicMapper.updateTopic(m);
    }


    public String deleteById(Integer id) {
        topicMapper.deleteTopic(id);
        return "删除成功";
    }

    public TopicModel findById(Integer id) {
        TopicModel m = topicMapper.selectTopic(id);
        return m;
    }

    public TopicModel findByIdWithComments(Integer id) {
        TopicModel m = topicMapper.selectOneWithComments(id);
        return m;
    }

    public TopicModel findByIdWithCommentsAndUser(Integer id) {
        TopicModel m = topicMapper.selectOneWithCommentsAndUser(id);
        return m;
    }

    public List<TopicCommentModel> findCommentsById(Integer id) {
        return this.commentMapper.selectAllTopicCommentByTopicId(id);
    }

    public List<TopicModel> all() {
        return topicMapper.selectAllTopic();
    }

    public List<TopicModel> findTopicsByUserId(Integer userId) {
        List<TopicModel> r = topicMapper.findTopicsByUserId(userId);
        return r;
    }

    public List<TopicModel> findTopicsByBoardId(Integer boardId) {
        List<TopicModel> r = topicMapper.findTopicsByBoardId(boardId);
        return r;
    }
}
