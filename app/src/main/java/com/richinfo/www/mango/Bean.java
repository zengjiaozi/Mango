package com.richinfo.www.mango;

/**
 * @author
 * @time 2018/4/17  10:37
 * @desc ${TODD}
 */
public class Bean {
    /**
     * status : 1
     * content : {"from":"en-EU","to":"zh-CN","out":"示例","vendor":"ciba","err_no":0}
     */

    private int status;
    private ContentBean content;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * from : en-EU
         * to : zh-CN
         * out : 示例
         * vendor : ciba
         * err_no : 0
         */

        private String from;
        private String to;
        private String out;
        private String vendor;
        private int err_no;

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getOut() {
            return out;
        }

        public void setOut(String out) {
            this.out = out;
        }

        public String getVendor() {
            return vendor;
        }

        public void setVendor(String vendor) {
            this.vendor = vendor;
        }

        public int getErr_no() {
            return err_no;
        }

        public void setErr_no(int err_no) {
            this.err_no = err_no;
        }

        @Override
        public String toString() {
            return "ContentBean{" + "from='" + from + '\'' + ", to='" + to + '\'' + ", out='" + out + '\'' + ", vendor='" + vendor + '\'' + ", err_no=" + err_no + '}';
        }
    }

   /* {"status":1,"content":
        {"from":"en-EU","to":"zh-CN","out":"\u793a\u4f8b",
                "vendor":"ciba","err_no":0}}*/


    @Override
    public String toString() {
        return "Bean{" + "status=" + status + ", content=" + content + '}';
    }
}
