package tutorial.code;

public class JavaCodeRunner {
    public String runCode(String program) {

        String classNameA = "MainClass";

        RuntimeCompiler r = new RuntimeCompiler();
        r.addClass(classNameA, program);
        r.compile();

        return (String) MethodInvocationUtils.invokeStaticMethod(r.getCompiledClass(classNameA), "main");
    }
}
