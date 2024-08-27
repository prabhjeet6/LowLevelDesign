package designexamples.jsonparser;
import designexamples.jsonparser.data.JSON;
import designexamples.jsonparser.exception.JSONParseException;
import designexamples.jsonparser.parser.JSONParser;
import designexamples.jsonparser.tokenizer.NaiveTokenizer;
import designexamples.jsonparser.parser.NaiveJSONParser;

public class JSONParserTester {
    public static void main(String[] args) throws JSONParseException {
        JSONParser parser = new NaiveJSONParser(new NaiveTokenizer());
        String jsonText = "{\"sem-2\":{\"Theory\":{\"Computer Arch\":\"A+\",\"Numerical Methods\":\"A+\"},\"cgpa\":\"9.9\",\"Lab\":{\"Parallel Computing\":\"A+\",\"Computer Arch\":\"A+\"}},\"sem-1\":{\"Theory\":{\"Computer Graphics\":\"B\",\"DSA\":\"A\",\"Discrete Maths\":\"A-\"},\"cgpa\":\"9.7\",\"Lab\":{\"Computer Graphics\":\"B\",\"DSA\":\"A+\",\"Microprocessors\":\"B-\"}}}";
        JSON json = parser.parse(jsonText);
        System.out.println(parser.toString(json
                .get("sem-2").get("Lab").get("Parallel Computing")));


    }
}