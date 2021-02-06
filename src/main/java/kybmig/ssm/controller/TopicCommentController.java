package kybmig.ssm.controller;

import kybmig.ssm.model.TopicCommentModel;
import kybmig.ssm.model.TopicModel;
import kybmig.ssm.model.UserModel;
import kybmig.ssm.model.UserRole;
import kybmig.ssm.service.TopicCommentService;
import kybmig.ssm.service.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/topic_comment")
@Transactional
public class TopicCommentController {
    private TopicCommentService service;
    private UserService userService;

    public TopicCommentController(TopicCommentService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @PostMapping("/add")
    public void add(@RequestBody TopicCommentModel form, HttpServletRequest request) {
        UserModel currentUser = userService.currentUser(request);
        Integer topicId = form.getTopicId();
        String content = form.getContent();

        if (currentUser.getRole() != UserRole.guest) {
            Integer userId = currentUser.getId();
            service.add(userId, topicId, content);
        } else {
        }
    }

    @PostMapping("/delete")
    public void delete(@RequestBody TopicCommentModel form, HttpServletRequest request) {
        Integer id = form.getId();
        service.remove(id);
    }

    @GetMapping("/{id}")
    public List<TopicCommentModel> edit(@PathVariable Integer id, String content, HttpServletRequest request) {
        List<TopicCommentModel> c = service.load(id);
        return c;
    }

    @PostMapping("/update")
    public void update(@RequestBody TopicCommentModel form, HttpServletRequest request) {
        Integer id = form.getId();
        String content = form.getContent();
        service.update(id, content);
    }

    @GetMapping("/some/{userId}")
    public List<TopicCommentModel> some(@PathVariable Integer userId) {
        List<TopicCommentModel> comments = service.findSomeCommentsByUserId(userId,5);
        return comments;
    }

    @GetMapping("/by_user/{userId}")
    public List<TopicCommentModel> topics(@PathVariable Integer userId) {
        List<TopicCommentModel> r = service.findTopicCommentsByUserId(userId);
        return r;
    }
}
