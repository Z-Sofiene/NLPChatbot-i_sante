package tn.essat.nlpchatbot.service;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreEntityMention;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Service
public class NLPService {

    private final StanfordCoreNLP pipeline;

    public NLPService() {
        // Create a CoreNLP pipeline with NER and other features
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner");
        this.pipeline = new StanfordCoreNLP(props);
    }

    public Map<String, String> analyzeText(String text) {
        CoreDocument document = new CoreDocument(text);
        pipeline.annotate(document);

        Map<String, String> entities = new HashMap<>();
        for (CoreEntityMention em : document.entityMentions()) {
            entities.put(em.text(), em.entityType());
        }
        return entities;
    }
}
