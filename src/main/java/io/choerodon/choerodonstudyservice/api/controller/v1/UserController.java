package io.choerodon.choerodonstudyservice.api.controller.v1;

import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.choerodon.choerodonstudyservice.app.service.UserService;
import io.choerodon.choerodonstudyservice.infra.dto.OrganizationDTO;
import io.choerodon.choerodonstudyservice.infra.dto.UserDTO;
import io.choerodon.choerodonstudyservice.infra.feign.IamClient;
import io.choerodon.core.exception.NotFoundException;
import io.choerodon.core.iam.ResourceLevel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping(value = "/v1/users/")
public class UserController {

    @Autowired
    IamClient iamClient;

    @Autowired
    UserService userService;

    @Permission(type = ResourceType.SITE, permissionPublic = true)
    @ApiOperation(value = "根据id查询用户信息")
    @GetMapping(value = "/{id}/info")
    public ResponseEntity<UserDTO> queryInfo(@PathVariable Long id) {
        return Optional.ofNullable(userService.queryInfo(id))
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseThrow(NotFoundException::new);
    }

    @Permission(type = ResourceType.SITE, permissionPublic = true)
    @ApiOperation(value = "查询并插入id=1的用户信息")
    @GetMapping(value = "/{id}/organization/{organization_id}")
    public ResponseEntity<UserDTO> insert(@PathVariable Long organization_id ,@PathVariable Long id) {
        UserDTO userDTO = iamClient.queryByUserId(organization_id,id).getBody();
        return new ResponseEntity<>(userService.insert(userDTO), HttpStatus.OK);
    }
}
