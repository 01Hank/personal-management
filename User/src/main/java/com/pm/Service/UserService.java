package com.pm.Service;

import com.pm.Pojo.MaiaUser;
import com.pm.Pojo.db.Login;

public interface UserService {
    void  register(MaiaUser user);

    String login (Login logins)throws Exception;
}
