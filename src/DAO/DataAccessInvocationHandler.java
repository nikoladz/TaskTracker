package DAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DataAccessInvocationHandler implements InvocationHandler {

    private static DBUtility dbUtility = DBUtility.getInstance();
    private static Logger logger = LogManager.getLogger();


    private Object originalObject;

    public DataAccessInvocationHandler(String className){
        try {
            originalObject = Class.forName(className).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        StringBuilder argsString = new StringBuilder();
        for(Object arg : args){
            argsString.append(arg.toString());
        }

        logger.trace("Calling: " + method.getName() + " Args: " + argsString.toString());


        Object result = method.invoke(originalObject, args);

        logger.trace("Called: " + method.getName() + " Args: " + argsString.toString());

        return result;
    }
}
