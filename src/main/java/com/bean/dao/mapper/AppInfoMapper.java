package com.bean.dao.mapper;

import com.sun.deploy.ui.AppInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
* 接入网关的应用信息mapper
*
 * @author Bin.y
 */
@Mapper
public interface AppInfoMapper {
    @Select("SELECT * FROM app WHERE app_key = #{appKey}")
    AppInfo findByAppKey(@Param("appKey") String appKey);

}