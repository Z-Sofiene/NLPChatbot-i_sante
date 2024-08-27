package tn.essat.nlpchatbot.service;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class WebServiceMapping {
    public List<String> WebServices() {
        List<String> listWebServices = new ArrayList<>();
        String packageName = "tn.i_sante.bpo.chatbot";

        Reflections r = new Reflections(packageName);
        Set<Class<?>> controllers = r.getTypesAnnotatedWith(RestController.class);
        controllers.addAll(r.getTypesAnnotatedWith(Controller.class));

        System.out.println("Controllers found: " + controllers.size());

        for (Class<?> c : controllers) {
            RequestMapping classRequestMapping = c.getAnnotation(RequestMapping.class);
            String requestMapping = "";
            if (classRequestMapping != null) {
                requestMapping = getUrl(classRequestMapping.value(), classRequestMapping.path());
            }
            Method[] tabMethodes = c.getDeclaredMethods();
            for (Method m : tabMethodes) {
                if (m.isAnnotationPresent(GetMapping.class)) {
                    GetMapping mapping = m.getAnnotation(GetMapping.class);
                    String webService = requestMapping + getUrl(mapping.value(), mapping.path());
                    listWebServices.add(webService);
                    System.out.println(webService);
                }
            }
        }

        if (listWebServices.isEmpty()) {
            System.out.println("No web service found.");
        }

        return listWebServices;
    }


    private static String getUrl(String[] values, String[] paths) {
        if (values.length > 0) {
            return String.join(", ", values);
        }
        return paths.length > 0 ? String.join(", ", paths) : "";
    }
}
