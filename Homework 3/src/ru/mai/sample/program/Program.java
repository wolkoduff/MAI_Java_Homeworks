package ru.mai.sample.program;

/**
 *
 * @author Довгерд Игнат
 * @version 1.0
 *
 */

import ru.mai.sample.entity.Projects;
import ru.mai.sample.service.ProjectsService;

import java.util.Scanner;

class Program {
    public static void main(String[] args) {
        System.out.println("Домашняя работа №3.");
        System.out.println("Test database:");

        ProjectsService service = new ProjectsService();

        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер проекта: ");
        int id = in.nextInt();

        Projects proj = service.getProject(id);

        if (proj != null){
            System.out.println(proj);
        }
    }
}
