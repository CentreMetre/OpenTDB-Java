package dev.centremetre.model;

import java.util.HashMap;
import java.util.Map;
//Todo review if needed. i think not because of url builder
public class ParamsTemplate
{
    public static Map<String, String> getTemplate()
    {
        Map<String, String> template = new HashMap<>();
        template.put("amount", null);
        template.put("type", null);
        template.put("difficulty", null);
        template.put("category", null);
        template.put("encoding", null);
        return template;
    }
}
