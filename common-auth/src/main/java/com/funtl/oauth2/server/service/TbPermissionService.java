package com.funtl.oauth2.server.service;

import com.funtl.oauth2.server.domain.TbPermission;

import java.util.List;

public interface TbPermissionService{

    List<TbPermission> selectByUserId( Long userId);
}
