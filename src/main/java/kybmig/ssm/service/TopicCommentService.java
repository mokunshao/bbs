package kybmig.ssm.service;

import kybmig.ssm.Utility;
import kybmig.ssm.mapper.TopicCommentMapper;
import kybmig.ssm.model.TopicCommentModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicCommentService {
    private TopicCommentMapper topicCommentMapper;

    public TopicCommentService(TopicCommentMapper topicCommentMapper) {
        this.topicCommentMapper = topicCommentMapper;
    }

    public List<TopicCommentModel> load(Integer id) {
        List<TopicCommentModel> m = topicCommentMapper.selectTopicComment(id);
        return m;
    }

    public void add(Integer userId, Integer TopicId, String content) {
        TopicCommentModel m = new TopicCommentModel();
        m.setUserId(userId);
        m.setContent(content);
        m.setTopicId(TopicId);
        Long unixTime = Utility.getUnixTime();
        m.setCreatedTime(unixTime);
        m.setUpdatedTime(unixTime);
        topicCommentMapper.insertTopicComment(m);
    }

    public void update(Integer id, String content) {
        TopicCommentModel m = new TopicCommentModel();
        m.setId(id);
        m.setContent(content);
        Long unixTime = Utility.getUnixTime();
        m.setCreatedTime(unixTime);
        m.setUpdatedTime(unixTime);
        topicCommentMapper.updateTopicComment(m);
    }

    public void remove(Integer id) {
        topicCommentMapper.deleteTopicComment(id);
    }

    public List<TopicCommentModel> findSomeCommentsByUserId(Integer userId, int limit) {
        List<TopicCommentModel> r = topicCommentMapper.findSomeCommentsByUserId(userId, limit);
        return r;
    }

    public List<TopicCommentModel> findTopicCommentsByUserId(Integer userId) {
        List<TopicCommentModel> r = topicCommentMapper.findTopicCommentsByUserId(userId);
        return r;
    }
}
