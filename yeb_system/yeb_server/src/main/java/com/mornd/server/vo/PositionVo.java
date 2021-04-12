package com.mornd.server.vo;

import com.mornd.server.pojo.Position;
import lombok.Data;

/**
 * @author mornd
 * @date 2021/2/5 - 13:20
 */
@Data
public class PositionVo extends Position {
    private Integer page;
    private Integer size;
}
