package kybmig.ssm.service;


import kybmig.ssm.Utility;
import kybmig.ssm.mapper.UserMapper;
import kybmig.ssm.model.UserModel;
import kybmig.ssm.model.UserRole;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserService {
    private UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserModel getUserInfoById(Integer id) {
        UserModel user = this.userMapper.getUserInfoById(id);
        return user;
    }

    public UserModel add(String username, String password) {
        UserModel model = new UserModel();
        model.setUsername(username);
        model.setPassword(password);
        model.setRole(UserRole.normal);

        this.userMapper.insertUser(model);


        return model;
    }

    public void deleteById(Integer id) {
        this.userMapper.deleteUser(id);
    }

    public UserModel update(Integer id, String username, String password) {
        UserModel model = new UserModel();
        model.setId(id);
        model.setUsername(username);
        model.setPassword(password);

        this.userMapper.updateUser(model);
        return model;
    }

    public UserModel findById(Integer id) {
        return this.userMapper.selectUser(id);
    }


    public List<UserModel> all() {
        return this.userMapper.selectAllUser();
    }

    public UserModel guest() {
        UserModel user = new UserModel();
        user.setRole(UserRole.guest);
        user.setId(-1);
        user.setUsername("游客");
        user.setPassword("游客");
        return user;
    }

    public UserModel findByUsername(String username) {
        return userMapper.selectOneByUsername(username);
    }


    public boolean validLogin(String username, String password) {
        UserModel userModel = userMapper.selectOneByUsername(username);

        if (userModel != null && userModel.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }


    public UserModel currentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute("user_id");
        if (id == null) {
            return this.guest();
        }

        UserModel userModel = userMapper.selectUser(id);
        if (userModel == null) {
            userModel = this.guest();
        }

        return userModel;
    }

    public void changePassword(Integer id, String oldPassword, String password) {
        Utility.log("id, oldPassword, password :%s %s %s",id, oldPassword, password);
        userMapper.changePassword(id, oldPassword, password);
    }

}
