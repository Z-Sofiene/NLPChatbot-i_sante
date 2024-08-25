package tn.essat.nlpchatbot.service;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class Pipeline {
    private static final Properties properties;
    private static final String PROPERTIES_NAME = "tokenize,ssplit,pos,lemma,ner";
    private static StanfordCoreNLP stanfordCoreNLP;

    static {
        properties = new Properties();
        properties.setProperty("annotators", PROPERTIES_NAME);
    }

    @Bean(name = "coreNLP")
    public StanfordCoreNLP stanfordCoreNLP() {
        if (stanfordCoreNLP == null) {
            synchronized (Pipeline.class) {
                if (stanfordCoreNLP == null) {
                    stanfordCoreNLP = new StanfordCoreNLP(properties);
                }
            }
        }
        return stanfordCoreNLP;
    }
}