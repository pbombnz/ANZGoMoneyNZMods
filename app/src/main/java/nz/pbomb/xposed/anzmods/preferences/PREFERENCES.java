package nz.pbomb.xposed.anzmods.preferences;

public final class PREFERENCES {
    public static final class DEFAULT_VALUES {
        public static final class ASB {
            public static final boolean ROOT_DETECTION = true;
        }

        public static final class ANZ {
            public static final boolean ROOT_DETECTION = true;
            public static final boolean SPOOF_DEVICE = false;
            public static final String SPOOF_DEVICE_CHOOSER = "Samsung Galaxy Note 3 (4.4.2)";
            public static final boolean SCREENSHOT_ENABLED = false;
        }

        /*public static final class SEMBLE {
            public static final boolean ROOT_DETECTION = true;
            public static final boolean SPOOF_DEVICE = false;
            public static final String SPOOF_DEVICE_CHOOSER = "Samsung Galaxy Note 3 (4.4.2)";
            public static final boolean MM_SUPPORT = true;
        }*/

        public static final class TVNZ {
            public static final boolean ROOT_DETECTION = true;
            public static final boolean HDMI_DETECTION = true;
        }

        public static final class TV3NOW {
            public static final boolean ROOT_DETECTION = true;
        }


        public static final class MAIN {
            public static final boolean DEBUG = true;
        }
    }

    public static final class KEYS {
        public static final class ASB {
            public static final String ROOT_DETECTION = "asbRootDetection";
        }

        public static final class ANZ {
            public static final String ROOT_DETECTION = "anzRootDetection";
            public static final String SPOOF_DEVICE = "anzSpoofDevice";
            public static final String SPOOF_DEVICE_CHOOSER = "anzSpoofDeviceChooser";
            public static final String SCREENSHOT_ENABLED = "anzEnableScreenshots";
        }

        /*public static final class SEMBLE {
            public static final String ROOT_DETECTION = "sembleRootDetection";
            public static final String SPOOF_DEVICE = "sembleSpoofDevice";
            public static final String SPOOF_DEVICE_CHOOSER = "sembleSpoofDeviceChooser";
            public static final String MM_SUPPORT = "sembleOSSupport";
        }*/

        public static final class TVNZ {
            public static final String ROOT_DETECTION = "tvnzRootDetection";
            public static final String HDMI_DETECTION = "tvnzHdmiDetection";
        }

        public static final class TV3NOW {
            public static final String ROOT_DETECTION = "tv3nowRootDetection";
        }

        public static final class MAIN {
            public static final String ASB = "asbPrefs";
            public static final String ANZ = "anzPrefs";
            //public static final String SEMBLE = "semblePrefs";
            public static final String TVNZ = "tvnzPrefs";
            public static final String TV3NOW = "tv3nowPrefs";

            public static final String DEBUG = "debug";
            public static final String HELP = "help";
        }
    }
}
