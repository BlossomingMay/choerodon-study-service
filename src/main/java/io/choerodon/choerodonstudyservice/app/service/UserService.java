package io.choerodon.choerodonstudyservice.app.service;

import io.choerodon.choerodonstudyservice.infra.dto.UserDTO;

public interface UserService {
    UserDTO queryInfo(Long userId);
    UserDTO insert(UserDTO userDTO);
}
