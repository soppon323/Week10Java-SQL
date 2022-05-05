package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.ModelDao;
import entity.Model;

public class Menu {
    
    private ModelDao modelDao = new ModelDao();
    private Scanner scanner = new Scanner(System.in);
    private List<String> options = Arrays.asList(
            "Show all Models",
            "Show a Model",
            "Add a Model",
            "Remove a Model"
            );
    
    public void start() {
        String selection = "";
        
        do {
            printMenu();
            selection = scanner.nextLine();
            
            try {
                if (selection.equals("1")) {
                    displayModels();
            } else if(selection.equals("2")) {
                   displayModel();    
            } else if(selection.equals("3")) {
                  addModel();
            } else if (selection.equals("4")) {
                  removeModel();
            }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        
            System.out.println("Press Enter to continue.....");
            scanner.nextLine();
        }while (!selection.equals("-1"));
                System.out.println("Program aborted!");
        
    }
    private void removeModel() throws SQLException {
        System.out.print("Enter the ID of the make you want to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Press enter to confirm....");
        scanner.nextLine();
        modelDao.deleteMake(id);
        
    }
    private void printMenu() {
        System.out.println("Make a selection: \n--------------------------:");
        for (int i = 0; i < options.size(); i++) {
            System.out.println(i + 1 + ")" + options.get(i));
        }
    }
    
    private void displayModels() throws SQLException {
        List<Model> models = modelDao.getModels();
        for (Model model : models) {
            System.out.println(model.getModelId() + ": " + model.getModel());
        }
        
    }
    
    private void displayModel() throws SQLException {
        System.out.println("Enter model ID:");
        int id = Integer.parseInt(scanner.nextLine());
        Model model = modelDao.getModelById(id);
        System.out.println(model.getModelId()+": " + model.getModel());
         
    }
    private void addModel() throws SQLException {
        System.out.print("Enter the model Id of the model you want to add: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the make you wish to add: ");
        String make  = scanner.nextLine();
        modelDao.addModel(id,make);
        
        
    }
    
}
