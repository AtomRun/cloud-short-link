package com.leeup.shortlink.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leeup.shortlink.account.mapper.AccountMapper;
import com.leeup.shortlink.account.model.AccountEntity;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cLee
 * @since 2022-09-06
 */
@Service
public class AccountService extends ServiceImpl<AccountMapper, AccountEntity> implements IService<AccountEntity> {

}
