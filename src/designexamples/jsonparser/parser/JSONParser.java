package designexamples.jsonparser.parser;

import designexamples.jsonparser.data.JSON;
import designexamples.jsonparser.exception.JSONParseException;

public interface JSONParser {
     JSON parse(String jsonString) throws JSONParseException;
     String toString(JSON json);

}
