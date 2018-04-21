package com.rajivraghu.hibernate.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseAuditVO implements Serializable
{

    /**
     * 
     */
    private static  long serialVersionUID = 9082355462915323306L;
    public Map<String, Object>  auditMap;
    public List<String>         fieldList;
    
    public String action;
    public String actionUser;
    public String userLoginId;
    public String auditSubModule;
    public String auditAction;
    

 
    public static  String  USERID = "userid";

    public Map<String, Object> getAuditmap()
    {
        return this.auditMap;
    }

    public void setAuditmap(Map<String, Object> auditmap)
    {
        this.auditMap = auditmap;
    }

    public Map<String, Object> updateBaseAudit(String userid)
    {
        return this.updateBaseAudit(userid, true);
    }

    public Map<String, Object> updateBaseAudit(String userid, boolean isNullEnabled)
    {
        this.auditMap = new HashMap<String, Object>();
        this.fieldList = new ArrayList<String>();
        
        this.setActionUser(userid);

        try
        {
        
            Field[] f = this.getClass().getDeclaredFields();
           
            Field[] g = {};
            if (!BaseAuditVO.class.getName().equalsIgnoreCase(this.getClass().getSuperclass().getName()))
            {
                g = this.getClass().getSuperclass().getDeclaredFields();
            }

            Field[] h = new Field[(f.length + g.length + 1)];

            for (int j = 0; j < g.length; j++)
            {
                h[j] = g[j];
            }

            for (int k = g.length; k < (g.length + f.length); k++)
            {
                h[k] = f[k - g.length];
            }

            this.assembleAuditMap(isNullEnabled, g);

            this.assembleAuditMap(isNullEnabled, f);
        }
        catch (Exception e)
        {
       
        }

//        this.auditMap.put(BaseAuditVO.USERID, userid);

        this.setAuditmap(this.auditMap);

        return this.auditMap;
    }

    /**
     * @param isNullEnabled
     * @param fields
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private void assembleAuditMap(boolean isNullEnabled, Field[] fields) throws IllegalAccessException,
            InvocationTargetException
    {
        for (int i = 0; i < fields.length; i++)
        {
            try
            {
                String name = fields[i].getName();
                fieldList.add(name);
                // String type = (g[i].getType()).getName();

                String method = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
                Method m = this.getClass().getMethod(method, null);
                Object o = m.invoke(this, null);

                if (o != null)
                {
                    this.auditMap.put(name, o);
                }
                else
                {
                    if (isNullEnabled)
                    {
                        this.auditMap.put(name, "null");
                    }
                }
            }
            catch (NoSuchMethodException e)
            {
              
            }
            catch (ClassCastException e)
            {
              
            }
            catch (NullPointerException e)
            {
            
            }
        }
    }

    public String getAction()
    {
        return action;
    }

    public void setAction(String action)
    {
        this.action = action;
    }

    public String getActionUser()
    {
        return actionUser;
    }

    public void setActionUser(String actionUser)
    {
        this.actionUser = actionUser;
    }

	public String getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getAuditSubModule() {
		return auditSubModule;
	}

	public void setAuditSubModule(String auditSubModule) {
		this.auditSubModule = auditSubModule;
	}

	public String getAuditAction() {
		return auditAction;
	}

	public void setAuditAction(String auditAction) {
		this.auditAction = auditAction;
	}
    
    
    
    
}
