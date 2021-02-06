package kybmig.ssm.model;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class TopicModel extends BaseModel {
    private Integer id;
    private String content;
    private String title;
    private Integer userId;
    private Long createdTime;
    private Long updatedTime;
    private UserModel user;
    private Integer boardId;

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    private ArrayList<TopicCommentModel> commentList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<TopicCommentModel> getCommentList() {
        return commentList;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    public Long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Long updatedTime) {
        this.updatedTime = updatedTime;
    }

    public void setCommentList(ArrayList<TopicCommentModel> commentList) {
        this.commentList = commentList;
    }


    public static void main(String[] args) {
        TopicModel t = new TopicModel();
        t.setUserId(1);
        t.setId(1);
        t.setTitle("t1");
        t.setContent("c1");
        t.setCommentList(new ArrayList<>());

        System.out.printf("t: %s", t);

    }
}
