package kybmig.ssm.mapper;

import kybmig.ssm.model.TopicCommentModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// 这个是 spring 用来在 controller 进行依赖注入的。
@Repository
// 这个是 mybaits spring boot 用来自动跟 xml 联系起来，并注入到 spring 的 session 里面。
@Mapper
public interface TopicCommentMapper {
    void insertTopicComment(TopicCommentModel topicComment);

    List<TopicCommentModel> selectAllTopicComment();

    List<TopicCommentModel> selectTopicComment(int id);

    void updateTopicComment(TopicCommentModel topicComment);

    void deleteTopicComment(int id);

    List<TopicCommentModel> selectAllTopicCommentByTopicId(Integer topicId);

    List<TopicCommentModel> findSomeCommentsByUserId(@Param("userId") Integer userId, @Param("limit") Integer limit);

    List<TopicCommentModel> findTopicCommentsByUserId(Integer userId);
}
