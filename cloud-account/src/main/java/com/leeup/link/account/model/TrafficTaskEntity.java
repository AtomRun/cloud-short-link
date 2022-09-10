package com.leeup.link.account.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.leeup.link.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author cLee
 * @since 2022-09-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("traffic_task")
public class TrafficTaskEntity extends BaseEntity implements Serializable {


    @Serial
    private static final long serialVersionUID = 6036668273527882057L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账号Id
     */
    private Long accountNo;

    /**
     * 流量包Id
     */
    private Long trafficId;

    /**
     * 解决数据一致性问题
     */
    private Integer useTimes;

    /**
     * 锁定状态锁定LOCK 0, 完成FINISH 1, 取消CANCEL 2
     */
    private Integer lockState;

    /**
     * 唯⼀标识
     */
    private String messageId;

    private Date gmtCreate;

    private Date gmtModified;


}
