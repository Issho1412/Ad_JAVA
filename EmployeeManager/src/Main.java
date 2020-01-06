import controller.EmployeeController;
import controller.EmployeeControllerImpl;
import model.EmployeeModel;
import model.EmployeeModelImpl;

public class Main {
    public static void main(String[] args) {
        EmployeeModel model = new EmployeeModelImpl();
        EmployeeController controller = new EmployeeControllerImpl(model);
    }
}
