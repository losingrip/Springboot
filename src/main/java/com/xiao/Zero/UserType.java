package com.xiao.Zero;

import lombok.SneakyThrows;

public enum UserType {
    一般会员(0),
    超级会员(1),
    一般用户(2);

    private int value;
    UserType(int num){this.value=num;}
    public int getValue() {
        return value;
    }

    public static int[] getValues() {
        int[] result = new int[UserType.values().length];
        int i = 0;
        for (UserType item : UserType.values()) {
            result[i] = item.getValue();
            i++;
        }
        return result;
    }

    @SneakyThrows
    public static UserType valueOf(int value) {
        for (UserType item : UserType.values()) {
            if (item.getValue() == value)
                return item;
        }
        throw new Exception("值超出范围.");
    }
}
