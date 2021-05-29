package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.Prevention3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("PreventionInsertStrategy")
public class PreventionInsertStrategy implements InsertStrategy {

    final private Prevention3dMapper prevention3dMapper;

    @Autowired
    public PreventionInsertStrategy(Prevention3dMapper prevention3dMapper) {
        this.prevention3dMapper = prevention3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (prevention3dMapper.isExits(entityName) < 1) {
            prevention3dMapper.insertPrevention(entityName);
        }
        return "Prevention";
    }

}
