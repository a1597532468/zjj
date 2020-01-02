package cn.bd10.zjj.dao;

import cn.bd10.zjj.entity.Informations;
import cn.bd10.zjj.entity.Replies;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PhoneDao {
    public Integer selectCount();
    public List<Informations> list(@Param("pageNo") Integer pageNo, @Param("pageSize")Integer pageSize );
  public Informations look(@Param("id")Integer id);
  public List<Replies> look1(@Param("id") Integer id);
public int add(@Param("contents")String contents,@Param("infoid")Integer infoid);
public int xiugai(@Param("id")Integer id);
}
