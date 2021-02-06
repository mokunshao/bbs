package kybmig.ssm.controller;

import kybmig.ssm.model.UserModel;
import kybmig.ssm.service.UserService;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PublicController {

    private UserService userService;

    public PublicController(UserService service) {
        this.userService = service;
    }
    @GetMapping("/")
    public ModelAndView index(HttpServletRequest request) {
        UserModel current = userService.currentUser(request);

        // model 说的是给模板引擎的 model
        // view 说的是模板名字，没有后缀
        // view 可以自动补全，也可以直接跳转
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("username", current.getUsername());
        return mv;
    }
}
