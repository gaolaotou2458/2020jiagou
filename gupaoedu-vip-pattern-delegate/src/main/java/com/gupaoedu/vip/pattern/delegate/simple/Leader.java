package com.gupaoedu.vip.pattern.delegate.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tom.
 */
public class Leader implements IEmployee {

    //预先知道每个员工的特长、特征、分发任务
    private Map<String,IEmployee> targets = new HashMap<String,IEmployee>();


    public Leader() {
        targets.put("加密",new EmployeeA());
        targets.put("登录",new EmployeeB());
    }

    //项目经理自己不干活
    public void doing(String command){
        targets.get(command).doing(command);
    }

}
