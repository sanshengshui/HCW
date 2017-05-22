package com.haro.netty.test.pojo;

import java.util.Date;

/**
 * @author 穆书伟
 * @description domain类
 * @date 2017/5/22 18:35
 */
public class DeviceStatus {

    private int eqp_id;

    private Date create_time;

    private int deleted;

    private String eqp_comid;

    private int location_id;

    private String eqp_location;

    private int brand_id;

    private int eqptype_id;

    private int card_reader;

    private Date install_time;

    private String iccid;

    private int status_id;

    private int check_status;

    private int statuscy_id;

    public int getStatuscy_id() {
        return statuscy_id;
    }

    public void setStatuscy_id(int statuscy_id) {
        this.statuscy_id = statuscy_id;
    }

    public int getEqp_id() {
        return eqp_id;
    }

    public void setEqp_id(int eqp_id) {
        this.eqp_id = eqp_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public String getEqp_comid() {
        return eqp_comid;
    }

    public void setEqp_comid(String eqp_comid) {
        this.eqp_comid = eqp_comid;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public String getEqp_location() {
        return eqp_location;
    }

    public void setEqp_location(String eqp_location) {
        this.eqp_location = eqp_location;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public int getEqptype_id() {
        return eqptype_id;
    }

    public void setEqptype_id(int eqptype_id) {
        this.eqptype_id = eqptype_id;
    }

    public int getCard_reader() {
        return card_reader;
    }

    public void setCard_reader(int card_reader) {
        this.card_reader = card_reader;
    }

    public Date getInstall_time() {
        return install_time;
    }

    public void setInstall_time(Date install_time) {
        this.install_time = install_time;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getCheck_status() {
        return check_status;
    }

    public void setCheck_status(int check_status) {
        this.check_status = check_status;
    }
}
