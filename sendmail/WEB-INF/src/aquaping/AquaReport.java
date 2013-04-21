package aquaping;

import org.json.simple.*;
import org.json.simple.parser.*;

public class AquaReport {

    private String photo;
    private String name;
    private String reporter;
    private String desc;
    private String json;
    
    public AquaReport() {
	photo = null;
	name = null;
	reporter = null;
	desc = null;
	json = null;
    }

    public void parseValues(String json) {
	photo = JSONValue.parse("photo").toString();
	reporter = JSONValue.parse("created_by").toString();
	name = JSONValue.parse("name").toString();
	desc = JSONValue.parse("desc").toString();
    }

    public String printReport() {
	return ("Name of the location: " + name + "\nReporter: " + reporter + "\nAdditional description: " + desc);

    }

    public String getJson() {
	return json;
    }

    public static void main(String[] args) {
	String temp = " \"{\"code\": \"18494\", \"uid\": \"000c8775d93244859dc362db3419678e\", \"photo\": null, \"created_by\": \"john\", \"name\": \"Bandani, H20i: BAN3\", \"source_type\": 2, \"longitude\": 34.74372, \"latitude\": -0.07828,\"desc\": \"H20i Source Type: Public Tap, Bandani Ward, Kisumu, Kenya\"}";
	AquaReport aq = new AquaReport();
	aq.parseValues(temp);
	System.out.println(aq.printReport());
	
    }

}
