package com.ssm.factcheck_ssm.web;

import com.ssm.factcheck_ssm.entity.Fact;
import com.ssm.factcheck_ssm.service.FactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FactController {

    @Autowired
    private FactService factService;

//    ����url
    @RequestMapping(value = "/facts")
    public ModelAndView getList(){
//        ҳ�������
        ModelAndView mv = new ModelAndView("list");
//        ��ȡ����
        List<Fact> list = factService.listAll();
        mv.addObject("fact",list);
        return mv;
    }

}