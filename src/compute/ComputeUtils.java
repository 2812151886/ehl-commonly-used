package compute;


import java.text.DecimalFormat;

/**
 * 计算工具类
 *
 * @author lubinghu
 * @date 2021/4/7
 */
public class ComputeUtils {
    private static DecimalFormat decimalFormat = new DecimalFormat("#.##");

    /**
     * 计算环比
     * 以1为基数
     *
     * @param today     今日
     * @param yesterday 昨日数据
     * @return d
     */
    public static double computeChain(Object today, Object yesterday) {
        double todayCount = Double.valueOf(String.valueOf(today));
        double yesterdayCount = Double.valueOf(String.valueOf(yesterday));
        double diff = todayCount - yesterdayCount;
        Double result = 0d;
        if (diff == 0) {
            result = 0d;
        } else if (yesterdayCount == 0) {
            result = 1d;
        } else {
            result = Double.valueOf(decimalFormat.format(Double.valueOf(diff / yesterdayCount)));
        }
        return result;
    }

    /**
     * 多值比对
     *
     * @param today     今日数据
     * @param yesterday 昨日数据
     * @param lastYear  上一年数据
     * @return
     */
    public static Result computeMonthChainAndYearChain(Object today, Object yesterday, Object lastYear) {
        Result result = new Result();
        double a = computeChain(today, yesterday);
        double b = computeChain(today, lastYear);
        result.setMonthChain(decimalFormat.format(a * 100) + "%");
        result.setYearChain(decimalFormat.format(b * 100) + "%");
        result.setMonthChainD(a);
        result.setYearChainD(b);
        return result;
    }


    public static class Result {
        /**
         * 以1为基数   0.1
         */
        private double monthChainD;
        private double yearChainD;
        /**
         * 以100为基数 最终结果为百分比  10%
         */
        private String monthChain;
        private String yearChain;

        public double getMonthChainD() {
            return monthChainD;
        }

        public void setMonthChainD(double monthChainD) {
            this.monthChainD = monthChainD;
        }

        public double getYearChainD() {
            return yearChainD;
        }

        public void setYearChainD(double yearChainD) {
            this.yearChainD = yearChainD;
        }

        public String getMonthChain() {
            return monthChain;
        }

        public void setMonthChain(String monthChain) {
            this.monthChain = monthChain;
        }

        public String getYearChain() {
            return yearChain;
        }

        public void setYearChain(String yearChain) {
            this.yearChain = yearChain;
        }
    }


}

