package com.trip.enumeration;

/**
 * @author fjj
 * @date 2019/1/2 下午11:46
 */
public enum UserState {
    /**
     * 未审核
     */
    UNCHECKED,
    /**
     * 审核中
     */
    CHECKING,
    /**
     * 不通过
     */
    UNAPPROVED,
    /**
     * 已审核
     */
    CHECKED,
    /**
     * 封号
     */
    CLOSED
}
