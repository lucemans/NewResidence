package nl.lucemans.newresidence.lang;

import org.bukkit.configuration.file.FileConfiguration;

/*
 * Created by Lucemans at 06/05/2018
 * See https://lucemans.nl
 */
public class Lang {

    public static FileConfiguration config;

    public enum lang {
        NOPERMISSION("noperm"), CREATE("create"), ERROR("error"), PREFIX("prefix"), BOOT("boot");

        private final String config;
        lang(String config) {
            this.config = config;
        }
        public String getValue() {
            return config;
        }
    }

    public static String get(lang lang) {
        if (config.contains(getPath(lang))) {
            String res = (String) config.get(getPath(lang));
            if (res.contains("%prefix%") && lang != Lang.lang.PREFIX)
                res = res.replace("%prefix%", get(Lang.lang.PREFIX));
            return res;
        }
        return "LANG NOT FOUND";
    }

    public static String getPath(lang lang) {
        return lang.getValue();
    }

}
