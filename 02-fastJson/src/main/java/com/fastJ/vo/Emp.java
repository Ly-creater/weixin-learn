package com.fastJ.vo;

import lombok.Data;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.fastJ.vo
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
@Data
public class Emp {
    private String empNo;
    private String ename;
    private String sal;
    private String mgr;

    //@JSONCreator
    //public Emp(String empNo) {
    //    this.empNo = empNo;
    //}

    public Emp(String empNo, String ename) {
        this.empNo = empNo;
        this.ename = ename;
    }
}
