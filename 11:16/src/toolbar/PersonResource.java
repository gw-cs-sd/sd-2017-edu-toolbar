package toolbar;
import java.util.Set;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@Path("/resources")
public class PersonResource extends Application {

	@POST
	@Path("/code/{result}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
    public String getsum(String data, @PathParam("result") double result) {
		System.out.println(result);
		System.out.println(data);
        String classNameA = "ExampleClass";
        String codeA =data;  
        int name = 0;
try{
        RuntimeCompiler r = new RuntimeCompiler();
        r.addClass(classNameA, codeA);
        r.compile();

        name = (int) MethodInvocationUtils.invokeStaticMethod(
            r.getCompiledClass(classNameA), 
            "sumDouble");
        System.out.println(name);
        System.out.println(System.err);
        if(name == result){
        	return "true";
        }
        else {
        	return "false";
        }
        
}
catch (Throwable e){
	System.out.println(e);
	return "Syntax error";
}
    }

	@Override
	public Set<Class<?>> getClasses() {
		// TODO Auto-generated method stub
		return null;
	}
}
