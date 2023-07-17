package me.nyaruko166.nyarukosplugincollection.utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;

import static me.nyaruko166.nyarukosplugincollection.NyarukosPluginCollection.plugin;

public class JsonStorage<T> {
    Gson gson = new Gson();
    String path = plugin.getDataFolder().getPath();

    public void writeToJson(T obj, String fileName) {
        try (FileWriter fw = new FileWriter(path + "/" + fileName + ".json")) {
            fw.write(gson.toJson(obj));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T readJson(String fileName) {
        T obj;
        try (FileReader fr = new FileReader(path + "/" + fileName + ".json")) {
            Type type = new TypeToken<T>() {
            }.getType();
            obj = gson.fromJson(fr, type);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
}
