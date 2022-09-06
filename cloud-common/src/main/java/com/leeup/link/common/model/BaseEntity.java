package com.leeup.link.common.model;

import com.baomidou.mybatisplus.annotation.TableField;
import java.util.Date;
import lombok.Data;

@Data
public class BaseEntity {

    @TableField("gmt_create")
    private Date gmtCreate;

    @TableField("gmt_modified")
    private Date gmtModified;
}
