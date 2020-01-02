package cn.bd10.zjj.servlet;

import cn.bd10.zjj.entity.Informations;
import cn.bd10.zjj.entity.Replies;
import cn.bd10.zjj.unit.PageDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PhoneServlet {
    public Integer selectCount();
    public PageDto<Informations> list(Integer pageNo, Integer pageSize );
    public Informations look(@Param("id")Integer id);
    public List<Replies> look1(@Param("id") Integer id);
    public int add(String contents,Integer infoid);
    public int xiugai(Integer id);
}
