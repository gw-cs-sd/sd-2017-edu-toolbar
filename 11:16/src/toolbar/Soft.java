package toolbar;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class Soft extends Application{
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
       classes.add(PersonResource.class);
        return classes;
    }
}