package datomic;

import org.codehaus.commons.compiler.CompileException;
import org.codehaus.commons.compiler.jdk.ScriptEvaluator;

public class JaninoRepro3 {
    public static void main(String[] args) throws CompileException {
        System.out.println("Class location:");
        System.out.println(ClassLoader.getSystemClassLoader().getResource("junit/framework/TestCase.class"));

        System.out.println("Classpath:");
        System.out.println(System.getProperty("java.class.path"));

        System.out.println("Run trivial script:");
        ScriptEvaluator ev = new ScriptEvaluator();
        ev.setDefaultImports(new String[]{"junit.framework.TestCase"});
        Runnable r = (Runnable) ev.createFastEvaluator("System.out.println(123);", Runnable.class, new String[]{});
        r.run();
    }
}
