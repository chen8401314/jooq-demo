package com.example.demo.repository;

import com.example.demo.dto.Page;
import com.example.demo.request.PageReq;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.jooq.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BaseRep {

    @Autowired
    private DSLContext dslContext;

    /**
     * @param clazz       返回实体对象class
     * @param table       查询表
     * @param fields      返回字段数组
     * @param condition   查询条件
     * @param orderFields 排序字段数组
     * @param pageReq     分页组件
     * @param <T>
     * @return
     */
    public <T> Page<T> page(Class<T> clazz, Table<?> table, Field<?>[] fields, Condition condition, List<OrderField<?>> orderFields, PageReq pageReq) {
        // 页条数
        Long total = dslContext.selectCount().from(table).where(condition).fetchOne().into(Long.class);
        Page<T> page = new Page<>(Lists.newArrayList(), pageReq, total);
        if (total == 0) {
            return page;
        }
        List<T> datas = dslContext.select(fields).from(table).where(condition).orderBy(CollectionUtils.isEmpty(orderFields) ? Lists.newArrayList() : orderFields).limit(pageReq.getSize()).offset((page.getPage() - 1) *  page.getSize()).fetchInto(clazz);
        page.setContent(datas);
        return page;
    }

}
