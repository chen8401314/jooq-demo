package com.example.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: ListEventDTO
 * @Description: 事件管理列表显示DTO
 * @author cx
 * @date 2018年6月1日
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PageTestDTO extends BasePageDTO implements Serializable {

	private static final long serialVersionUID = 2587564591786432270L;

	@ApiModelProperty(value = "Test实体列表")
	private List<TestDTO> list;

	public PageTestDTO(Integer page, Integer size, Long totalElements, List<TestDTO> list) {
		super(page, size, totalElements);
		this.list = list;
	}
}
