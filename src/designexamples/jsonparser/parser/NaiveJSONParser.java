package designexamples.jsonparser.parser;

import designexamples.jsonparser.data.JSON;
import designexamples.jsonparser.data.KeyValuePair;
import designexamples.jsonparser.data.StringConstants;
import designexamples.jsonparser.exception.JSONParseException;
import designexamples.jsonparser.tokenizer.Tokenizer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NaiveJSONParser implements JSONParser {

    private final Tokenizer tokenizer;

    public NaiveJSONParser(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    @Override
    public JSON parse(String jsonString) throws JSONParseException {
        if (jsonString == null) {
            throw new JSONParseException("JSON string is null");
        }
        if (!jsonString.contains(String.valueOf(StringConstants.STARTING_PARANTHESIS))) {
            jsonString = jsonString.trim().replaceAll(String.valueOf(StringConstants.DOUBLE_QUOTES), StringConstants.EMPTY_STRING);
            Map<String, JSON> keyToValues = new HashMap<>();
            keyToValues.put(jsonString, null);
            return new JSON(keyToValues);
        }
        List<KeyValuePair> keyValuePairs = this.tokenizer.tokenize(jsonString);
        Map<String, JSON> keyToValues = new HashMap<>();
        for (KeyValuePair keyValuePair : keyValuePairs) {
            keyToValues.put(keyValuePair.getKey(), parse(keyValuePair.getValue()));
        }

        return new JSON(keyToValues);
    }

    @Override
    public String toString(JSON json) {
        if (json.isLeaf()) {
            return StringConstants.DOUBLE_QUOTES +
                    json.getAllKeys().getFirst().trim() + StringConstants.DOUBLE_QUOTES;
        }
        StringBuilder jsonString = new StringBuilder(String.valueOf(StringConstants.STARTING_PARANTHESIS));
        List<String> keys = json.getAllKeys();
        for (String key : keys) {
            jsonString.append(StringConstants.DOUBLE_QUOTES)
                    .append(key)
                    .append(StringConstants.DOUBLE_QUOTES)
                    .append(StringConstants.COLON)
                    .append(this.toString(json.get(key)))
                    .append(StringConstants.COMMA);
        }
        jsonString.deleteCharAt(jsonString.length() - 1);
        jsonString.append(StringConstants.CLOSING_PARANTHESIS);
        return jsonString.toString();
    }
}
