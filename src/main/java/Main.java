import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        LogCreator logCreator = new LogCreator();
        logCreator.createLog();

        DataContainer dataContainer = new DataContainer();
        Reflection rt = new Reflection();
        rt.Reflect(5,6, dataContainer);
    }
}
