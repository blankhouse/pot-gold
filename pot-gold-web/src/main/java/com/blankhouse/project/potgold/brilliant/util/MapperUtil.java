package com.blankhouse.project.potgold.brilliant.util;

import com.blankhouse.project.potgold.common.helper.ApplicationContextHelper;
import com.blankhouse.project.potgold.mapper.TGoldTaskMapper;
import com.blankhouse.project.potgold.model.TGoldTask;
import com.blankhouse.project.potgold.model.TGoldTaskExample;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author hujia
 * @date 16/10/2019
 * @since 1.0.0
 */
public class MapperUtil {
    public static TGoldTaskMapper getGoldTask() {

        return (TGoldTaskMapper) ApplicationContextHelper.getBean(TGoldTaskMapper.class.getSimpleName());
    }

    public static void updateById(TGoldTask tGoldTask) {
        System.out.println("updateById----" + tGoldTask);
        TGoldTaskExample tGoldTaskExample = new TGoldTaskExample();
        tGoldTaskExample.createCriteria().andIdEqualTo(tGoldTask.getId());
        MapperUtil.getGoldTask().updateByExampleSelective(tGoldTask, tGoldTaskExample);
    }

    public static TGoldTask findById(Long id) {
        TGoldTaskExample tGoldTaskExample = new TGoldTaskExample();
        tGoldTaskExample.createCriteria().andIdEqualTo(id);
        List<TGoldTask> tGoldTasks = MapperUtil.getGoldTask().selectByExample(tGoldTaskExample);
        if (CollectionUtils.isEmpty(tGoldTasks)) {
            return null;
        }
        return tGoldTasks.get(0);
    }
}
