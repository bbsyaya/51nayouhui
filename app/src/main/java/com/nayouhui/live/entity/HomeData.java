package com.nayouhui.live.entity;

import java.util.List;

/**
 * 天朗信息技术有限公司
 *
 * @author vintage
 *         Created by Asus on 2017/10/10.
 * @link http://www.sd0534.com/
 * $desc$
 */
public class HomeData {

    @Override
    public String toString() {
        return "HomeData{" +
                "version='" + version + '\'' +
                ", banner=" + banner +
                ", list=" + list +
                '}';
    }

    /**
     * version : 001
     * banner : [{"name":"微粒贷","id":"1","url":"www.baidu.com","pic":"www.qq.com"}]
     * list : [{"id":1,"name":"微粒贷","url":"www.baidu.com","pic":"www.qq.com","dayRate":0.03,"monthRate":0,"apply":100}]
     */

    private String version;
    private List<BannerBean> banner;
    private List<ListBean> list;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<BannerBean> getBanner() {
        return banner;
    }

    public void setBanner(List<BannerBean> banner) {
        this.banner = banner;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class BannerBean {
        /**
         * name : 微粒贷
         * id : 1
         * url : www.baidu.com
         * pic : www.qq.com
         */

        private String name;
        private String id;
        private String url;
        private String pic;

        @Override
        public String toString() {
            return "BannerBean{" +
                    "name='" + name + '\'' +
                    ", id='" + id + '\'' +
                    ", url='" + url + '\'' +
                    ", pic='" + pic + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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
    }

    public static class ListBean {
        /**
         * id : 1
         * name : 微粒贷
         * url : www.baidu.com
         * pic : www.qq.com
         * dayRate : 0.03
         * monthRate : 0
         * apply : 100
         */

        private int id;
        private String name;
        private String url;
        private String pic;
        private double dayRate;
        private int monthRate;
        private int apply;

        @Override
        public String toString() {
            return "ListBean{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", url='" + url + '\'' +
                    ", pic='" + pic + '\'' +
                    ", dayRate=" + dayRate +
                    ", monthRate=" + monthRate +
                    ", apply=" + apply +
                    '}';
        }

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

        public double getDayRate() {
            return dayRate;
        }

        public void setDayRate(double dayRate) {
            this.dayRate = dayRate;
        }

        public int getMonthRate() {
            return monthRate;
        }

        public void setMonthRate(int monthRate) {
            this.monthRate = monthRate;
        }

        public int getApply() {
            return apply;
        }

        public void setApply(int apply) {
            this.apply = apply;
        }
    }
}
