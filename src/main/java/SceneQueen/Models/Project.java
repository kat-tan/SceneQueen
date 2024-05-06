package SceneQueen.Models;

public class Project {
    private String email;
    private String projectName;
    private Stage project;

    public Project(String email, String projectName) {
        this.email = email;
        this.projectName = projectName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

}
