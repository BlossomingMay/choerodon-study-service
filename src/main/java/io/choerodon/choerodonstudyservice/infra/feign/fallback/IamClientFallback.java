package io.choerodon.choerodonstudyservice.infra.feign.fallback;

import io.choerodon.choerodonstudyservice.infra.dto.OrganizationDTO;
import io.choerodon.choerodonstudyservice.infra.dto.UserDTO;
import io.choerodon.choerodonstudyservice.infra.feign.IamClient;
import io.choerodon.core.exception.CommonException;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * iam service feign失败回调函数
 *
 * @author huang
 * @since 2019-06-11
 */
public class IamClientFallback implements IamClient {
    /**
     * 查询所有菜单
     *
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<OrganizationDTO> query(Long id) {
        throw new CommonException("error.iam.organization.id.failed");
    }

    @Override
    public ResponseEntity<UserDTO> queryByUserId(Long id, Long userId) {
        throw new CommonException("error.iam.organization.id.failed");
    }


}
