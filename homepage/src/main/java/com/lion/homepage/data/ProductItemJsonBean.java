package com.lion.homepage.data;

import java.util.List;

public class ProductItemJsonBean {

    private int status;
    private String msg;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int id;
        private String store_name;
        private String cate_id;
        private String image;
        private int sales;
        private double price;
        private int stock;
        private int spec_type;
        private int level_type_id;
        private double ot_price;
        private String expire_time;
        private String max_use_integral;
        private List<?> activity;
        private double use_integral_price;
        private double vip_price;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStore_name() {
            return store_name;
        }

        public void setStore_name(String store_name) {
            this.store_name = store_name;
        }

        public String getCate_id() {
            return cate_id;
        }

        public void setCate_id(String cate_id) {
            this.cate_id = cate_id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getSales() {
            return sales;
        }

        public void setSales(int sales) {
            this.sales = sales;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public int getSpec_type() {
            return spec_type;
        }

        public void setSpec_type(int spec_type) {
            this.spec_type = spec_type;
        }

        public int getLevel_type_id() {
            return level_type_id;
        }

        public void setLevel_type_id(int level_type_id) {
            this.level_type_id = level_type_id;
        }

        public double getOt_price() {
            return ot_price;
        }

        public void setOt_price(double ot_price) {
            this.ot_price = ot_price;
        }

        public String getExpire_time() {
            return expire_time;
        }

        public void setExpire_time(String expire_time) {
            this.expire_time = expire_time;
        }

        public String getMax_use_integral() {
            return max_use_integral;
        }

        public void setMax_use_integral(String max_use_integral) {
            this.max_use_integral = max_use_integral;
        }

        public List<?> getActivity() {
            return activity;
        }

        public void setActivity(List<?> activity) {
            this.activity = activity;
        }

        public double getUse_integral_price() {
            return use_integral_price;
        }

        public void setUse_integral_price(double use_integral_price) {
            this.use_integral_price = use_integral_price;
        }

        public double getVip_price() {
            return vip_price;
        }

        public void setVip_price(double vip_price) {
            this.vip_price = vip_price;
        }
    }
}
