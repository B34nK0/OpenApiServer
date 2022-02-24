package com.bean.entity;
/**
* app info model
* 
*/
public class AppInfo {
    int id;

    String name;

    String servicePrivateKey;

    String servicePublicKey;

    String publicKey;

    String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServicePrivateKey() {
        return servicePrivateKey;
    }

    public void setServicePrivateKey(String servicePrivateKey) {
        this.servicePrivateKey = servicePrivateKey;
    }

    public String getServicePublicKey() {
        return servicePublicKey;
    }

    public void setServicePublicKey(String servicePublicKey) {
        this.servicePublicKey = servicePublicKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
