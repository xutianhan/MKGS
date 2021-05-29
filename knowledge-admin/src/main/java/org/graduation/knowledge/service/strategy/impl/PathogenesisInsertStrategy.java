package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.Pathogenesis3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("PathogenesisInsertStrategy")
public class PathogenesisInsertStrategy implements InsertStrategy {

    final private Pathogenesis3dMapper pathogenesis3dMapper;

    @Autowired
    public PathogenesisInsertStrategy(Pathogenesis3dMapper pathogenesis3dMapper) {
        this.pathogenesis3dMapper = pathogenesis3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (pathogenesis3dMapper.isExits(entityName) < 1) {
            pathogenesis3dMapper.insertPathogenesis(entityName);
        }
        return "Pathogenesis";
    }

}
