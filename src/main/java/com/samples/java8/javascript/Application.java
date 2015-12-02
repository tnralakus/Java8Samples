package com.samples.java8.javascript;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by Alakus on 12/2/2015.
 */
public class Application {
    public static void main(String[] args) {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine nashorn = engineManager.getEngineByName("nashorn"); // five times faster than rhino
        ScriptEngine rhino = engineManager.getEngineByName("rhino"); // java 7
        ScriptEngine jruby = engineManager.getEngineByName("jruby");
        ScriptEngine jython = engineManager.getEngineByName("jython");

        try {
            nashorn.eval("function sum(a,b){ return a + b; }");
            String result = nashorn.eval("sum(3,5);").toString();
            System.out.println(result);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
