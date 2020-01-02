package cn.bd10.zjj.controller;

import cn.bd10.zjj.entity.Informations;
import cn.bd10.zjj.entity.Replies;
import cn.bd10.zjj.servlet.PhoneServlet;
import cn.bd10.zjj.unit.PageDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class Controller1 {
    @Resource
    private PhoneServlet ps;
    @RequestMapping("/hello")
    public String show(@RequestParam(name="pageNo",required = false,defaultValue = "1")Integer pageNo,
                       @RequestParam(name="pageSize",required = false,defaultValue = "3") Integer pageSize, Model model){
        PageDto<Informations> inPageDto=ps.list(pageNo,pageSize);
        if(pageNo>1){
            inPageDto.setHasPreviousPage(true);
        }else{
            inPageDto.setHasPreviousPage(false);
        }
        Integer pagess=inPageDto.getPages();
        Long count=inPageDto.getTotal();
        if(pageNo>=pagess){
            inPageDto.setHasNextPage(false);
        }else{
            inPageDto.setHasNextPage(true);
        }
        model.addAttribute("maxCount",pagess);
        model.addAttribute("count",count);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("inPageDto",inPageDto);
        return "main";
    }
    @RequestMapping("/xiangqing")
    public String look(Integer id,Model model){
        Informations look=ps.look(id);
        List<Replies> look1=ps.look1(id);
        model.addAttribute("look",look);
        model.addAttribute("look1",look1);
        return "show";
    }
    @RequestMapping("/add")
    public void add1(String contents,Integer infoid, HttpServletResponse response) throws IOException {
        String result="false";
        if(ps.add(contents, infoid)>0){
            result="true";
        }
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print(result);
    }
    @RequestMapping("/xiugai")
    public String xiugai(Integer id){
        if(ps.xiugai(id)>0){
            return "redirect:/hello";
        }
        return "redirect:/hello";
    }
}
