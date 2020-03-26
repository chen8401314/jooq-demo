package com.example.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author hushunjian
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class BasePageDTO {

    @ApiModelProperty(value = "总页数")
    private Integer totalPages;

    @ApiModelProperty(value = "总条数")
    private Long totalElements;

    @ApiModelProperty(value = "当前页")
    private Integer page;

    @ApiModelProperty(value = "页大小")
    private Integer size;

    public Integer getTotalPages() {
        return (int) ((totalElements + size - 1) / size);
    }

    public BasePageDTO(Integer page, Integer size, Long totalElements) {
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
    }
}
