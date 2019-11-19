package slides;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TextBlockExample {

	@SuppressWarnings("preview")
	public static void main(String[] args) throws ScriptException {

		String xmlString = """
                <customer>
                     <no>%s</no>
                     <name>%s</name>
                </customer>
                """.formatted("12345", "Franz Kunde");

		System.out.println(xmlString);
		
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
		Object result = engine.eval("""
		                            function add(int1, int2) {
		                            return int1 + int2;
		                            }
		                            add(1, 2);""");
		System.out.println(result);
	}
}
