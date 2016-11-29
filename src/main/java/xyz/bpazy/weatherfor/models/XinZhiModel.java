package xyz.bpazy.weatherfor.models;

import xyz.bpazy.weatherfor.api.WeatherDaily;

import java.util.List;

/**
 * Created by Ziyuan.
 * 2016/11/26 22:30
 */
public class XinZhiModel {
    private List<XinZhiModelResult> results;

    public List<XinZhiModelResult> getResults() {
        return results;
    }

    public void setResults(List<XinZhiModelResult> results) {
        this.results = results;
    }

    public static class XinZhiModelResult {
        /**
         * location : {"id":"WX4FBXXFKE4F","name":"北京","country":"CN","path":"北京,北京,中国","timezone":"Asia/Shanghai",
         * "timezone_offset":"+08:00"}
         * daily : [{"date":"2016-11-26","text_day":"霾","code_day":"31","text_night":"霾","code_night":"31",
         * "high":"8","low":"-1","precip":"","wind_direction":"无持续风向","wind_direction_degree":"0","wind_speed":"10",
         * "wind_scale":"2"},{"date":"2016-11-27","text_day":"晴","code_day":"0","text_night":"晴","code_night":"0",
         * "high":"7","low":"-5","precip":"","wind_direction":"无持续风向","wind_direction_degree":"","wind_speed":"15",
         * "wind_scale":"3"},{"date":"2016-11-28","text_day":"晴","code_day":"0","text_night":"霾","code_night":"31",
         * "high":"7","low":"-4","precip":"","wind_direction":"无持续风向","wind_direction_degree":"","wind_speed":"10",
         * "wind_scale":"2"}]
         * last_update : 2016-11-26T18:00:00+08:00
         */

        private LocationBean location;
        private String last_update;
        private List<DailyBean> daily;

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public String getLastUpdate() {
            return last_update;
        }

        public void setLastUpdate(String last_update) {
            this.last_update = last_update;
        }

        public List<DailyBean> getDaily() {
            return daily;
        }

        public void setDaily(List<DailyBean> daily) {
            this.daily = daily;
        }

        public static class LocationBean {
            /**
             * id : WX4FBXXFKE4F
             * name : 北京
             * country : CN
             * path : 北京,北京,中国
             * timezone : Asia/Shanghai
             * timezone_offset : +08:00
             */

            private String id;
            private String name;
            private String country;
            private String path;
            private String timezone;
            private String timezone_offset;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public String getTimezone() {
                return timezone;
            }

            public void setTimezone(String timezone) {
                this.timezone = timezone;
            }

            public String getTimezoneOffset() {
                return timezone_offset;
            }

            public void setTimezoneOffset(String timezone_offset) {
                this.timezone_offset = timezone_offset;
            }
        }

        public static class DailyBean implements WeatherDaily {
            /**
             * date : 2016-11-26
             * text_day : 霾
             * code_day : 31
             * text_night : 霾
             * code_night : 31
             * high : 8
             * low : -1
             * precip :
             * wind_direction : 无持续风向
             * wind_direction_degree : 0
             * wind_speed : 10
             * wind_scale : 2
             */

            private String date;
            private String text_day;
            private String code_day;
            private String text_night;
            private String code_night;
            private String high;
            private String low;
            private String precip;
            private String wind_direction;
            private String wind_direction_degree;
            private String wind_speed;
            private String wind_scale;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getTextDay() {
                return text_day;
            }

            public void setTextDay(String text_day) {
                this.text_day = text_day;
            }

            public String getLow() {
                return low;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getWindDirection() {
                return wind_direction;
            }

            public void setWindDirection(String wind_direction) {
                this.wind_direction = wind_direction;
            }

            public String getWindScale() {
                return wind_scale;
            }

            public void setWindScale(String wind_scale) {
                this.wind_scale = wind_scale;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getCodeDay() {
                return code_day;
            }

            public void setCodeDay(String code_day) {
                this.code_day = code_day;
            }

            public String getTextNight() {
                return text_night;
            }

            public void setTextNight(String text_night) {
                this.text_night = text_night;
            }

            public String getCodeNight() {
                return code_night;
            }

            public void setCodeNight(String code_night) {
                this.code_night = code_night;
            }

            public String getPrecip() {
                return precip;
            }

            public void setPrecip(String precip) {
                this.precip = precip;
            }

            public String getWindDirectionDegree() {
                return wind_direction_degree;
            }

            public void setWindDirectionDegree(String wind_direction_degree) {
                this.wind_direction_degree = wind_direction_degree;
            }

            public String getWindSpeed() {
                return wind_speed;
            }

            public void setWindSpeed(String wind_speed) {
                this.wind_speed = wind_speed;
            }
        }
    }
}
