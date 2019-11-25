package ${packageName}.dao.domain;


import java.util.Date;
import com.ald.ishangjie.dao.domain.base.BaseDo;

/**
 * ${functionName}实体
 * 
 * @author ${classAuthor}
 * @version 1.0.0 初始化
 * @date ${classDate}
 * Copyright 本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
 public class ${ClassName}Do {

    private static final long serialVersionUID = 1L;

    <#list list as item>
    <#if item.columnName == "id">
    /**
     * 主键Id
     */
    private Long id;
    
    <#elseif item.columnName == "isDelete">
     private int isDelete;
    <#else >
    /**
     * ${item.columnComment}
     */
    private ${item.dataType} ${item.columnName};

    </#if >
    </#list>

    <#list list as item>
    <#if item.columnName == "id">

    public Long getId(){
      return id;
    }


    public void setId(Long id){
      this.id = id;
    }

    <#elseif item.columnName == "isDelete">

    public int getIsDelete(){return isDelete;}
    public void setIsDelete(int isDelete){this.isDelete = isDelete;}

    <#else >
    /**
     * 获取${item.columnComment}
     *
     * @return ${item.columnComment}
     */
    public ${item.dataType} get${item.columnNameUpper}(){
      return ${item.columnName};
    }

    /**
     * 设置${item.columnComment}
     *
     * @param ${item.columnName} 要设置的${item.columnComment}
     */
    public void set${item.columnNameUpper}(${item.dataType} ${item.columnName}){
      this.${item.columnName} = ${item.columnName};
    }

    </#if >
    </#list>
}