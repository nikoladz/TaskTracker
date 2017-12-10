import entities.ProjectDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TaskTrackerMain {

    private static Logger logger = LogManager.getLogger();
    private static TaskTrackerContext taskTrackerContext;

    public static void main(String[] args){

        logger.info("TaskTracker started.");

        taskTrackerContext = TaskTrackerContext.getInstance();

        taskTrackerContext.getProjectsDAO().createProject(new ProjectDTO("invokerTEst","asd"));

    }
}
