package entities;

import java.util.HashMap;

public class ProjectDTO {
    private long projectId;
    private String name;
    private String description;
    private HashMap<String,Object> additionalProperties;

    public ProjectDTO(String name, String description){
        projectId = 0;
        this.name = name;
        this.description = description;
        additionalProperties = new HashMap<>();
    }

    public long getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addProperty(String key, Object value){
        additionalProperties.put(key,value);
    }

    public Object getProperty(String key){
        return additionalProperties.get(key);
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public HashMap<String, Object> getAdditionalProperties(){
        return additionalProperties;
    }

    public String toString(){
        return "Project: [ " + "id = " + projectId + " name = " + name + " description = " + description + " ]";
    }
}
