package io.choerodon.choerodonstudyservice.app.service.impl;

import io.choerodon.choerodonstudyservice.app.service.OrganizationService;
import io.choerodon.choerodonstudyservice.infra.dto.OrganizationDTO;

import io.choerodon.choerodonstudyservice.infra.mapper.OrganizationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationMapper organizationMapper;

    @Override
    public OrganizationDTO insertOrganization(Long organizationId, OrganizationDTO organizationDTO, String level, Long sourceId) {
        organizationMapper.insert(organizationDTO);
        return organizationDTO;
    }

    @Override
    public OrganizationDTO queryOrganizationById(Long organizationId) {
        return organizationMapper.selectByPrimaryKey(organizationId);
    }


}
