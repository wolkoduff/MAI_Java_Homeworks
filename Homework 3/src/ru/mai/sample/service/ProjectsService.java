package ru.mai.sample.service;

import java.util.ArrayList;
import java.util.List;

import ru.mai.sample.entity.Projects;
import ru.mai.sample.Function.Functions;
import ru.mai.sample.Function.ProjectDBFunctions;

public class ProjectsService {

    private Functions<Projects> funcProj = new ProjectDBFunctions();

    public List<Projects> getAllProjects(){
        List<Projects> projects = new ArrayList<>();
        funcProj.findAll().forEach(projects::add);
        return projects;
    }

    public Projects getProject(int id) { return funcProj.findByIdNumber(id);}

    public void save(Projects projects) { funcProj.save(projects);}

    public void delete(Projects projects) { funcProj.delete(projects);}
}
