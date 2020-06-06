package com.message.comsumer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lls.entity.db.MsgPerson;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author liuzheng
 * @since 15:23 2020/6/6
 */
@Mapper
@Component
public interface MsgPersonMapper extends BaseMapper<MsgPerson> {
}
