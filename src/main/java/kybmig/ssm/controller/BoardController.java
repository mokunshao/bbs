package kybmig.ssm.controller;

import kybmig.ssm.model.BoardModel;
import kybmig.ssm.model.UserModel;
import kybmig.ssm.service.BoardService;
import kybmig.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    private BoardService boardService;

    public BoardController(BoardService service) {
        this.boardService = service;
    }

    @GetMapping("/all")
    public List<BoardModel> all() {
        return boardService.all();
//        UserModel current = boardService.currentUser(request);
//
//        // model 说的是给模板引擎的 model
//        // view 说的是模板名字，没有后缀
//        // view 可以自动补全，也可以直接跳转
//        ModelAndView mv = new ModelAndView("index");
//        mv.addObject("username", current.getUsername());
//        return mv;
    }
}
