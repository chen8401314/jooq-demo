package com.example.demo.mapstrut;

import com.example.demo.dto.TestDTO;
import com.example.demo.jooq.tables.pojos.TestEntity;
import com.example.demo.request.TestReq;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TestMapper {

	TestMapper TEST_MAPPER = Mappers.getMapper(TestMapper.class);

	TestDTO toTestDTO(TestEntity bean);

	TestEntity toTestEntity(TestReq bean);

	void copyTestEntity(TestReq req,@MappingTarget TestEntity testEntity);
}
