package com.mornd.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author mornd
 * @date 2021/2/5 - 13:24
 * 封装数据表格对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGridView<T> {
    private Integer code;
    private String msg;
    private Long count;
    private List<T> data;


    public DataGridView(Long count, List<T> data) {
        this.count = count;
        this.data = data;
    }
}
