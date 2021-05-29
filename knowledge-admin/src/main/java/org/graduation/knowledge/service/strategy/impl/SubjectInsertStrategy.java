package org.graduation.knowledge.service.strategy.impl;

import org.graduation.knowledge.mapper.neo4j.Subject3dMapper;
import org.graduation.knowledge.service.strategy.InsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuanxin
 */
@Service("SubjectInsertStrategy")
public class SubjectInsertStrategy implements InsertStrategy {

    final private Subject3dMapper subject3dMapper;

    @Autowired
    public SubjectInsertStrategy(Subject3dMapper subject3dMapper) {
        this.subject3dMapper = subject3dMapper;
    }

    /**
     * 插入单个实体
     *
     * @param entityName 实体名
     * @return 插入的类型
     */
    @Override
    public String insertEntity(String entityName) {
        if (subject3dMapper.isExits(entityName) < 1) {
            subject3dMapper.insertSubject(entityName);
        }
        return "Subject";
    }

}
