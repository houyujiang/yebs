package com.mornd.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mornd.server.pojo.Admin;
import com.mornd.server.pojo.Role;
import com.mornd.server.vo.AdminVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Set;


/**
 * @author mornd
 * @date 2021/1/26 - 22:14
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    /**
     * 根据用户id查询角色列表
     * @param adminId
     * @return
     */
    Set<Role> getRoles(Integer adminId);

    /**
     * 取所有操作员(不包括当前登录的)
     * @param adminVo
     */
    IPage<Admin> getAllAdminExCurrent(IPage page, @Param("adminVo") AdminVo adminVo);

    /**
     * 除操作员及操作员角色关系表中的数据
     * @param id
     */
    Integer removeRoleByAid(Serializable id);

    /**
     * 更新操作员角色
     * @param adminId
     * @param rids
     * @return
     */
    Integer addAdminRole(@Param("adminId") Integer adminId, @Param("rids") Integer[] rids);
}
