/*
 * Copyright 2018 natanbc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.natanbc.lavadsp.natives;

import com.sedmelluq.lava.common.natives.NativeLibraryLoader;

public class TremoloNativeLibLoader {
    private static final NativeLibraryLoader LOADER = NativeLibraryLoader.create(TremoloNativeLibLoader.class, "tremolo");
    private static volatile boolean loaded = false;
    private static volatile boolean criticalNativesAvailable;

    public static void loadTremoloLibrary() {
        if(loaded) return;
        LOADER.load();
        criticalNativesAvailable = TremoloLibrary.criticalMethodsAvailable();
        loaded = true;
    }

    public static boolean isLoaded() {
        return loaded;
    }

    public static boolean areCriticalNativesAvailable() {
        loadTremoloLibrary();
        return criticalNativesAvailable;
    }
}
