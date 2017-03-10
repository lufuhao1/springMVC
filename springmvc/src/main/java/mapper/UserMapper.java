package mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select count(*) counter, id,username from user where username = #{account} and password = #{password} limit 1")
    Map<String, Object> login(@Param("account") String account,
            @Param("password") String password);

    List<Map<String, Object>> selectAll();
}
