package io.choerodon.choerodonstudyservice.app.service;

import io.choerodon.choerodonstudyservice.infra.dto.OrganizationDTO;


public interface OrganizationService {


    OrganizationDTO queryOrganizationById(Long organizationId);

    OrganizationDTO insertOrganization(Long organizationId, OrganizationDTO organizationDTO, String level, Long sourceId);

}
