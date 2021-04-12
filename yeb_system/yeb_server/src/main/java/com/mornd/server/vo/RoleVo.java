package com.mornd.server.vo;

import com.mornd.server.pojo.Role;
import lombok.Data;

/**
 * @author mornd
 * @date 2021/2/6 - 16:05
 */
@Data
public class RoleVo extends Role {
    private Integer page;
    private Integer size;
}
