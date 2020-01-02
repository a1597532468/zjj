package cn.bd10.zjj.servlet.impl;

import cn.bd10.zjj.dao.PhoneDao;
import cn.bd10.zjj.entity.Informations;
import cn.bd10.zjj.entity.Replies;
import cn.bd10.zjj.servlet.PhoneServlet;
import cn.bd10.zjj.unit.PageDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PhoneServletImpl implements PhoneServlet {
    @Resource
    private PhoneDao pd;

    @Override
    public Integer selectCount() {
        return pd.selectCount();
    }

    @Override
    public PageDto<Informations> list(Integer pageNo, Integer pageSize) {
        Integer total=this.selectCount();
        Integer offset=(pageNo - 1) * pageSize;
        List<Informations> inList=pd.list(offset,pageSize);
        PageDto<Informations> inPageDto=new PageDto<Informations>();
        inPageDto.setTotal((long)total);
        inPageDto.setPageNo(pageNo);
        inPageDto.setPageSize(pageSize);
        inPageDto.setPages(total%pageSize==0?total/pageSize : total/pageSize+1);
        inPageDto.setData(inList);
        return inPageDto;
    }

    @Override
    public Informations look(Integer id) {
        return pd.look(id);
    }

    @Override
    public List<Replies> look1(Integer id) {
        return pd.look1(id);
    }

    @Override
    public int add(String contents, Integer infoid) {
        return pd.add(contents,infoid);
    }

    @Override
    public int xiugai(Integer id) {
        return pd.xiugai(id);
    }


}
