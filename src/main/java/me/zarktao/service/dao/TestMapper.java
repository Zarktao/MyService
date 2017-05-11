package me.zarktao.service.dao;

import me.zarktao.service.models.po.Test;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by yt005 on 2017/5/11.
 */
public interface TestMapper extends Mapper<Test>, MySqlMapper<Test> {
}
