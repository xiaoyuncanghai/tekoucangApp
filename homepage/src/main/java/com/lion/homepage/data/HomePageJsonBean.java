package com.lion.homepage.data;

import java.util.List;

public class HomePageJsonBean {

    private int status;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String filing_info;
        private List<BannerBean> banner;
        private List<MenusBean> menus;
        private List<?> roll;
        private InfoBean info;
        private List<ActivityBean> activity;
        private List<LovelyBean> lovely;
        private List<?> benefit;
        private List<LikeInfoBean> likeInfo;
        private String logoUrl;
        private List<?> couponList;
        private String site_name;
        private boolean subscribe;
        private String newGoodsBananr;
        private String tengxun_map_key;
        private List<?> explosive_money;
        private AppBean app;

        public String getFiling_info() {
            return filing_info;
        }

        public void setFiling_info(String filing_info) {
            this.filing_info = filing_info;
        }

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<MenusBean> getMenus() {
            return menus;
        }

        public void setMenus(List<MenusBean> menus) {
            this.menus = menus;
        }

        public List<?> getRoll() {
            return roll;
        }

        public void setRoll(List<?> roll) {
            this.roll = roll;
        }

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public List<ActivityBean> getActivity() {
            return activity;
        }

        public void setActivity(List<ActivityBean> activity) {
            this.activity = activity;
        }

        public List<LovelyBean> getLovely() {
            return lovely;
        }

        public void setLovely(List<LovelyBean> lovely) {
            this.lovely = lovely;
        }

        public List<?> getBenefit() {
            return benefit;
        }

        public void setBenefit(List<?> benefit) {
            this.benefit = benefit;
        }

        public List<LikeInfoBean> getLikeInfo() {
            return likeInfo;
        }

        public void setLikeInfo(List<LikeInfoBean> likeInfo) {
            this.likeInfo = likeInfo;
        }

