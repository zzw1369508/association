package com.zzw.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zzw.dao.UserRankMapper;
import com.zzw.entity.UserRank;
import com.zzw.service.UserRankService;
import org.springframework.stereotype.Service;

@Service
public class UserRankServiceImpl extends ServiceImpl<UserRankMapper, UserRank> implements UserRankService {

}
