package com.leeup.shortlink.account.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.leeup.shortlink.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 流量包表
 * </p>
 *
 * @author cLee
 * @since 2022-09-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("traffic")
public class TrafficEntity extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -3492476279215811193L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 每天限制多少条短链
     */
    private Integer dayLimit;

    /**
     * 当天⽤了多少条短链
     */
    private Integer dayUsed;

    /**
     * 总次数，活码才⽤
     */
    private Integer totalLimit;

    /**
     * 账号主键
     */
    private Long accountNo;

    /**
     * 订单号
     */
    private String outTradeNo;

    /**
     * 产品层级：FIRST⻘铜、SECOND⻩⾦、THIRD钻⽯
     */
    private Integer level;

    /**
     * 过期⽇期
     */
    private Date expiredDate;

    /**
     * 插件类型
     */
    private String pluginType;

    /**
     * 商品主键
     */
    private Long productId;

    private Date gmtCreate;

    private Date gmtModified;


}
