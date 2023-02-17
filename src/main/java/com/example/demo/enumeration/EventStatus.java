package com.example.demo.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EventStatus {
    /**
     * 事件未发布
     */
    EVENT_UNPUBLISHED("事件未发布"),
    /**
     * 关闭事件
     */
    EVENT_CLOSED("关闭事件 "),
    /**
     * 办理中
     */
    EVENT_HANDLING("办理中"),
    /**
     * 事件结束
     */
    EVENT_END("事件结束");

    private String desc;

    @Override
    public String toString() {
        return this.name() + "-" + desc;
    }

}
