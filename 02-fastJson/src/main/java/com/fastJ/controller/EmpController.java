package com.fastJ.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fastJ.service.EmpServices;
import com.fastJ.service.User;
import com.fastJ.vo.Emp;
import com.fastJ.vo.Sut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.fastJ.controller
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
@RestController
@RequestMapping(value = "/emp")
public class EmpController {

    private static int num=1;
    @Autowired
    private EmpServices empServices;

    @Autowired
    private Sut sut;

    @Autowired
    private User user;

    @GetMapping(value = "/{id}")
    public Emp findEmpById(@PathVariable int id){
        return empServices.findEmpById(id);
    }

    @GetMapping(value = "/all")
    public String allEmp(){
        return JSON.toJSONString(empServices.allEmp(), SerializerFeature.PrettyFormat);
    }

    @PostMapping(value = "/save")
    public void saveEmp(@RequestBody Emp emp){
        System.out.println(122211);
       empServices.saveEmp(emp);
        System.out.println(111);
    }


    @GetMapping(value = "/async")
    public void saveEmp(){
        System.out.println("start!!"+num++);
        empServices.testAsync();
        System.out.println("sccuess");
    }

    @PostConstruct
    public void initMethod(){
        System.out.println(sut.toString());
    }
}
