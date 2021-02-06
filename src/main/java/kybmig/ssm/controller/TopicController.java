package kybmig.ssm.controller;

import kybmig.ssm.model.*;
import kybmig.ssm.service.TopicService;
import kybmig.ssm.service.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@Transactional
@RequestMapping("/topic")
public class TopicController {
    private TopicService service;
    private UserService userService;

    public TopicController(TopicService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @PostMapping("/add")
    public void add(@RequestBody TopicModel form, HttpServletRequest request, HttpServletResponse response) {
        String title = form.getTitle();
        String content = form.getContent();
        Integer boardId = form.getBoardId();
        UserModel currentUser = userService.currentUser(request);
        if (currentUser.getRole() != UserRole.guest) {
            service.add(currentUser.getId(), title, content, boardId);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @PostMapping("/delete")
    public void delete(@RequestBody TopicModel topic) {
        Integer id = topic.getId();
        service.deleteById(id);
    }

    @GetMapping("/edit")
    public ModelAndView edit(int id) {
        TopicModel topic = service.findById(id);
        ModelAndView m = new ModelAndView("topic/edit");
        m.addObject("topic", topic);
        return m;
    }

    @PostMapping("/update")
    public void update(@RequestBody TopicModel form) {
        int id = form.getId();
        String title = form.getTitle();
        String content = form.getContent();
        service.update(id, title, content);
    }

    @GetMapping("/detail/{id}")
    public TopicModel detail(@PathVariable Integer id) {
        TopicModel topicWithComments = service.findById(id);
        return topicWithComments;
    }

    @GetMapping("/some/{userId}")
    public List<TopicModel> some(@PathVariable Integer userId) {
        List<TopicModel> topics = service.findSomeTopicByUserId(userId, 5);
        return topics;
    }

    @GetMapping("/by_user/{userId}")
    public List<TopicModel> topics(@PathVariable Integer userId) {
        List<TopicModel> topics = service.findTopicsByUserId(userId);
        return topics;
    }

    @GetMapping("/by_board_id/{boardId}")
    public List<TopicModel> by_board_id(@PathVariable Integer boardId) {
        List<TopicModel> topics = service.findTopicsByBoardId(boardId);
        return topics;
    }

    @GetMapping({"/", ""})
    @ResponseBody
    public List<TopicModel> index() {
        List<TopicModel> topics = service.all();
        return topics;
    }
}
