package com.example.demo.dto;

import com.example.demo.request.PageReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页DTO
 *
 * @author 华规软件(上海)有限公司
 * @date 2017/9/15
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Page<T> {

    /**
     * 显示数目
     */
    @ApiModelProperty(value = "显示数目")
    private Integer size;

    /**
     * 分页页数
     */
    @ApiModelProperty(value = "当前分页")
    private Integer page;

    @ApiModelProperty(value = "总页数")
    private Integer totalPages;

    @ApiModelProperty(value = "总条数")
    private Long total;

    /**
     * 数据
     */
    @ApiModelProperty(value = "数据")
    private List<T> content;

    public Page(List<T> content, PageReq pageReq, Long total) {
        this.content = content;
        this.total = total;
        this.page = pageReq.getPage();
        this.size = pageReq.getSize();
    }
    public int getTotalPages()
    {
        return getSize() == 0 ? 0 : (int) Math.ceil((double) total / (double) getSize());
    }

    public int getPage() {
        if (page > getTotalPages()) {
            page = getTotalPages();
        }
        return this.page;
    }
}
