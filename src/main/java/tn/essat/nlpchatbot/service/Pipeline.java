package tn.essat.nlpchatbot.service;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

import java.util.Set;


@Service
public class Pipeline {

    private final StanfordCoreNLP stanfordCoreNLP;

    @Autowired
    public Pipeline(StanfordCoreNLP stanfordCoreNLP) {
        this.stanfordCoreNLP = stanfordCoreNLP;
    }

    public Set<String> extractEntities(String text) {
        Set<String> entities = new HashSet<>();

        Annotation annotation = new Annotation(text);

        // Annotate the text using StanfordCoreNLP
        stanfordCoreNLP.annotate(annotation);

        // Extract named entities
        for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                String ner = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                if (!"O".equals(ner)) { // "O" denotes no entity
                    entities.add(token.word());
                }
            }
        }

        return entities;
    }
}
