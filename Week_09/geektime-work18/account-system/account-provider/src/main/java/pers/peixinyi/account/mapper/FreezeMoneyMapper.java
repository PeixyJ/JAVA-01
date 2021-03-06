package pers.peixinyi.account.mapper;

import org.apache.ibatis.annotations.Param;
import pers.peixinyi.account.FreezeMoney;

public interface FreezeMoneyMapper {

    Boolean addFreezeMoney(FreezeMoney record);

    FreezeMoney getFreezeMoney(@Param("userID") int userID, @Param("orderID") int orderID);

    FreezeMoney getFreezeMoneyStatus(@Param("userID") int userID, @Param("orderID") int orderID,@Param("status")int status);

    Boolean updateFreezeMoneyStatus(@Param("userID") int userID, @Param("orderID") int orderID, @Param("status") int status);

}