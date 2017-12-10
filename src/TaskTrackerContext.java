import DAO.DataAccessInvocationHandler;
import DAO.ProjectsDAO;
import DAO.ProjectsDataService;

import java.lang.reflect.Proxy;

public class TaskTrackerContext {

    private static TaskTrackerContext instance = null;

    private ProjectsDAO projectsDAO;

    private TaskTrackerContext(){
        projectsDAO = (ProjectsDAO) Proxy.newProxyInstance(DataAccessInvocationHandler.class.getClassLoader(),new
            Class[]{ProjectsDAO.class}, new DataAccessInvocationHandler(ProjectsDataService.class.getName()));
    }

    public static TaskTrackerContext getInstance() {
        if(instance == null){
            instance = new TaskTrackerContext();
        }
        return instance;
    }


    public ProjectsDAO getProjectsDAO() {
        return projectsDAO;
    }
}
