/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
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
 * </p>
 */

package com.dangdang.ddframe.job.lite.integrate.std.script;

import com.dangdang.ddframe.job.api.type.script.api.ScriptJob;
import com.dangdang.ddframe.job.api.type.dataflow.api.DataflowJobConfiguration;
import com.dangdang.ddframe.job.api.type.script.api.ScriptJobConfiguration;
import com.dangdang.ddframe.job.lite.api.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.integrate.AbstractBaseStdJobAutoInitTest;
import com.dangdang.ddframe.job.lite.integrate.WaitingUtils;
import com.dangdang.ddframe.job.lite.internal.config.LiteJobConfigurationGsonFactory;
import com.dangdang.ddframe.job.lite.util.ScriptElasticJobUtil;
import com.google.common.base.Optional;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public final class ScriptElasticJobTest extends AbstractBaseStdJobAutoInitTest {
    
    public ScriptElasticJobTest() {
        super(ScriptJob.class, Optional.<DataflowJobConfiguration.DataflowType>absent());
    }
    
    @Test
    public void assertJobInit() throws IOException {
        ScriptElasticJobUtil.buildScriptCommandLine();
        WaitingUtils.waitingShortTime();
        String scriptCommandLine = ((ScriptJobConfiguration) getLiteJobConfig().getJobConfig()).getScriptCommandLine();
        LiteJobConfiguration liteJobConfig = LiteJobConfigurationGsonFactory.getGson().fromJson(getRegCenter().get("/" + getJobName() + "/config"), LiteJobConfiguration.class);
        assertThat(((ScriptJobConfiguration) liteJobConfig.getJobConfig()).getScriptCommandLine(), is(scriptCommandLine));
    }
}
