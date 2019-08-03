package io.choerodon.choerodonstudyservice.app.service.impl;

import io.choerodon.choerodonstudyservice.app.service.UserService;
import io.choerodon.choerodonstudyservice.infra.dto.OrganizationDTO;
import io.choerodon.choerodonstudyservice.infra.dto.UserDTO;
import io.choerodon.choerodonstudyservice.infra.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

//    public UserServiceImpl(UserMapper userMapper){
//        this.userMapper = userMapper;
//    }

    @Override
    public UserDTO queryInfo(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public UserDTO insert(UserDTO userDTO) {
        userMapper.insert(userDTO);
        return userDTO;
    }
}
