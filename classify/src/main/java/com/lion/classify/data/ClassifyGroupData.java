package com.lion.classify.data;

import com.kunminx.linkage.bean.BaseGroupedItem;

public class ClassifyGroupData extends BaseGroupedItem<BaseGroupedItem.ItemInfo> {
    public ClassifyGroupData(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public ClassifyGroupData(ItemInfo itemInfo) {
        super(itemInfo);
    }

    public static class ItemInfo extends BaseGroupedItem.ItemInfo {

        String imgUrl;
        String content;

        public ItemInfo(String title, String group) {
            super(title, group);
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

}
