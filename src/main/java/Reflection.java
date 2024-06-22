import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Reflection{
    String str = "";
    LogCreator logCreator = new LogCreator();

    public List<Class> init(List<Class> cl){
        cl.add(Child1.class);
        cl.add(Child2.class);
        return cl;
    }

    public List<Class> Search(List<Class> cl, int days) {
        cl = cl.stream().filter(x -> ((Task1)x.getAnnotation(Task1.class)).days() == days).collect(Collectors.toList());
        return cl;
    }

    public String Create(List<Class> cl, int hour, DataContainer dataContainer) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        for(Class c :cl){
            List<Method> method = List.of(c.getDeclaredMethods());
            Object s = c.newInstance();
            method = method.stream().filter(x -> ((Task2)x.getAnnotation(Task2.class)).hour()==hour).collect(Collectors.toList());
            method = method.stream().sorted(Comparator.comparingInt(x -> ((Task2)x.getAnnotation(Task2.class)).priority())).toList();
            for(Method m: method){
                m.invoke(s, dataContainer);
                System.out.println(dataContainer.toString());
                str = str + dataContainer.toString() + '\n';
            }
        }
        return str;
    }

    public void Reflect(int days, int hour, DataContainer dataContainer) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        List<Class> ch = new ArrayList<>();
        init(ch);
        ch = Search(ch, days);
        Create(ch, hour, dataContainer);
        logCreator.writeFile(str);
    }
}