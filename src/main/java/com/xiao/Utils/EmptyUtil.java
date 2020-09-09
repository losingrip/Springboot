package com.xiao.Utils;

import java.math.BigDecimal;
import java.util.Collection;

public class EmptyUtil {

    public static void isEmpty(String str, String strName) {
        if (str == null) {
            throw new IllegalArgumentException(strName + "不能为空！");
        } else if (str.equals(""))
            throw new IllegalArgumentException(strName + "不能为空字符串！");
    }

    public static void ThrowArgException(String argName, String message) {
        throw new IllegalArgumentException(String.format("%s参数错误：%s.", argName, message));
    }

    public static void ThrowArgNullException(String arg, String argName, boolean isCheckEmpty) {
        if (arg == null) {
            throw new IllegalArgumentException(String.format("%s不能为Null.", argName));
        } else if (isCheckEmpty && arg.equals("")) {
            throw new IllegalArgumentException(String.format("%s不能为String.Empty.", argName));
        }
    }

    public static void ThrowArgNullException(Object arg, String argName) {
        if (arg == null) {
            throw new IllegalArgumentException(String.format("%s不能为Null.", argName));
        }
    }

    public static void ThrowArgNullException(Collection arg, String argName, boolean isCheckCount) {
        if (arg == null) {
            throw new IllegalArgumentException(String.format("%s不能为Null.", argName));
        } else if (isCheckCount && arg.size() == 0) {
            throw new IllegalArgumentException(String.format("%s的元素个数不能为0.", argName));
        }
    }

    public static void ThrowArgNullException(long[] arg, String argName, boolean isCheckCount) {
        if (arg == null) {
            throw new IllegalArgumentException(String.format("%s不能为Null.", argName));
        } else if (isCheckCount && arg.length == 0) {
            throw new IllegalArgumentException(String.format("%s的元素个数不能为0.", argName));
        }
    }

    public static void ThrowArgNullException(byte[] arg, String argName, boolean isCheckCount) {
        if (arg == null) {
            throw new IllegalArgumentException(String.format("%s不能为Null.", argName));
        } else if (isCheckCount && arg.length == 0) {
            throw new IllegalArgumentException(String.format("%s的元素个数不能为0.", argName));
        }
    }

    public static void ThrowArgNullException(double[] arg, String argName, boolean isCheckCount) {
        if (arg == null) {
            throw new IllegalArgumentException(String.format("%s不能为Null.", argName));
        } else if (isCheckCount && arg.length == 0) {
            throw new IllegalArgumentException(String.format("%s的元素个数不能为0.", argName));
        }
    }

    public static void ThrowArgZeroException(BigDecimal arg, String argName) {
        if (arg == null) {
            throw new IllegalArgumentException(String.format("%s不能为null.", argName));
        } else if (arg.doubleValue() == 0.0D) {
            throw new IllegalArgumentException(String.format("%s不能为0.", argName));
        }
    }

    public static void ThrowArgZeroException(long arg, String argName) {
        if (arg == 0L) {
            throw new IllegalArgumentException(String.format("%s不能为0.", argName));
        }
    }

    public static void ThrowArgZeroException(double arg, String argName) {
        if (arg == 0.0D) {
            throw new IllegalArgumentException(String.format("%s不能为0.", argName));
        }
    }

    public static void ThrowArgOutRangeException(long arg, String argName, long... values) {
        ThrowArgNullException(values, "values", true);
        long[] var4 = values;
        int var5 = values.length;

        for (int var6 = 0; var6 < var5; ++var6) {
            long value = var4[var6];
            if (value == arg) {
                return;
            }
        }

        throw new IllegalArgumentException(String.format("%s的值不在取值范围内.", argName));
    }

    public static void ThrowArgOutRangeException(int arg, String argName, double... values) {
        ThrowArgNullException(values, "values", true);
        double[] var3 = values;
        int var4 = values.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            double value = var3[var5];
            if (value == (double) arg) {
                return;
            }
        }

        throw new IllegalArgumentException(String.format("%s的值不在取值范围内.", argName));
    }

    public static void ThrowArgOutRangeException(long arg, String argName, long min, long max) {
        if (arg < min || arg > max) {
            throw new IllegalArgumentException(String.format("%s超出取值范围[%d,%d].", argName, min, max));
        }
    }

    public static void ThrowArgOutRangeException(double arg, String argName, double min, double max) {
        if (arg < min || arg > max) {
            throw new IllegalArgumentException(String.format("%s超出取值范围[%f,%f].", argName, min, max));
        }
    }

    public static void ThrowArgOutRangeException(BigDecimal arg, String argName, BigDecimal min, BigDecimal max) {
        ThrowArgNullException(arg, "arg");
        ThrowArgNullException(min, "min");
        ThrowArgNullException(max, "max");
        if (arg.doubleValue() < min.doubleValue() || arg.doubleValue() > max.doubleValue()) {
            throw new IllegalArgumentException(String.format("%s超出取值范围[%f,%f].", argName, min, max));
        }
    }

}
