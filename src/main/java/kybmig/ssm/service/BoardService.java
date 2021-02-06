package kybmig.ssm.service;


import kybmig.ssm.Utility;
import kybmig.ssm.mapper.BoardMapper;
import kybmig.ssm.mapper.UserMapper;
import kybmig.ssm.model.BoardModel;
import kybmig.ssm.model.UserModel;
import kybmig.ssm.model.UserRole;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class BoardService {
    private BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public List<BoardModel> all() {
        List<BoardModel> r = this.boardMapper.all();
        return r;
    }

//    public UserModel add(String username, String password) {
//        UserModel model = new UserModel();
//        model.setUsername(username);
//        model.setPassword(password);
//        model.setRole(UserRole.normal);
//
//        this.userMapper.insertUser(model);
//
//
//        return model;
//    }

}
