package com.leeup.link.account.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.leeup.link.common.model.BaseEntity;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@TableName("account")
public class AccountEntity extends BaseEntity implements Serializable {


    @Serial
    private static final long serialVersionUID = 9062089023057468641L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long accountNo;

    /**
     * 头像
     */
    private String headImg;

    /**
     * ⼿机号
     */
    private String phone;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 盐，⽤于个⼈敏感信息处理
     */
    private String secret;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * ⽤户名
     */
    private String username;

    /**
     * 认证级别，DEFAULT，REAL_NAME，ENTERPRISE，访问次数不⼀样
     */
    private Integer authLevel;

}
