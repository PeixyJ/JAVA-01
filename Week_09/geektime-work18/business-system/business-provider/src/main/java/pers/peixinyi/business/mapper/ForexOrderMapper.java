package pers.peixinyi.business.mapper;


import pers.peixinyi.business.ForexOrder;

import java.util.List;

public interface ForexOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ForexOrder record);

    Boolean insertSelective(ForexOrder record);

    ForexOrder selectByPrimaryKey(Integer id);

    List<ForexOrder> selectOrder();

    int updateByPrimaryKeySelective(ForexOrder record);

    Boolean updateByPrimaryKey(ForexOrder record);
}