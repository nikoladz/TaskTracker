package DAO;

import entities.ProjectDTO;

import java.util.List;

public interface ProjectsDAO {
    /**
     * Creates a project
     * @param project project
     */
    void createProject(ProjectDTO project);

    /**
     * Gets all projects in the system
     * @return all projects
     */
    List<ProjectDTO> getAllProjects();

}
