package com.github.translocathor.portalsoundboard.grabber;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.FilenameUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final String LOCALE = "de";

    public static void main(String[] args) throws Exception {

        Main m = new Main();
        //m.start();
        List<Category> categories = m.loadCategories();
        m.test(categories);
    }

    private List<Category> loadCategories() throws IOException {
        String url = "https://theportalwiki.com/wiki/Turret_voice_lines/" + LOCALE;
        System.out.println("Loading all wav files from " + url);
        Document doc = Jsoup.connect(url).get();

        List<Sound> sounds = new ArrayList<>();
        // Download all wav files
        Elements links = doc.select("a[href]"); // a with href
        links.forEach(link -> {
            String href = link.attr("href");
            if (href.endsWith(".wav")) {
                String fileName = getFileName(href);
                try {
                    String resourceName = link.text();
                    download(href, fileName);
                    sounds.add(Sound.createFrom(getResourceId(fileName.toLowerCase()), resourceName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        List<Category> categories = new ArrayList<>();
        categories.add(Category.createFrom("Turrets", sounds));
        return categories;
    }

    private static String getFileName(String link) {
        String[] split = link.split("/");
        return split[split.length - 1];
    }

    private static String getResourceId(String fileName) {
        fileName = FilenameUtils.removeExtension(fileName);
        System.out.println("fileName: " + fileName);
        return fileName;
    }

    private static void download(String imageLocation, String targetFileName) throws IOException {

        //Open a URL Stream
        Connection.Response resultImageResponse = Jsoup.connect(imageLocation).ignoreContentType(true).execute();

        // output here
        File targetFile = new File(System.getProperty("user.dir") + "\\app\\src\\main\\res\\raw\\" + targetFileName.toLowerCase());
        System.out.println("Downloading  " + imageLocation + " --> " + targetFile);
        targetFile.getParentFile().mkdirs();
        FileOutputStream out = (new FileOutputStream(targetFile));
        out.write(resultImageResponse.bodyAsBytes());  // resultImageResponse.body() is where the image's contents are.
        out.close();
    }

    private void test(List<Category> categories) throws IOException, TemplateException {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_26);
        configuration.setClassForTemplateLoading(this.getClass(), "/com/github/translocathor/portalsoundboard/grabber");

        Template template = configuration.getTemplate("SoundResources.ftl");

        // Build the data-model
        String className = "SoundProviderTest";
        Map<String, Object> data = new HashMap<>();
        data.put("packageName", "com.github.translocathor.portalsoundboard.loader");
        data.put("imports", new String[]{
                "com.github.translocathor.portalsoundboard.R",
                "com.github.translocathor.portalsoundboard.model.Category",
                "com.github.translocathor.portalsoundboard.model.Sound",
                "java.util.ArrayList",
                "java.util.List"
        });
        data.put("classname", className);

//        List<Category> categories = new ArrayList<>();
        data.put("categories", categories);

        // Write processed data to the provided writer
        StringWriter writer = new StringWriter();
        Writer fileWriter = new FileWriter(System.getProperty("user.dir") + "\\app\\src\\main\\java\\com\\github\\translocathor\\portalsoundboard\\loader\\" + className + ".java");
        template.process(data, fileWriter);
        writer.flush();
        String result = writer.getBuffer().toString();
        System.out.println(result);
    }
}
