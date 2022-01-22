package com.example.demo15.T15Bean;

import java.util.List;

public class WeatherBean {


    private String msg;
    private int code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private TodayBean today;
        private List<WeatherListBean> weatherList;

        public TodayBean getToday() {
            return today;
        }

        public void setToday(TodayBean today) {
            this.today = today;
        }

        public List<WeatherListBean> getWeatherList() {
            return weatherList;
        }

        public void setWeatherList(List<WeatherListBean> weatherList) {
            this.weatherList = weatherList;
        }

        public static class TodayBean {
            private AirQuantityBean airQuantity;
            private ComfortLevelBean comfortLevel;
            private TempInfoBean tempInfo;
            private String updateTime;
            private WindBean wind;
            private List<HoursBean> hours;

            public AirQuantityBean getAirQuantity() {
                return airQuantity;
            }

            public void setAirQuantity(AirQuantityBean airQuantity) {
                this.airQuantity = airQuantity;
            }

            public ComfortLevelBean getComfortLevel() {
                return comfortLevel;
            }

            public void setComfortLevel(ComfortLevelBean comfortLevel) {
                this.comfortLevel = comfortLevel;
            }

            public TempInfoBean getTempInfo() {
                return tempInfo;
            }

            public void setTempInfo(TempInfoBean tempInfo) {
                this.tempInfo = tempInfo;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public List<HoursBean> getHours() {
                return hours;
            }

            public void setHours(List<HoursBean> hours) {
                this.hours = hours;
            }

            public static class AirQuantityBean {
                private int no2;
                private int pm25;
                private int o3;
                private int so2;
                private int pm10;
                private double co;

                public int getNo2() {
                    return no2;
                }

                public void setNo2(int no2) {
                    this.no2 = no2;
                }

                public int getPm25() {
                    return pm25;
                }

                public void setPm25(int pm25) {
                    this.pm25 = pm25;
                }

                public int getO3() {
                    return o3;
                }

                public void setO3(int o3) {
                    this.o3 = o3;
                }

                public int getSo2() {
                    return so2;
                }

                public void setSo2(int so2) {
                    this.so2 = so2;
                }

                public int getPm10() {
                    return pm10;
                }

                public void setPm10(int pm10) {
                    this.pm10 = pm10;
                }

                public double getCo() {
                    return co;
                }

                public void setCo(double co) {
                    this.co = co;
                }
            }

            public static class ComfortLevelBean {
                private int uv;
                private String dressingIndex;
                private int humidity;
                private String coldIndex;
                private int apparentTemperature;
                private String uvIndex;
                private String washIndex;
                private String sportIndex;

                public int getUv() {
                    return uv;
                }

                public void setUv(int uv) {
                    this.uv = uv;
                }

                public String getDressingIndex() {
                    return dressingIndex;
                }

                public void setDressingIndex(String dressingIndex) {
                    this.dressingIndex = dressingIndex;
                }

                public int getHumidity() {
                    return humidity;
                }

                public void setHumidity(int humidity) {
                    this.humidity = humidity;
                }

                public String getColdIndex() {
                    return coldIndex;
                }

                public void setColdIndex(String coldIndex) {
                    this.coldIndex = coldIndex;
                }

                public int getApparentTemperature() {
                    return apparentTemperature;
                }

                public void setApparentTemperature(int apparentTemperature) {
                    this.apparentTemperature = apparentTemperature;
                }

                public String getUvIndex() {
                    return uvIndex;
                }

                public void setUvIndex(String uvIndex) {
                    this.uvIndex = uvIndex;
                }

                public String getWashIndex() {
                    return washIndex;
                }

                public void setWashIndex(String washIndex) {
                    this.washIndex = washIndex;
                }

                public String getSportIndex() {
                    return sportIndex;
                }

                public void setSportIndex(String sportIndex) {
                    this.sportIndex = sportIndex;
                }
            }

            public static class TempInfoBean {
                private String maxTemperature;
                private String uv;
                private String minTemperature;
                private String temperature;
                private String weather;
                private String humidity;
                private String air;
                private String apparentTemperature;
                private String label;
                private String day;

                public String getMaxTemperature() {
                    return maxTemperature;
                }

                public void setMaxTemperature(String maxTemperature) {
                    this.maxTemperature = maxTemperature;
                }

                public String getUv() {
                    return uv;
                }

                public void setUv(String uv) {
                    this.uv = uv;
                }

                public String getMinTemperature() {
                    return minTemperature;
                }

                public void setMinTemperature(String minTemperature) {
                    this.minTemperature = minTemperature;
                }

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public String getHumidity() {
                    return humidity;
                }

                public void setHumidity(String humidity) {
                    this.humidity = humidity;
                }

                public String getAir() {
                    return air;
                }

                public void setAir(String air) {
                    this.air = air;
                }

                public String getApparentTemperature() {
                    return apparentTemperature;
                }

                public void setApparentTemperature(String apparentTemperature) {
                    this.apparentTemperature = apparentTemperature;
                }

                public String getLabel() {
                    return label;
                }

                public void setLabel(String label) {
                    this.label = label;
                }

                public String getDay() {
                    return day;
                }

                public void setDay(String day) {
                    this.day = day;
                }
            }

            public static class WindBean {
                private String windStrength;
                private String windDirection;

                public String getWindStrength() {
                    return windStrength;
                }

                public void setWindStrength(String windStrength) {
                    this.windStrength = windStrength;
                }

                public String getWindDirection() {
                    return windDirection;
                }

                public void setWindDirection(String windDirection) {
                    this.windDirection = windDirection;
                }
            }

            public static class HoursBean {
                private String hour;
                private String weather;
                private int temperature;

                public String getHour() {
                    return hour;
                }

                public void setHour(String hour) {
                    this.hour = hour;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public int getTemperature() {
                    return temperature;
                }

                public void setTemperature(int temperature) {
                    this.temperature = temperature;
                }
            }
        }

        public static class WeatherListBean {
            private String maxTemperature;
            private String uv;
            private String minTemperature;
            private String temperature;
            private String weather;
            private int humidity;
            private String air;
            private String apparentTemperature;
            private String label;
            private String day;

            public String getMaxTemperature() {
                return maxTemperature;
            }

            public void setMaxTemperature(String maxTemperature) {
                this.maxTemperature = maxTemperature;
            }

            public String getUv() {
                return uv;
            }

            public void setUv(String uv) {
                this.uv = uv;
            }

            public String getMinTemperature() {
                return minTemperature;
            }

            public void setMinTemperature(String minTemperature) {
                this.minTemperature = minTemperature;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public int getHumidity() {
                return humidity;
            }

            public void setHumidity(int humidity) {
                this.humidity = humidity;
            }

            public String getAir() {
                return air;
            }

            public void setAir(String air) {
                this.air = air;
            }

            public String getApparentTemperature() {
                return apparentTemperature;
            }

            public void setApparentTemperature(String apparentTemperature) {
                this.apparentTemperature = apparentTemperature;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }
        }
    }
}
