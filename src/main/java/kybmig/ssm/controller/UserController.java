package kybmig.ssm.controller;


import kybmig.ssm.Utility;
import kybmig.ssm.model.UserModel;
import kybmig.ssm.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public UserModel login(@RequestBody UserModel form, HttpServletRequest request, HttpServletResponse response) {
        String username = form.getUsername();
        String password = form.getPassword();
        if (service.validLogin(username, password)) {
            UserModel current = service.findByUsername(username);
            HttpSession session = request.getSession();
            session.setAttribute("user_id", current.getId());
            return current;
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
    }

    @PostMapping("/add")
    public void register(@RequestBody UserModel form) {
        String username = form.getUsername();
        String password = form.getPassword();
        service.add(username, password);
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
    }

    @PostMapping("/changePassword")
    public void changePassword(@RequestBody ChangePasswordForm form, HttpServletRequest request, HttpServletResponse response) {
        String oldPassword = form.getOldPassword();
        String password = form.getPassword();
        if (!request.isRequestedSessionIdValid()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            HttpSession session = request.getSession();
            Integer id = (Integer) session.getAttribute("user_id");
            UserModel user = service.findById(id);
            if (user == null) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            } else {
                if (user.getPassword().equals(oldPassword)) {
                    service.changePassword(id, oldPassword, password);
                } else {
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                }
            }

        }
    }

    @GetMapping("/info")
    public UserModel info(@Param("id") Integer id) {
        UserModel user = service.findById(id);
        return user;
    }

}


class ChangePasswordForm {
    private String password;
    private String oldPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
