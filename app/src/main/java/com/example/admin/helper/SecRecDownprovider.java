package com.example.admin.helper;

/**
 * Created by Admin on 11/12/2017.
 */

public class SecRecDownprovider {

    private int img_res;
    private String dl_name;

    public SecRecDownprovider(int img_res, String dl_name) {
        this.img_res = img_res;
        this.dl_name = dl_name;
    }

    public int getImg_res() {
        return img_res;
    }

    public void setImg_res(int img_res) {
        this.img_res = img_res;
    }

    public String getDl_name() {
        return dl_name;
    }

    public void setDl_name(String dl_name) {
        this.dl_name = dl_name;
    }
}
