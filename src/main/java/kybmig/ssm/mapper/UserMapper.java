package kybmig.ssm.mapper;

import kybmig.ssm.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// 这个是 spring 用来在 controller 进行依赖注入的。
@Repository
// 这个是 mybaits spring boot 用来自动跟 xml 联系起来，并注入到 spring 的 session 里面。
@Mapper
public interface UserMapper {
    UserModel getUserInfoById(Integer id);

    void insertUser(UserModel User);

    List<UserModel> selectAllUser();

    UserModel selectUser(int id);

    UserModel selectOneByUsername(String username);

    void updateUser(UserModel User);

    void deleteUser(int id);

    void changePassword(@Param("id") Integer id, @Param("oldPassword")String oldPassword, @Param("password")String password);
}
