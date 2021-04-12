package com.mornd.server.vo;

import lombok.Data;

/**
 * @author mornd
 * @date 2021/2/9 - 23:02
 */
@Data
public class AdminVo {
    private Integer id;
    private String name;
    private String username;
    private Integer page;
    private Integer size;
}
