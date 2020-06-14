import com.shimmeringlight.dp.dao.UserMapper;
import com.shimmeringlight.dp.dao.impl.UserMapperImpl;
import com.shimmeringlight.dp.entity.User;
import org.junit.Test;

import java.util.List;

public class UserTest
{
    @Test
    public void test() throws Exception
    {
        UserMapper userMapper = new UserMapperImpl();
        userMapper.insert("Test","password");
        userMapper.insert("Test2","password2");
        List<User> users = userMapper.findAll();
        assert users.size() > 0;
        User user = users.get(0);
        user.setUserName("Changed");
        userMapper.updateByEntity(user);
        User find = userMapper.findByUserName("Changed");
        for(User e: users)
            userMapper.deleteById(e.getUserId());
    }
}
