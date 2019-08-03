package io.choerodon.choerodonstudyservice.infra.feign;

import io.choerodon.choerodonstudyservice.infra.dto.OrganizationDTO;
import io.choerodon.choerodonstudyservice.infra.dto.UserDTO;
import io.choerodon.choerodonstudyservice.infra.feign.fallback.IamClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * iam service feign client
 * @author superlee
 * @since 2019-06-11
 */
@FeignClient(value = "iam-service", fallback = IamClientFallback.class)
public interface IamClient {

    /**
     * 查询所有菜单
     * @return
     */
    @GetMapping(value = "/v1/organizations/{organization_id}")
    ResponseEntity<OrganizationDTO> query(@PathVariable(name = "organization_id") Long id);

    @GetMapping(value = "/v1/organizations/{organization_id}/users/{user_id}")
    ResponseEntity<UserDTO> queryByUserId(@PathVariable(name = "organization_id") Long id, @PathVariable(name = "user_id") Long userId);
}
