package com.example.demo.Ts8;

import java.util.List;

public class RecordList {

    private String code;
    private String errMsg;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String total;
        private String pageCount;
        private String currentPage;
        private String pageSize;
        private String hasMore;
        private List<ListBean> list;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getPageCount() {
            return pageCount;
        }

        public void setPageCount(String pageCount) {
            this.pageCount = pageCount;
        }

        public String getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(String currentPage) {
            this.currentPage = currentPage;
        }

        public String getPageSize() {
            return pageSize;
        }

        public void setPageSize(String pageSize) {
            this.pageSize = pageSize;
        }

        public String getHasMore() {
            return hasMore;
        }

        public void setHasMore(String hasMore) {
            this.hasMore = hasMore;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private String ptime;
            private String parea;
            private String carnum;
            private String phands;
            private String pnumber;
            private String psocre;
            private String pmoney;
            private String phandle;

            public String getPtime() {
                return ptime;
            }

            public void setPtime(String ptime) {
                this.ptime = ptime;
            }

            public String getParea() {
                return parea;
            }

            public void setParea(String parea) {
                this.parea = parea;
            }

            public String getCarnum() {
                return carnum;
            }

            public void setCarnum(String carnum) {
                this.carnum = carnum;
            }

            public String getPhands() {
                return phands;
            }

            public void setPhands(String phands) {
                this.phands = phands;
            }

            public String getPnumber() {
                return pnumber;
            }

            public void setPnumber(String pnumber) {
                this.pnumber = pnumber;
            }

            public String getPsocre() {
                return psocre;
            }

            public void setPsocre(String psocre) {
                this.psocre = psocre;
            }

            public String getPmoney() {
                return pmoney;
            }

            public void setPmoney(String pmoney) {
                this.pmoney = pmoney;
            }

            public String getPhandle() {
                return phandle;
            }

            public void setPhandle(String phandle) {
                this.phandle = phandle;
            }
        }
    }
}