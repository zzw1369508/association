package com.zzw.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zzw.dao.UserRoleMapper;
import com.zzw.entity.UserRole;
import com.zzw.service.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
