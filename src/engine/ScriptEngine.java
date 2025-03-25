package engine;

import javax.tools.*;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

public class ScriptEngine {
    public static void executeScript(String scriptPath, String className) {
        try {
            // Compile Java script
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            compiler.run(null, null, null, scriptPath);

            // Load and execute script
            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{new File("scripts/").toURI().toURL()});
            Class<?> clazz = Class.forName("scripts." + className, true, classLoader);
            Runnable scriptInstance = (Runnable) clazz.getDeclaredConstructor().newInstance();
            scriptInstance.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
