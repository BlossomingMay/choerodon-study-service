package io.choerodon.choerodonstudyservice.api.controller.v1;


import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.choerodon.choerodonstudyservice.app.service.OrganizationService;
import io.choerodon.choerodonstudyservice.infra.dto.OrganizationDTO;
import io.choerodon.choerodonstudyservice.infra.feign.IamClient;
import io.choerodon.core.iam.ResourceLevel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/v1/organizations")
public class OrganizationController {
    @Autowired
    private IamClient iamClient;

    @Autowired
    OrganizationService organizationService;

    @Permission(type = ResourceType.SITE,permissionPublic = true)
    @ApiOperation(value = "根据id查询组织并插入到本地数据库")
    @GetMapping(value = "/fromiam/{organization_id}")
    public ResponseEntity<OrganizationDTO> insert(@PathVariable(name = "organization_id") Long id) {
        OrganizationDTO organizationDTO = iamClient.query(id).getBody();
        return new ResponseEntity<>(organizationService.insertOrganization(id, organizationDTO, ResourceLevel.SITE.value(), 0L),
                HttpStatus.OK);
    }

    @Permission(type = ResourceType.SITE,permissionPublic = true)
    @ApiOperation(value = "根据id查询组织")
    @GetMapping(value = "/{organization_id}")
    public ResponseEntity<OrganizationDTO> query(@PathVariable(name = "organization_id") Long id) {
        return new ResponseEntity<>(organizationService.queryOrganizationById(id), HttpStatus.OK);
    }

}