        public String getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
        }

        public List<?> getCouponList() {
            return couponList;
        }

        public void setCouponList(List<?> couponList) {
            this.couponList = couponList;
        }

        public String getSite_name() {
            return site_name;
        }

        public void setSite_name(String site_name) {
            this.site_name = site_name;
        }

        public boolean isSubscribe() {
            return subscribe;
        }

        public void setSubscribe(boolean subscribe) {
            this.subscribe = subscribe;
        }

        public String getNewGoodsBananr() {
            return newGoodsBananr;
        }

        public void setNewGoodsBananr(String newGoodsBananr) {
            this.newGoodsBananr = newGoodsBananr;
        }

        public String getTengxun_map_key() {
            return tengxun_map_key;
        }

        public void setTengxun_map_key(String tengxun_map_key) {
            this.tengxun_map_key = tengxun_map_key;
        }

        public List<?> getExplosive_money() {
            return explosive_money;
        }

        public void setExplosive_money(List<?> explosive_money) {
            this.explosive_money = explosive_money;
        }

        public AppBean getApp() {
            return app;
        }

        public void setApp(AppBean app) {
            this.app = app;
        }

        public static class InfoBean {
            private String fastInfo;
            private String bastInfo;
            private String firstInfo;
            private String salesInfo;
            private List<FastListBean> fastList;
            private List<?> bastList;
            private List<FirstListBean> firstList;
            private List<BastBannerBean> bastBanner;

            public String getFastInfo() {
                return fastInfo;
            }

            public void setFastInfo(String fastInfo) {
                this.fastInfo = fastInfo;
            }

            public String getBastInfo() {
                return bastInfo;
            }

            public void setBastInfo(String bastInfo) {
                this.bastInfo = bastInfo;
            }

            public String getFirstInfo() {
                return firstInfo;
            }

            public void setFirstInfo(String firstInfo) {
                this.firstInfo = firstInfo;
            }

            public String getSalesInfo() {
                return salesInfo;
            }

            public void setSalesInfo(String salesInfo) {
                this.salesInfo = salesInfo;
            }

            public List<FastListBean> getFastList() {
                return fastList;
            }

            public void setFastList(List<FastListBean> fastList) {
                this.fastList = fastList;
            }

            public List<?> getBastList() {
                return bastList;
            }

            public void setBastList(List<?> bastList) {
                this.bastList = bastList;
            }

            public List<FirstListBean> getFirstList() {
                return firstList;
            }

            public void setFirstList(List<FirstListBean> firstList) {
                this.firstList = firstList;
            }

            public List<BastBannerBean> getBastBanner() {
                return bastBanner;
            }

            public void setBastBanner(List<BastBannerBean> bastBanner) {
                this.bastBanner = bastBanner;
            }

            public static class FastListBean {
                private int id;
                private String cate_name;
                private int pid;
                private String pic;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getCate_name() {
                    return cate_name;
                }

                public void setCate_name(String cate_name) {
                    this.cate_name = cate_name;
                }

                public int getPid() {
                    return pid;
                }

                public void setPid(int pid) {
                    this.pid = pid;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }
            }

            public static class FirstListBean {
                private int id;
                private String image;
                private String store_name;
                private String cate_id;
                private String price;
                private String unit_name;
                private String sales;
                private List<?> activity;
                private String vip_price;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
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

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getUnit_name() {
                    return unit_name;
                }

                public void setUnit_name(String unit_name) {
                    this.unit_name = unit_name;
                }

                public String getSales() {
                    return sales;
                }

                public void setSales(String sales) {
                    this.sales = sales;
                }

                public List<?> getActivity() {
                    return activity;
                }

                public void setActivity(List<?> activity) {
                    this.activity = activity;
                }

                public String getVip_price() {
                    return vip_price;
                }

                public void setVip_price(String vip_price) {
                    this.vip_price = vip_price;
                }
            }

            public static class BastBannerBean {
                private int id;
                private String img;
                private String comment;
                private String link;
                private String wap_link;
            }
        }

        public static class AppBean {
            private List<LastList> last_list;
            private List<UserBestListBean> user_best_list;

            public List<LastList> getLast_list() {
                return last_list;
            }

            public void setLast_list(List<LastList> last_list) {
                this.last_list = last_list;
            }

            public List<UserBestListBean> getUser_best_list() {
                return user_best_list;
            }

            public void setUser_best_list(List<UserBestListBean> user_best_list) {
                this.user_best_list = user_best_list;
            }

            public static class LastList {
                private int id;
                private int mer_id;
                private String image;
                private List<String> slider_image;
                private String store_name;
                private String store_info;
                private String keyword;
                private String bar_code;
                private String cate_id;
                private double price;
                private double vip_price;
                private double ot_price;
                private String postage;
                private String unit_name;
                private int sort;
                private int sales;
                private int stock;
                private int is_show;
                private int is_hot;
                private int is_benefit;
                private int is_best;
                private int is_new;
                private int add_time;
                private int is_postage;
                private int is_del;
                private int mer_use;
                private String give_integral;
                private String cost;
                private int is_seckill;
                private Object is_bargain;
                private int is_good;
                private int is_sub;
                private int ficti;
                private int browse;
                private String code_path;
                private String soure_link;
                private String video_link;
                private int temp_id;
                private int spec_type;
                private String activity;
                private int level_type_id;
                private String expire_time;
                private int sell_sum;
                private int level_type_product_id;
                private String unit_money;
                private String max_use_integral;
                private int buy_limit;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getMer_id() {
                    return mer_id;
                }

                public void setMer_id(int mer_id) {
                    this.mer_id = mer_id;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public List<String> getSlider_image() {
                    return slider_image;
                }

                public void setSlider_image(List<String> slider_image) {
                    this.slider_image = slider_image;
                }

                public String getStore_name() {
                    return store_name;
                }

                public void setStore_name(String store_name) {
                    this.store_name = store_name;
                }

                public String getStore_info() {
                    return store_info;
                }

                public void setStore_info(String store_info) {
                    this.store_info = store_info;
                }

                public String getKeyword() {
                    return keyword;
                }

                public void setKeyword(String keyword) {
                    this.keyword = keyword;
                }

                public String getBar_code() {
                    return bar_code;
                }

                public void setBar_code(String bar_code) {
                    this.bar_code = bar_code;
                }

                public String getCate_id() {
                    return cate_id;
                }

                public void setCate_id(String cate_id) {
                    this.cate_id = cate_id;
                }

                public double getPrice() {
                    return price;
                }

                public void setPrice(double price) {
                    this.price = price;
                }

                public double getVip_price() {
                    return vip_price;
                }

                public void setVip_price(double vip_price) {
                    this.vip_price = vip_price;
                }

                public double getOt_price() {
                    return ot_price;
                }

                public void setOt_price(double ot_price) {
                    this.ot_price = ot_price;
                }

                public String getPostage() {
                    return postage;
                }

                public void setPostage(String postage) {
                    this.postage = postage;
                }

                public String getUnit_name() {
                    return unit_name;
                }

                public void setUnit_name(String unit_name) {
                    this.unit_name = unit_name;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public int getSales() {
                    return sales;
                }

                public void setSales(int sales) {
                    this.sales = sales;
                }

                public int getStock() {
                    return stock;
                }

                public void setStock(int stock) {
                    this.stock = stock;
                }

                public int getIs_show() {
                    return is_show;
                }

                public void setIs_show(int is_show) {
                    this.is_show = is_show;
                }

                public int getIs_hot() {
                    return is_hot;
                }

                public void setIs_hot(int is_hot) {
                    this.is_hot = is_hot;
                }

                public int getIs_benefit() {
                    return is_benefit;
                }

                public void setIs_benefit(int is_benefit) {
                    this.is_benefit = is_benefit;
                }

                public int getIs_best() {
                    return is_best;
                }

                public void setIs_best(int is_best) {
                    this.is_best = is_best;
                }

                public int getIs_new() {
                    return is_new;
                }

                public void setIs_new(int is_new) {
                    this.is_new = is_new;
                }

                public int getAdd_time() {
                    return add_time;
                }

                public void setAdd_time(int add_time) {
                    this.add_time = add_time;
                }

                public int getIs_postage() {
                    return is_postage;
                }

                public void setIs_postage(int is_postage) {
                    this.is_postage = is_postage;
                }

                public int getIs_del() {
                    return is_del;
                }

                public void setIs_del(int is_del) {
                    this.is_del = is_del;
                }

                public int getMer_use() {
                    return mer_use;
                }

                public void setMer_use(int mer_use) {
                    this.mer_use = mer_use;
                }

                public String getGive_integral() {
                    return give_integral;
                }

                public void setGive_integral(String give_integral) {
                    this.give_integral = give_integral;
                }

                public String getCost() {
                    return cost;
                }

                public void setCost(String cost) {
                    this.cost = cost;
                }

                public int getIs_seckill() {
                    return is_seckill;
                }

                public void setIs_seckill(int is_seckill) {
                    this.is_seckill = is_seckill;
                }

                public Object getIs_bargain() {
                    return is_bargain;
                }

                public void setIs_bargain(Object is_bargain) {
                    this.is_bargain = is_bargain;
                }

                public int getIs_good() {
                    return is_good;
                }

                public void setIs_good(int is_good) {
                    this.is_good = is_good;
                }

                public int getIs_sub() {
                    return is_sub;
                }

                public void setIs_sub(int is_sub) {
                    this.is_sub = is_sub;
                }

                public int getFicti() {
                    return ficti;
                }

                public void setFicti(int ficti) {
                    this.ficti = ficti;
                }

                public int getBrowse() {
                    return browse;
                }

                public void setBrowse(int browse) {
                    this.browse = browse;
                }

                public String getCode_path() {
                    return code_path;
                }

                public void setCode_path(String code_path) {
                    this.code_path = code_path;
                }

                public String getSoure_link() {
                    return soure_link;
                }

                public void setSoure_link(String soure_link) {
                    this.soure_link = soure_link;
                }

                public String getVideo_link() {
                    return video_link;
                }

                public void setVideo_link(String video_link) {
                    this.video_link = video_link;
                }

                public int getTemp_id() {
                    return temp_id;
                }

                public void setTemp_id(int temp_id) {
                    this.temp_id = temp_id;
                }

                public int getSpec_type() {
                    return spec_type;
                }

                public void setSpec_type(int spec_type) {
                    this.spec_type = spec_type;
                }

                public String getActivity() {
                    return activity;
                }

                public void setActivity(String activity) {
                    this.activity = activity;
                }

                public int getLevel_type_id() {
                    return level_type_id;
                }

                public void setLevel_type_id(int level_type_id) {
                    this.level_type_id = level_type_id;
                }

                public String getExpire_time() {
                    return expire_time;
                }

                public void setExpire_time(String expire_time) {
                    this.expire_time = expire_time;
                }

                public int getSell_sum() {
                    return sell_sum;
                }

                public void setSell_sum(int sell_sum) {
                    this.sell_sum = sell_sum;
                }

                public int getLevel_type_product_id() {
                    return level_type_product_id;
                }

                public void setLevel_type_product_id(int level_type_product_id) {
                    this.level_type_product_id = level_type_product_id;
                }

                public String getUnit_money() {
                    return unit_money;
                }

                public void setUnit_money(String unit_money) {
                    this.unit_money = unit_money;
                }

                public String getMax_use_integral() {
                    return max_use_integral;
                }

                public void setMax_use_integral(String max_use_integral) {
                    this.max_use_integral = max_use_integral;
                }

                public int getBuy_limit() {
                    return buy_limit;
                }

                public void setBuy_limit(int buy_limit) {
                    this.buy_limit = buy_limit;
                }
            }

            public static class UserBestListBean {
                private int id;
                private int mer_id;
                private String image;
                private List<String> slider_image;
                private String store_name;
                private String store_info;
                private String keyword;
                private String bar_code;
                private String cate_id;
                private double price;
                private double vip_price;
                private double ot_price;
                private String postage;
                private String unit_name;
                private int sort;
                private int sales;
                private int stock;
                private int is_show;
                private int is_hot;
                private int is_benefit;
                private int is_best;
                private int is_new;
                private int add_time;
                private int is_postage;
                private int is_del;
                private int mer_use;
                private String give_integral;
                private String cost;
                private int is_seckill;
                private Object is_bargain;
                private int is_good;
                private int is_sub;
                private int ficti;
                private int browse;
                private String code_path;
                private String soure_link;
                private String video_link;
                private int temp_id;
                private int spec_type;
                private String activity;
                private int level_type_id;
                private String expire_time;
                private int sell_sum;
                private int level_type_product_id;
                private String unit_money;
                private String max_use_integral;
                private int buy_limit;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getMer_id() {
                    return mer_id;
                }

                public void setMer_id(int mer_id) {
                    this.mer_id = mer_id;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public List<String> getSlider_image() {
                    return slider_image;
                }

                public void setSlider_image(List<String> slider_image) {
                    this.slider_image = slider_image;
                }

                public String getStore_name() {
                    return store_name;
                }

                public void setStore_name(String store_name) {
                    this.store_name = store_name;
                }

                public String getStore_info() {
                    return store_info;
                }

                public void setStore_info(String store_info) {
                    this.store_info = store_info;
                }

                public String getKeyword() {
                    return keyword;
                }

                public void setKeyword(String keyword) {
                    this.keyword = keyword;
                }

                public String getBar_code() {
                    return bar_code;
                }

                public void setBar_code(String bar_code) {
                    this.bar_code = bar_code;
                }

                public String getCate_id() {
                    return cate_id;
                }

                public void setCate_id(String cate_id) {
                    this.cate_id = cate_id;
                }

                public double getPrice() {
                    return price;
                }

                public void setPrice(double price) {
                    this.price = price;
                }

                public double getVip_price() {
                    return vip_price;
                }

                public void setVip_price(double vip_price) {
                    this.vip_price = vip_price;
                }

                public double getOt_price() {
                    return ot_price;
                }

                public void setOt_price(double ot_price) {
                    this.ot_price = ot_price;
                }

                public String getPostage() {
                    return postage;
                }

                public void setPostage(String postage) {
                    this.postage = postage;
                }

                public String getUnit_name() {
                    return unit_name;
                }

                public void setUnit_name(String unit_name) {
                    this.unit_name = unit_name;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public int getSales() {
                    return sales;
                }

                public void setSales(int sales) {
                    this.sales = sales;
                }

                public int getStock() {
                    return stock;
                }

                public void setStock(int stock) {
                    this.stock = stock;
                }

                public int getIs_show() {
                    return is_show;
                }

                public void setIs_show(int is_show) {
                    this.is_show = is_show;
                }

                public int getIs_hot() {
                    return is_hot;
                }

                public void setIs_hot(int is_hot) {
                    this.is_hot = is_hot;
                }

                public int getIs_benefit() {
                    return is_benefit;
                }

                public void setIs_benefit(int is_benefit) {
                    this.is_benefit = is_benefit;
                }

                public int getIs_best() {
                    return is_best;
                }

                public void setIs_best(int is_best) {
                    this.is_best = is_best;
                }

                public int getIs_new() {
                    return is_new;
                }

                public void setIs_new(int is_new) {
                    this.is_new = is_new;
                }

                public int getAdd_time() {
                    return add_time;
                }

                public void setAdd_time(int add_time) {
                    this.add_time = add_time;
                }

                public int getIs_postage() {
                    return is_postage;
                }

                public void setIs_postage(int is_postage) {
                    this.is_postage = is_postage;
                }

                public int getIs_del() {
                    return is_del;
                }

                public void setIs_del(int is_del) {
                    this.is_del = is_del;
                }

                public int getMer_use() {
                    return mer_use;
                }

                public void setMer_use(int mer_use) {
                    this.mer_use = mer_use;
                }

                public String getGive_integral() {
                    return give_integral;
                }

                public void setGive_integral(String give_integral) {
                    this.give_integral = give_integral;
                }

                public String getCost() {
                    return cost;
                }

                public void setCost(String cost) {
                    this.cost = cost;
                }

                public int getIs_seckill() {
                    return is_seckill;
                }

                public void setIs_seckill(int is_seckill) {
                    this.is_seckill = is_seckill;
                }

                public Object getIs_bargain() {
                    return is_bargain;
                }

                public void setIs_bargain(Object is_bargain) {
                    this.is_bargain = is_bargain;
                }

                public int getIs_good() {
                    return is_good;
                }

                public void setIs_good(int is_good) {
                    this.is_good = is_good;
                }

                public int getIs_sub() {
                    return is_sub;
                }

                public void setIs_sub(int is_sub) {
                    this.is_sub = is_sub;
                }

                public int getFicti() {
                    return ficti;
                }

                public void setFicti(int ficti) {
                    this.ficti = ficti;
                }

                public int getBrowse() {
                    return browse;
                }

                public void setBrowse(int browse) {
                    this.browse = browse;
                }

                public String getCode_path() {
                    return code_path;
                }

                public void setCode_path(String code_path) {
                    this.code_path = code_path;
                }

                public String getSoure_link() {
                    return soure_link;
                }

                public void setSoure_link(String soure_link) {
                    this.soure_link = soure_link;
                }

                public String getVideo_link() {
                    return video_link;
                }

                public void setVideo_link(String video_link) {
                    this.video_link = video_link;
                }

                public int getTemp_id() {
                    return temp_id;
                }

                public void setTemp_id(int temp_id) {
                    this.temp_id = temp_id;
                }

                public int getSpec_type() {
                    return spec_type;
                }

                public void setSpec_type(int spec_type) {
                    this.spec_type = spec_type;
                }

                public String getActivity() {
                    return activity;
                }

                public void setActivity(String activity) {
                    this.activity = activity;
                }

                public int getLevel_type_id() {
                    return level_type_id;
                }

                public void setLevel_type_id(int level_type_id) {
                    this.level_type_id = level_type_id;
                }

                public String getExpire_time() {
                    return expire_time;
                }

                public void setExpire_time(String expire_time) {
                    this.expire_time = expire_time;
                }

                public int getSell_sum() {
                    return sell_sum;
                }

                public void setSell_sum(int sell_sum) {
                    this.sell_sum = sell_sum;
                }

                public int getLevel_type_product_id() {
                    return level_type_product_id;
                }

                public void setLevel_type_product_id(int level_type_product_id) {
                    this.level_type_product_id = level_type_product_id;
                }

                public String getUnit_money() {
                    return unit_money;
                }

                public void setUnit_money(String unit_money) {
                    this.unit_money = unit_money;
                }

                public String getMax_use_integral() {
                    return max_use_integral;
                }

                public void setMax_use_integral(String max_use_integral) {
                    this.max_use_integral = max_use_integral;
                }

                public int getBuy_limit() {
                    return buy_limit;
                }

                public void setBuy_limit(int buy_limit) {
                    this.buy_limit = buy_limit;
                }
            }
        }

        public static class BannerBean {
            private int id;
            private String name;
            private String url;
            private String pic;
            private String wap_url;

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

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getWap_url() {
                return wap_url;
            }

            public void setWap_url(String wap_url) {
                this.wap_url = wap_url;
            }
        }

        public static class MenusBean {
            private int id;
            private String name;
            private String pic;
            private String url;
            private String show;
            private String wap_url;
            private String app_image;
            private String app_title;
            private String app_catid;

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

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getShow() {
                return show;
            }

            public void setShow(String show) {
                this.show = show;
            }

            public String getWap_url() {
                return wap_url;
            }

            public void setWap_url(String wap_url) {
                this.wap_url = wap_url;
            }

            public String getApp_image() {
                return app_image;
            }

            public void setApp_image(String app_image) {
                this.app_image = app_image;
            }

            public String getApp_title() {
                return app_title;
            }

            public void setApp_title(String app_title) {
                this.app_title = app_title;
            }

            public String getApp_catid() {
                return app_catid;
            }

            public void setApp_catid(String app_catid) {
                this.app_catid = app_catid;
            }
        }

        public static class ActivityBean {
            private int id;
            private String pic;
            private String title;
            private String info;
            private String link;
            private String wap_link;
        }

        public static class LovelyBean {
            private int id;
            private String img;
            private String comment;
            private String link;
            private String wap_link;
        }

        public static class LikeInfoBean {
            private int id;
            private String image;
            private String store_name;
            private String cate_id;
            private String price;
            private String ot_price;
            private String unit_name;
            private List<?> activity;
            private String vip_price;
        }
    }
}
