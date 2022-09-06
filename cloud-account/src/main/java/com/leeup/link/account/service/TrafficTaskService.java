package com.leeup.link.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.leeup.link.account.model.TrafficTaskEntity;
import com.leeup.link.account.mapper.TrafficTaskMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class TrafficTaskService extends ServiceImpl<TrafficTaskMapper, TrafficTaskEntity> implements
        IService<TrafficTaskEntity> {

}
