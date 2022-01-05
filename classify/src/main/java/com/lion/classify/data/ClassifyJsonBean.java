package com.lion.classify.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ClassifyJsonBean implements Parcelable{

    private int status;
    private String msg;
    private ArrayList<DataBean> data;

    protected ClassifyJsonBean(Parcel in) {
        status = in.readInt();
        msg = in.readString();
        data = in.createTypedArrayList(DataBean.CREATOR);
    }

    public static final Creator<ClassifyJsonBean> CREATOR = new Creator<ClassifyJsonBean>() {
        @Override
        public ClassifyJsonBean createFromParcel(Parcel in) {
            return new ClassifyJsonBean(in);
        }

        @Override
        public ClassifyJsonBean[] newArray(int size) {
            return new ClassifyJsonBean[size];
        }
    };

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

    public ArrayList<DataBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataBean> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(status);
        parcel.writeString(msg);
        parcel.writeTypedList(data);
    }

    public static class DataBean implements Parcelable {
        private int id;
        private int pid;
        private String cate_name;
        private String pic;
        private ArrayList<ChildrenBean> children;

        protected DataBean(Parcel in) {
            id = in.readInt();
            pid = in.readInt();
            cate_name = in.readString();
            pic = in.readString();
            children = in.createTypedArrayList(ChildrenBean.CREATOR);
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getCate_name() {
            return cate_name;
        }

        public void setCate_name(String cate_name) {
            this.cate_name = cate_name;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public ArrayList<ChildrenBean> getChildren() {
            return children;
        }

        public void setChildren(ArrayList<ChildrenBean> children) {
            this.children = children;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int i) {
            dest.writeString(cate_name);
            dest.writeInt(id);
            dest.writeInt(pid);
            dest.writeString(pic);
            dest.writeTypedList(children);
        }

        public static class ChildrenBean implements Parcelable {
            private int id;
            private String cate_name;
            private String pic;

            protected ChildrenBean(Parcel in) {
                id = in.readInt();
                cate_name = in.readString();
                pic = in.readString();
            }

            public static final Creator<ChildrenBean> CREATOR = new Creator<ChildrenBean>() {
                @Override
                public ChildrenBean createFromParcel(Parcel in) {
                    return new ChildrenBean(in);
                }

                @Override
                public ChildrenBean[] newArray(int size) {
                    return new ChildrenBean[size];
                }
            };

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

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int i) {
                dest.writeString(cate_name);
                dest.writeInt(id);
                dest.writeString(pic);
            }
        }
    }
}
