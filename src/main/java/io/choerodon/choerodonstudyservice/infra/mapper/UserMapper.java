package io.choerodon.choerodonstudyservice.infra.mapper;

import io.choerodon.choerodonstudyservice.infra.dto.OrganizationDTO;
import io.choerodon.choerodonstudyservice.infra.dto.UserDTO;
import io.choerodon.mybatis.common.Mapper;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends Mapper<UserDTO> {

    UserDTO getUserById(@Param("userId") Long userId);

}
