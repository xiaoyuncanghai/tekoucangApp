package com.lion.homepage.data;

import java.util.List;

public class HomePageJsonBean {

    private int status;
    private String msg;
    private DataBean data;

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

        public static class InfoBean {
            private String fastInfo;
            private String bastInfo;
            private String firstInfo;
            private String salesInfo;
            private List<FastListBean> fastList;
            private List<?> bastList;
            private List<FirstListBean> firstList;
            private List<BastBannerBean> bastBanner;

            public static class FastListBean {
                private int id;
                private String cate_name;
                private int pid;
                private String pic;
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
            }

            public static class BastBannerBean {
                private int id;
                private String img;
                private String comment;
                private String link;
                private String wap_link;
            }
        }

        public static class BannerBean {
            private int id;
            private String name;
            private String url;
            private String pic;
            private String wap_url;
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
