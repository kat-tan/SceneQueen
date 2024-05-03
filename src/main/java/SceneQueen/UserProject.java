package SceneQueen;

import java.util.List;

public class UserProject {
    private String email;
    private String projectName;
    private List<Element> elementList;

    public UserProject(String email, String projectName, List<Element> elementList) {
        this.email = email;
        this.projectName = projectName;
        this.elementList = elementList;
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

    public List<Element> getElementList() {
        return elementList;
    }

    public void setElementList(List<Element> elementList) {
        this.elementList = elementList;
    }
}
