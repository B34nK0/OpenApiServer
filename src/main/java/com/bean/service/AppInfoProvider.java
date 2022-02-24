package com.bean.service;

import com.bean.dao.mapper.AppInfoMapper;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.sun.deploy.ui.AppInfo;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* 应用服务
*/
@Service
public class AppInfoProvider {
    @Autowired
    AppInfoMapper appInfoMapper;
    
    //spring Caffeine cache
    //数据库IO可以通过缓存进行优化
    Cache<String, AppInfo> cache = Caffeine.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .maximumSize(1000)
            .build();

    public AppInfo getAppInfoByAppKey(String appKey){
    		return cache.get(appKey, appInfoMapper::findByAppKey );
    }
}
