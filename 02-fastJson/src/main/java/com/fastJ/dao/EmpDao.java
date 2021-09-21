package com.fastJ.dao;

import com.fastJ.vo.Emp;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @BelongsProject: weixin-learn
 * @BelongsPackage: com.fastJ.dao
 * @Author: jkl
 * @CreateTime: 2021
 * @Description:
 */
@Repository
public interface EmpDao {

    @Select("select empno as empNo,ename from emp")
    List<Emp> allEmp();

    @Select("select empno as empNo,ename from emp where empno=#{empno}")
    Optional<Emp> findEmpById(int empno);

    void saveEmp(Emp emp);


}
