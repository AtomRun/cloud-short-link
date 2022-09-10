package com.leeup.shortlink.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leeup.shortlink.account.mapper.TrafficMapper;
import com.leeup.shortlink.account.model.TrafficEntity;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 流量包表 服务实现类
 * </p>
 *
 * @author cLee
 * @since 2022-09-06
 */
@Service
public class TrafficService extends ServiceImpl<TrafficMapper, TrafficEntity> implements IService<TrafficEntity> {

}
