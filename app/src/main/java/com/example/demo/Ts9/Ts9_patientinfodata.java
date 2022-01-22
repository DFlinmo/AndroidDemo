package com.example.demo.Ts9;

import java.util.List;

public class Ts9_patientinfodata {

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
            private String bname;
            private String bid;
            private String bsex;
            private String btel;
            private String bbirthday;
            private String baddress;

            public String getBname() {
                return bname;
            }

            public void setBname(String bname) {
                this.bname = bname;
            }

            public String getBid() {
                return bid;
            }

            public void setBid(String bid) {
                this.bid = bid;
            }

            public String getBsex() {
                return bsex;
            }

            public void setBsex(String bsex) {
                this.bsex = bsex;
            }

            public String getBtel() {
                return btel;
            }

            public void setBtel(String btel) {
                this.btel = btel;
            }

            public String getBbirthday() {
                return bbirthday;
            }

            public void setBbirthday(String bbirthday) {
                this.bbirthday = bbirthday;
            }

            public String getBaddress() {
                return baddress;
            }

            public void setBaddress(String baddress) {
                this.baddress = baddress;
            }
        }
    }
}
