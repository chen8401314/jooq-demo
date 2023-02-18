package com.example.demo.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 分页DTO
 *
 * @author 华规软件(上海)有限公司
 * @date 2017/9/15
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode
public abstract class PageReq {

    private PageReq(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }


    /**
     * 显示数目
     */
    @ApiModelProperty(value = "显示数目")
    private Integer size;

    /**
     * 分页页数
     */
    @ApiModelProperty(value = "分页页数")
    private Integer page;




    /**
     * 设置初始查询条数为10条
     */
    public Integer getSize() {
        if (size == null || size <= 0) {
            size = 10;
        }
        return size;
    }

    /**
     * 设置初始查询页码为第一页
     */
    public Integer getPage() {
        if (page == null || page <= 0) {
            page = 1;
        }
        return page;
    }


    @JsonIgnore
    public Integer getStartIndex() {
        if (page == null || size == null) {
            return 0;
        }
        return (page - 1) * size;
    }

    @JsonIgnore
    public Integer getEndIndex() {
        if (page == null || size == null) {
            return 0;
        }
        return page * size;
    }

    @JsonIgnore
    public Integer getEndIndex(Integer total) {
        if (page == null || size == null) {
            return 0;
        }
        return page * size > total ? total : page * size;
    }
}
