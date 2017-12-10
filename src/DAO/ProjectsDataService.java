package DAO;


import com.google.gson.Gson;
import entities.ProjectDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProjectsDataService implements ProjectsDAO{

    private static DBUtility dbUtility = DBUtility.getInstance();
    private static Logger logger = LogManager.getLogger();

    public ProjectsDataService(){

    }

    @Override
    public void createProject(ProjectDTO project){

        Connection connection = dbUtility.getConnection();

        try{
            String sqlString = "INSERT INTO projects(name, description, properties) VALUES(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sqlString);

            statement.setString(1,project.getName());
            statement.setString(2, project.getDescription());

            Gson gson = new Gson();
            String json = gson.toJson(project.getAdditionalProperties());

            statement.setString(3,json);

            statement.execute();

        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            dbUtility.putConnection(connection);
        }
    }

    @Override
    public List<ProjectDTO> getAllProjects(){
        return null;
    }
}
