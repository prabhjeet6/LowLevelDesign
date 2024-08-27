package designexamples.jsonparser.tokenizer;

import designexamples.jsonparser.data.KeyValuePair;
import designexamples.jsonparser.exception.JSONParseException;

import java.util.List;

public interface Tokenizer {

    List<KeyValuePair> tokenize(String text) throws JSONParseException;
}
