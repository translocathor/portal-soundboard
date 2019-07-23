package com.github.translocathor.portalsoundboard.grabber

import freemarker.template.Configuration
import freemarker.template.Template
import freemarker.template.TemplateException
import org.apache.commons.io.FilenameUtils
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

import java.io.*
import java.util.ArrayList
import java.util.HashMap

class Main {

    @Throws(IOException::class)
    private fun loadCategories(): List<Category> {
        val url = "https://theportalwiki.com/wiki/Turret_voice_lines/$LOCALE"
        println("Loading all wav files from $url")
        val doc = Jsoup.connect(url).get()

        val sounds = ArrayList<Sound>()
        // Download all wav files
        val links = doc.select("a[href]") // a with href
        links.forEach { link ->
            val href = link.attr("href")
            if (href.endsWith(".wav")) {
                val fileName = getFileName(href)
                try {
                    val resourceName = link.text()
                    download(href, fileName)
                    sounds.add(Sound.createFrom(getResourceId(fileName.toLowerCase()), resourceName))
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }
        }
        val categories = ArrayList<Category>()
        categories.add(Category.createFrom("Turrets", sounds))
        return categories
    }

    @Throws(IOException::class, TemplateException::class)
    private fun test(categories: List<Category>) {

        val configuration = Configuration(Configuration.VERSION_2_3_26)
        configuration.setClassForTemplateLoading(this.javaClass, "/com/github/translocathor/portalsoundboard/grabber")

        val template = configuration.getTemplate("SoundResources.ftl")

        // Build the data-model
        val className = "SoundProviderTest"
        val data = HashMap<String, Any>()
        data["packageName"] = "com.github.translocathor.portalsoundboard.loader"
        data["imports"] = arrayOf(
            "com.github.translocathor.portalsoundboard.R",
            "com.github.translocathor.portalsoundboard.model.Category",
            "com.github.translocathor.portalsoundboard.model.Sound",
            "java.util.ArrayList",
            "java.util.List"
        )
        data["classname"] = className

        //        List<Category> categories = new ArrayList<>();
        data["categories"] = categories

        // Write processed data to the provided writer
        val writer = StringWriter()
        val fileWriter =
            FileWriter(System.getProperty("user.dir") + "\\app\\src\\main\\java\\com\\github\\translocathor\\portalsoundboard\\loader\\" + className + ".java")
        template.process(data, fileWriter)
        writer.flush()
        val result = writer.buffer.toString()
        println(result)
    }

    companion object {

        private val LOCALE = "de"

        @Throws(Exception::class)
        @JvmStatic
        fun main(args: Array<String>) {

            val m = Main()
            //m.start();
            val categories = m.loadCategories()
            m.test(categories)
        }

        private fun getFileName(link: String): String {
            val split = link.split("/".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()
            return split[split.size - 1]
        }

        private fun getResourceId(fileName: String): String {
            val resourceId = FilenameUtils.removeExtension(fileName)
            println("resourceId: $resourceId")
            return resourceId
        }

        @Throws(IOException::class)
        private fun download(imageLocation: String, targetFileName: String) {

            //Open a URL Stream
            val resultImageResponse = Jsoup.connect(imageLocation).ignoreContentType(true).execute()

            // output here
            val targetFile =
                File(System.getProperty("user.dir") + "\\app\\src\\main\\res\\raw\\" + targetFileName.toLowerCase())
            println("Downloading  $imageLocation --> $targetFile")
            targetFile.parentFile.mkdirs()
            val out = FileOutputStream(targetFile)
            out.write(resultImageResponse.bodyAsBytes())  // resultImageResponse.body() is where the image's contents are.
            out.close()
        }
    }
}
