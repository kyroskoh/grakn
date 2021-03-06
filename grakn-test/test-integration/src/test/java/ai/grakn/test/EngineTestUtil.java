/*
 * Grakn - A Distributed Semantic Database
 * Copyright (C) 2016  Grakn Labs Limited
 *
 * Grakn is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Grakn is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Grakn. If not, see <http://www.gnu.org/licenses/gpl.txt>.
 */
package ai.grakn.test;

import ai.grakn.GraknConfigKey;
import ai.grakn.engine.GraknEngineConfig;
import java.io.IOException;
import java.net.ServerSocket;

/**
 * <p>
 *     Sets up a test grakn engine
 * </p>
 *
 * <p>
 *     Sets up a grakn engine for testing purposes.
 * </p>
 * 
 * @author borislav
 *
 */
public abstract class EngineTestUtil {

    /**
     * Create a configuration for use in tests, using random ports.
     */
    static GraknEngineConfig createTestConfig() {
        GraknEngineConfig config = GraknEngineConfig.create();
        Integer serverPort = getEphemeralPort();
        config.setConfigProperty(GraknConfigKey.SERVER_PORT, serverPort);
        return config;
    }

    private static int getEphemeralPort() {
        try (ServerSocket socket = new ServerSocket(0)) {
            return socket.getLocalPort();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
